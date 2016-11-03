package P07_Dijkstra;

import P06_Graph.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class DistanceCalculator {

    public static void main (String[] args) throws VertexNotFoundException {
        UndirectedGraph graph = new AdjacencyMatrixGraph("P07_Dijkstra/samplegraph.csv");
        ArrayList<Integer> vertices = graph.getListOfVertices();
        ArrayList<String> knownEdges = new ArrayList<>();
        int distanceTotal = 0;

        for (int vertex : vertices) {
            ArrayList<int[]> edges = graph.getListOfEdges(vertex);
            for (int[] edge : edges) {
                if (!knownEdges.contains(vertex + "" + edge[0]) && !knownEdges.contains(edge[0] + "" + vertex)){
                    knownEdges.add(vertex + "" + edge[0]);
                    distanceTotal += edge[1];
                }
            }
        }

        System.out.println("Total distance: " + distanceTotal + "km");
    }

}
