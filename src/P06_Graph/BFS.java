package P06_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class BFS {
    public static ArrayList<Integer> search(UndirectedGraph graph, int startVertex) throws VertexNotFoundException{
        ArrayList<Integer> returnList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        returnList.add(startVertex);

        while (!queue.isEmpty()) {
            for (int[] edge : graph.getListOfEdges(queue.remove())) {
                queue.add(edge[0]);
                returnList.add(edge[0]);
            }
        }
        return returnList;
    }
}
