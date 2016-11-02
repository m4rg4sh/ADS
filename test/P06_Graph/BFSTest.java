package P06_Graph;

import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class BFSTest {
    @Test (expected = VertexNotFoundException.class)
    public void shouldHandleEmptyGraphCorrectly() throws VertexNotFoundException{
        UndirectedGraph emptyGraph = new AdjacencyMatrixGraph();
        BFS.search(emptyGraph,0);
    }

    @Test (expected = VertexNotFoundException.class)
    public void shouldHandleWrongVertexCorrectly() throws VertexNotFoundException{
        UndirectedGraph graph = new AdjacencyMatrixGraph("P06_Graph/singleVertex.csv");
        BFS.search(graph,7);
    }

    @Test
    public void shouldReturnCorrectListOfUnweightedVertices() throws VertexNotFoundException{
        UndirectedGraph graph = new AdjacencyMatrixGraph("P06_Graph/unweightedGraph.csv");
        ArrayList<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(0);
        expectedResult.add(1);
        expectedResult.add(2);
        assertEquals(expectedResult,BFS.search(graph,0));
    }
    @Test
    public void shouldReturnCorrectListOfWeightedVertices() throws VertexNotFoundException{
        UndirectedGraph graph = new AdjacencyMatrixGraph("P06_Graph/weightedGraph.csv");
        ArrayList<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(0);
        expectedResult.add(1);
        expectedResult.add(2);
        assertEquals(expectedResult,BFS.search(graph,0));
    }
}
