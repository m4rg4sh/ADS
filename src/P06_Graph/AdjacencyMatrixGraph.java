package P06_Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class AdjacencyMatrixGraph implements UndirectedGraph {
    private boolean isWeighted;
    private int[][] matrix;

    /**
     * creates a graph.
     * @param filePath file to import the graph from.
     */
    public AdjacencyMatrixGraph(String filePath) {
        matrix = new int[0][0];
        if(filePath != null && !filePath.equals("")) {
            importFromFile(filePath);
        }
    }

    /**
     * creates an empty graph.
     */
    public AdjacencyMatrixGraph() {
        this("");
    }

    /**
     * Imports a graph from a file.
     * The graph has to be formated as a "verticeslist" optionally with weights after each edge.
     * @param filepath The path to the file which will be imported
     */
    @Override
    public void importFromFile(String filepath) {
        ArrayList<Integer> values = CSVReader.readFile(filepath);
        if (values.size() > 0) {
            matrix = new int[values.get(0)][values.get(0)];
        }

        if ((values.size()-2)/3 == values.get(1)) {
            isWeighted = true;
        } else if ((values.size()-2)/2 == values.get(1)) {
            isWeighted = false;
        } else {
            throw new RuntimeException("Wrong number of edge descriptions.");
        }

        for (int i = 2;i < values.size();i++){
            if (isWeighted) {
                matrix[values.get(i)][values.get(++i)] = values.get(++i);
            } else {
                matrix[values.get(i)][values.get(++i)] = 1;
            }
        }
    }

    /**
     * @return number of vertices in the graph.
     */
    @Override
    public int getNumberOfVertices() {
        return matrix.length;
    }

    /**
     * @return number of edges in the graph.
     */
    @Override
    public int getNumberOfEdges() {
        int counter = 0;
        for(int[] row : matrix){
            for (int edge : row){
                if (edge != 0) {
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * @return a list of the vertex numbers in the graph.
     */
    @Override
    public ArrayList<Integer> getListOfVertices() {
        ArrayList<Integer> list = new ArrayList();
        if (matrix.length > 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * @param vertex the vertex to check for edges
     * @return either a list of vertices that are connected to the given vertex. or a list of arrays including
     * the vertices and the weight of the corresponding edge
     */
    @Override
    public ArrayList<int[]> getListOfEdges(int vertex) throws VertexNotFoundException{
        if (vertex >= matrix.length) {
            throw new VertexNotFoundException();
        }
        ArrayList<int[]> list = new ArrayList<>();

        int targetVertex = 0;
        for (int weight : matrix[vertex]){
            if (weight != 0) {
                if (isWeighted) {
                    list.add(new int[] {targetVertex, weight});
                } else {
                    list.add(new int[] {targetVertex});
                }
            }
            targetVertex++;
        }
        return list;
    }
}