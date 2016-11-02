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
    private LinkedList<LinkedList<P06_Graph.Edge>> listOfVertices;

    /**
     * creates a graph.
     * @param filePath file to import the graph from.
     * @param isWeighted whether the graph has weighted edges or not.
     */
    public AdjacencyListGraph(String filePath, boolean isWeighted){
        listOfVertices = new LinkedList<>();
        this.isWeighted = isWeighted;
        if(filePath != null && !filePath.equals("")) {
            importFromFile(filePath);
        }
    }

    /**
     * creates an empty graph
     */
    public AdjacencyListGraph(){
        this("",false);
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
        for (int i = 2;i < values.size();i++){
            if (isWeighted) {
                listOfVertices.get(values.get(i)).add(new WeightedEdge(values.get(++i),values.get(++i)));
            } else {
                listOfVertices.get(values.get(i)).add(new Edge(values.get(++i)));
            }
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
        for (LinkedList<P06_Graph.Edge> listOfEdges : listOfVertices) {
            for (P06_Graph.Edge edge : listOfEdges) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * @return Returns a list of all the vertices in the graph.
     */
    @Override
    public List<Integer> getListOfVertices() {
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
    public List getListOfEdges(int vertex) throws VertexNotFoundException {
        if (vertex >= listOfVertices.size()) {
            throw new VertexNotFoundException();
        }

        ArrayList list;
        if (isWeighted) {
            list = new ArrayList<Integer[]>();
        } else {
            list = new ArrayList<Integer>();
        }

        for (P06_Graph.Edge edge : listOfVertices.get(vertex)) {
            if (edge instanceof WeightedEdge) {
                list.add(new Integer[]{edge.getTarget(), ((WeightedEdge) edge).getWeight()});
            } else if (edge instanceof P06_Graph.Edge) {
                list.add(edge.getTarget());
            } else {
                throw new RuntimeException("Edge type unknown");
            }
        }
        return list;
    }
}
