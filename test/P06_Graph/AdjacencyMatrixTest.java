package P06_Graph;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class AdjacencyMatrixTest {

    @Test
    public void numberOfUnweightedVerticesForEmptyGraph(){
        UndirectedGraph emptyGraph = new AdjacencyMatrixGraph();
        assertEquals(0,emptyGraph.getNumberOfVertices());
    }

    @Test
    public void listOfUnweightedVerticesInEmptyGraph(){
        UndirectedGraph emptyGraph = new AdjacencyMatrixGraph();
        assertEquals(new ArrayList(),emptyGraph.getListOfVertices());
    }

    @Test
    public void numberOfUnweightedEdgesForEmptyGraph(){
        UndirectedGraph emptyGraph = new AdjacencyMatrixGraph();
        assertEquals(0,emptyGraph.getNumberOfEdges());
    }

    @Test(expected=VertexNotFoundException.class)
    public void listOfUnweightedEdgesForEmptyGraph() throws VertexNotFoundException{
        UndirectedGraph emptyGraph = new AdjacencyMatrixGraph();
        emptyGraph.getListOfEdges(0);
    }

    @Test
    public void numberOfUnweightedVerticesForOneItem(){
        UndirectedGraph graph = new AdjacencyMatrixGraph("P06_Graph/singleVertex.csv", false);
        assertEquals(1,graph.getNumberOfVertices());
    }

    @Test
    public void listOfUnweightedVerticesForOneItem(){
        ArrayList<Integer> expectedResult = new ArrayList();
        expectedResult.add(0);
        UndirectedGraph graph = new AdjacencyMatrixGraph("P06_Graph/singleVertex.csv", false);
        assertEquals(expectedResult,graph.getListOfVertices());
    }

    @Test
    public void numberOfUnweightedEdgesForOneItem(){
        UndirectedGraph graph = new AdjacencyMatrixGraph("P06_Graph/singleVertex.csv", false);
        assertEquals(0,graph.getNumberOfEdges());
    }

    @Test
    public void listOfUnweightedEdgesForOneItem()throws VertexNotFoundException{
        UndirectedGraph graph = new AdjacencyMatrixGraph("P06_Graph/unweightedGraph.csv",false);
        assertEquals(1,graph.getListOfEdges(0).get(0));
    }

    @Test
    public void numberOfUnweightedVerticesForManyItems(){
        UndirectedGraph graph = new AdjacencyMatrixGraph("P06_Graph/unweightedGraph.csv",false);
        assertEquals(3,graph.getNumberOfVertices());
    }

    @Test
    public void listOfUnweightedVerticesForManyItems(){
        ArrayList<Integer> expectedResult = new ArrayList();
        expectedResult.add(0);
        expectedResult.add(1);
        expectedResult.add(2);

        UndirectedGraph graph = new AdjacencyMatrixGraph("P06_Graph/unweightedGraph.csv",false);
        assertEquals(expectedResult,graph.getListOfVertices());
    }

    @Test
    public void numberOfUnweightedEdgesForManyItems(){
        UndirectedGraph graph = new AdjacencyMatrixGraph("P06_Graph/unweightedGraph.csv",false);
        assertEquals(2,graph.getNumberOfEdges());
    }

    @Test
    public void listOfUnweightedEdgesForManyItems()throws VertexNotFoundException{
        ArrayList<Integer> expectedResult = new ArrayList();
        expectedResult.add(new Integer(1));
        expectedResult.add(new Integer(2));

        UndirectedGraph graph = new AdjacencyMatrixGraph("P06_Graph/unweightedGraph.csv",false);
        assertEquals(expectedResult.get(0),graph.getListOfEdges(0).get(0));
        assertEquals(expectedResult.get(1),graph.getListOfEdges(0).get(1));
    }

    @Test
    public void numberOfWeightedVerticesForManyItems(){
        UndirectedGraph graph = new AdjacencyMatrixGraph("P06_Graph/weightedGraph.csv",true);
        assertEquals(3,graph.getNumberOfVertices());
    }

    @Test
    public void listOfWeightedVerticesForManyItems(){
        ArrayList<Integer> expectedResult = new ArrayList();
        expectedResult.add(0);
        expectedResult.add(1);
        expectedResult.add(2);

        UndirectedGraph graph = new AdjacencyMatrixGraph("P06_Graph/weightedGraph.csv",true);
        assertEquals(expectedResult,graph.getListOfVertices());
    }

    @Test
    public void numberOfWeightedEdgesForManyItems(){
        UndirectedGraph graph = new AdjacencyMatrixGraph("P06_Graph/weightedGraph.csv",true);
        assertEquals(2,graph.getNumberOfEdges());
    }

    @Test
    public void listOfWeightedEdgesForManyItems()throws VertexNotFoundException{
        ArrayList<Integer[]> expectedResult = new ArrayList();
        expectedResult.add(new Integer[] {1});
        expectedResult.add(new Integer[] {2});

        UndirectedGraph graph = new AdjacencyMatrixGraph("P06_Graph/weightedGraph.csv",true);
        assertEquals(new Integer(1),((Integer[]) graph.getListOfEdges(0).get(0))[0]);
        assertEquals(new Integer(5),((Integer[]) graph.getListOfEdges(0).get(0))[1]);
        assertEquals(new Integer(2),((Integer[]) graph.getListOfEdges(0).get(1))[0]);
        assertEquals(new Integer(10),((Integer[]) graph.getListOfEdges(0).get(1))[1]);
    }
}
