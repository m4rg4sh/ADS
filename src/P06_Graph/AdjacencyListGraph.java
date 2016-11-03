package P06_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class AdjacencyListGraph implements UndirectedGraph {
    private boolean isWeighted;
    private LinkedList<LinkedList<int[]>> listOfVertices;

    /**
     * creates a graph.
     * @param filePath file to import the graph from.
     */
    public AdjacencyListGraph(String filePath){
        listOfVertices = new LinkedList<>();
        if(filePath != null && !filePath.equals("")) {
            importFromFile(filePath);
        }
    }

    /**
     * creates an empty graph
     */
    public AdjacencyListGraph(){
        this("");
    }

    /**
     * Imports a undirected graph from a file. The graph can be weighted or not.
     *
     * @param filepath The path to the file which will be imported
     */
    @Override
    public void importFromFile(String filepath) {
        ArrayList<Integer> values = CSVReader.readFile(filepath);
        for (int index = 0;index < values.get(0);index++){
            listOfVertices.add(new LinkedList<>());
        }
        if ((values.size()-2)/3 == values.get(1)) {
            isWeighted = true;
        } else if ((values.size()-2)/2 == values.get(1)) {
            isWeighted = false;
        } else {
            throw new RuntimeException("Wrong number of edge descriptions.");
        }

        for (int i = 2;i < values.size();i++){
            int source = values.get(i);
            int target = values.get(++i);
            int weight = isWeighted? values.get(++i) : 1;
            listOfVertices.get(source).add(new int[]{target,weight});
            listOfVertices.get(target).add(new int[]{source,weight});

        }
    }

    /**
     * @return The number of vertices in the graph.
     */
    @Override
    public int getNumberOfVertices() {
        return listOfVertices.size();
    }

    /**
     * @return The number of edges in the graph.
     */
    @Override
    public int getNumberOfEdges() {
        int counter = 0;
        for (LinkedList<int[]> listOfEdges : listOfVertices) {
            counter += listOfEdges.size();
        }
        return counter / 2;
    }

    /**
     * @return Returns a list of all the vertices in the graph.
     */
    @Override
    public ArrayList<Integer> getListOfVertices() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int index = 0; index < listOfVertices.size(); index++) {
            list.add(index);
        }
        return list;
    }

    /**
     * Returns a list of edges that are connected to the given vertice.
     * If the graph is weighted the weight of each edge is also included.
     *
     * @param vertex the vertex to check for edges
     * @return list of edges connected to the vertice.
     */
    @Override
    public ArrayList<int[]> getListOfEdges(int vertex) throws VertexNotFoundException {
        if (vertex >= listOfVertices.size()) {
            throw new VertexNotFoundException();
        }

        return new ArrayList<>(listOfVertices.get(vertex));
    }
}
