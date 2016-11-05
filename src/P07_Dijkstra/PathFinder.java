package P07_Dijkstra;

import P06_Graph.AdjacencyListGraph;
import P06_Graph.UndirectedGraph;
import P06_Graph.VertexNotFoundException;

import java.util.ArrayList;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class PathFinder {
    private static ArrayList<Integer> path = new ArrayList<>();
    private static Integer[][] resultTable;

    public static void main(String args[]){
        findBestPath(City.Winterthur,City.Lugano,new AdjacencyListGraph("P07_Dijkstra/samplegraph.csv"));
    }

    public static void findBestPath(City start, City target, UndirectedGraph graph) {
        try {
            resultTable = new Dijkstra(graph,start.getId()).dijkstrasAlgorithm();
            System.out.println("I've found a path that is " + resultTable[target.getId()][0] + "km long.");
            createPath(target);
            System.out.println("The path is via:");
            for (int index = path.size()-1;index >= 0;index--){
                System.out.println(City.getName(path.get(index)));
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Your target is invalid");
        }
        catch (VertexNotFoundException e) {
            System.out.println("The start location is not present in the graph.");
        }

    }

    private static void createPath(City target) {
        int predecessor = target.getId();
        while (predecessor != Dijkstra.NO_PREDECESSOR){
            path.add(predecessor);
            predecessor = resultTable[predecessor][1];
        }
    }
}
