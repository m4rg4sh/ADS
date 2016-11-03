package P07_Dijkstra;
import P06_Graph.*;

import java.util.*;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 *
 * Sources:
 * - Saake/Sattler
 * - https://stackoverflow.com/questions/3699141/how-to-sort-an-array-of-ints-using-a-custom-comparator
 */
public class Dijkstra {
    private ArrayList<Integer> list;
    private HashMap<Integer,Integer> resultMap;

    public static void main (String[] args) throws VertexNotFoundException{
        HashMap<Integer,Integer> map = new Dijkstra().run(new AdjacencyListGraph("P07_Dijkstra/samplegraph.csv"),1);
    }

    public HashMap<Integer,Integer> run(UndirectedGraph graph, int startVertex) throws VertexNotFoundException {
        resultMap = new HashMap<>();
        list = new ArrayList<>();

        for(int vertex : graph.getListOfVertices()){
            resultMap.put(vertex,Integer.MAX_VALUE);
        }
        resultMap.put(startVertex,0);
        list.addAll(graph.getListOfVertices());

        while (!list.isEmpty()){
            int currentVertex = extractMinimum();
            for (int[] edge : graph.getListOfEdges(currentVertex)){
                if(resultMap.get(currentVertex) + edge[1] < resultMap.get(edge[0])) {
                    resultMap.put(edge[0],resultMap.get(currentVertex) + edge[1]);
                }
            }
        }
        return resultMap;
    }

    private int extractMinimum(){
        int minimum = Integer.MAX_VALUE;
        int shortestPath = -1;
        for (int vertex : list) {
            if (resultMap.get(vertex) < minimum) {
                minimum = resultMap.get(vertex);
                shortestPath = vertex;
            }
        }
        list.remove(new Integer(shortestPath));
        return shortestPath;
    }
}
