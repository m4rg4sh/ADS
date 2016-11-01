package P06_Graph;

import java.util.List;

/**
 * This interface defines a undirected graph which has to implement core functionality of a graph.
 *
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
interface UndirectedGraph {
    /**
     * Imports a undirected graph from a file. The graph can be weighted or not.
     * @param filepath The path to the file which will be imported
     */
    void importFromFile(String filepath);

    /**
     * @return The number of vertices in the graph.
     */
    int getNumberOfVertices();

    /**
     * @return The number of edges in the graph.
     */
    int getNumberOfEdges();

    /**
     * @return Returns a list of all the vertices in the graph.
     */
    List getListOfVertices();

    /**
     * Returns a list of edges that are connected to the given vertice.
     * If the graph is weighted the weight of each edge is also included.
     * @param vertex the vertice to check for edges
     * @return list of edges connected to the vertice.
     */
    List<Integer[]> getListOfEdges(int vertex) throws VertexNotFoundException;
}
