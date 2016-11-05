package P07_Dijkstra;
import P06_Graph.*;

import java.util.ArrayList;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 *
 * Sources:
 * - Saake/Sattler
 */
public class Dijkstra {
    static final int NO_PREDECESSOR = -1;
    private static final int DISTANCE_INDEX = 0;
    private static final int PREDECESSOR_INDEX = 1;
    private static final int VERTEX_INDEX = 0;
    private static final int WEIGHT_INDEX = 1;

    private ArrayList<Integer> list;
    private Integer[][] resultTable;
    private UndirectedGraph graph;
    private int startVertex;

    public Dijkstra(UndirectedGraph graph, int startVertex) {
        this.graph = graph;
        this.startVertex = startVertex;
        resultTable = new Integer[graph.getNumberOfVertices()][2];
        list = new ArrayList<>();
    }

    public static void main (String[] args) throws VertexNotFoundException {
        Dijkstra dijkstra = new Dijkstra(new AdjacencyListGraph("P07_Dijkstra/samplegraph.csv"), 0);
        dijkstra.dijkstrasAlgorithm();
    }

    public Integer[][] dijkstrasAlgorithm() throws VertexNotFoundException {

        for(int vertex : graph.getListOfVertices()){
            resultTable[vertex][DISTANCE_INDEX] = Integer.MAX_VALUE;
            list.add(vertex);
        }
        resultTable[startVertex][DISTANCE_INDEX] = 0;
        resultTable[startVertex][PREDECESSOR_INDEX] = NO_PREDECESSOR;

        while (!list.isEmpty()){
            int currentVertex = extractMinimum();
            for (int[] edge : graph.getListOfEdges(currentVertex)){
                if(resultTable[currentVertex][DISTANCE_INDEX] + edge[WEIGHT_INDEX]
                        < resultTable[edge[VERTEX_INDEX]][DISTANCE_INDEX]) {
                    resultTable[edge[VERTEX_INDEX]][DISTANCE_INDEX]
                            = resultTable[currentVertex][DISTANCE_INDEX] + edge[WEIGHT_INDEX];
                    resultTable[edge[VERTEX_INDEX]][PREDECESSOR_INDEX] = currentVertex;
                }
            }
        }
        return resultTable;
    }

    private int extractMinimum(){
        int minimum = Integer.MAX_VALUE;
        int shortestPath = -1;
        for (int vertex : list) {
            if (resultTable[vertex][DISTANCE_INDEX] < minimum) {
                minimum = resultTable[vertex][DISTANCE_INDEX];
                shortestPath = vertex;
            }
        }
        list.remove(new Integer(shortestPath));
        return shortestPath;
    }
}
