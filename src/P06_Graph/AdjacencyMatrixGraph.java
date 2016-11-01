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
     * @param isWeighted whether the graph has weighted edges or not.
     */
    public AdjacencyMatrixGraph(String filePath, boolean isWeighted) {
        this.isWeighted = isWeighted;
        importFromFile(filePath);
    }

    /**
     * creates an empty graph.
     */
    public AdjacencyMatrixGraph() {
        matrix = new int[0][0];
        isWeighted = false;
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
        } else {
          matrix = new int[0][0];
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
    public List<Integer> getListOfVertices() {
        List list = new ArrayList();
        if (matrix.length > 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * @param vertex the vertex to check for edges
     * @return a list of vertices that are connected to the given vertex.
     */
    @Override
    public List<Integer[]> getListOfEdges(int vertex) throws VertexNotFoundException{
        if (vertex >= matrix.length) {
            throw new VertexNotFoundException();
        }

        List<Integer[]> list = new ArrayList<>();
        int column = 0;
        for (int i : matrix[vertex]){
            if (i != 0) {
                Integer[] tupel;
                if (isWeighted) {
                    tupel = new Integer[2];
                    tupel[1] = i;
                } else {
                    tupel = new Integer[1];
                }
                tupel[0] = column;
                list.add(tupel);
            }
            column++;
        }
        return list;
    }
}