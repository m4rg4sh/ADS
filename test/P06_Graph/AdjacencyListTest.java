package P06_Graph;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class AdjacencyListTest {

    @Test
    public void numberOfUnweightedVerticesForEmptyGraph(){
        UndirectedGraph emptyGraph = new AdjacencyListGraph();
        assertEquals(0,emptyGraph.getNumberOfVertices());
    }

    @Test
    public void listOfUnweightedVerticesInEmptyGraph(){
        UndirectedGraph emptyGraph = new AdjacencyListGraph();
        assertEquals(new ArrayList(),emptyGraph.getListOfVertices());
    }

    @Test
    public void numberOfUnweightedEdgesForEmptyGraph(){
        UndirectedGraph emptyGraph = new AdjacencyListGraph();
        assertEquals(0,emptyGraph.getNumberOfEdges());
    }

    @Test(expected=VertexNotFoundException.class)
    public void listOfUnweightedEdgesForEmptyGraph() throws VertexNotFoundException{
        UndirectedGraph emptyGraph = new AdjacencyListGraph();
        emptyGraph.getListOfEdges(0);
    }

    @Test
    public void numberOfUnweightedVerticesForOneItem(){
        UndirectedGraph graph = new AdjacencyListGraph("P06_Graph/singleVertex.csv");
        assertEquals(1,graph.getNumberOfVertices());
    }

    @Test
    public void listOfUnweightedVerticesForOneItem(){
        ArrayList<Integer> expectedResult = new ArrayList();
        expectedResult.add(0);
        UndirectedGraph graph = new AdjacencyListGraph("P06_Graph/singleVertex.csv");
        assertEquals(expectedResult,graph.getListOfVertices());
    }

    @Test
    public void numberOfUnweightedEdgesForOneItem(){
        UndirectedGraph graph = new AdjacencyListGraph("P06_Graph/singleVertex.csv");
        assertEquals(0,graph.getNumberOfEdges());
    }

    @Test
    public void listOfUnweightedEdgesForOneItem()throws VertexNotFoundException{
        UndirectedGraph graph = new AdjacencyListGraph("P06_Graph/unweightedGraph.csv");
        assertEquals(1,graph.getListOfEdges(0).get(0)[0]);
    }

    @Test
    public void numberOfUnweightedVerticesForManyItems(){
        UndirectedGraph graph = new AdjacencyListGraph("P06_Graph/unweightedGraph.csv");
        assertEquals(3,graph.getNumberOfVertices());
    }

    @Test
    public void listOfUnweightedVerticesForManyItems(){
        ArrayList<Integer> expectedResult = new ArrayList();
        expectedResult.add(0);
        expectedResult.add(1);
        expectedResult.add(2);

        UndirectedGraph graph = new AdjacencyListGraph("P06_Graph/unweightedGraph.csv");
        assertEquals(expectedResult,graph.getListOfVertices());
    }

    @Test
    public void numberOfUnweightedEdgesForManyItems(){
        UndirectedGraph graph = new AdjacencyListGraph("P06_Graph/unweightedGraph.csv");
        assertEquals(2,graph.getNumberOfEdges());
    }

    @Test
    public void listOfUnweightedEdgesForManyItems()throws VertexNotFoundException{
        ArrayList<Integer> expectedResult = new ArrayList();
        expectedResult.add(new Integer(1));
        expectedResult.add(new Integer(2));

        UndirectedGraph graph = new AdjacencyListGraph("P06_Graph/unweightedGraph.csv");
        assertEquals(expectedResult.get(0),(Integer)graph.getListOfEdges(0).get(0)[0]);
        assertEquals(expectedResult.get(1),(Integer)graph.getListOfEdges(0).get(1)[0]);
    }

    @Test
    public void numberOfWeightedVerticesForManyItems(){
        UndirectedGraph graph = new AdjacencyListGraph("P06_Graph/weightedGraph.csv");
        assertEquals(3,graph.getNumberOfVertices());
    }

    @Test
    public void listOfWeightedVerticesForManyItems(){
        ArrayList<Integer> expectedResult = new ArrayList();
        expectedResult.add(0);
        expectedResult.add(1);
        expectedResult.add(2);

        UndirectedGraph graph = new AdjacencyListGraph("P06_Graph/weightedGraph.csv");
        assertEquals(expectedResult,graph.getListOfVertices());
    }

    @Test
    public void numberOfWeightedEdgesForManyItems(){
        UndirectedGraph graph = new AdjacencyListGraph("P06_Graph/weightedGraph.csv");
        assertEquals(2,graph.getNumberOfEdges());
    }

    @Test
    public void listOfWeightedEdgesForManyItems()throws VertexNotFoundException{
        ArrayList<Integer[]> expectedResult = new ArrayList();
        expectedResult.add(new Integer[] {1});
        expectedResult.add(new Integer[] {2});

        UndirectedGraph graph = new AdjacencyListGraph("P06_Graph/weightedGraph.csv");
        assertEquals(1,graph.getListOfEdges(0).get(0)[0]);
        assertEquals(5,graph.getListOfEdges(0).get(0)[1]);
        assertEquals(2,graph.getListOfEdges(0).get(1)[0]);
        assertEquals(10,graph.getListOfEdges(0).get(1)[1]);
    }
}
