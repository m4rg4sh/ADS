package P06_Graph;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class AdjacencyMatrixGraph implements UndirectedGraph {



    public AdjacencyMatrixGraph(String filePath) {
        importFromFile(filePath);
    }

    public AdjacencyMatrixGraph() {

    }

    @Override
    public void importFromFile(String filepath) {

    }

    @Override
    public int getNumberOfVertices() {
        return 0;
    }

    @Override
    public int getNumberOfEdges() {
        return 0;
    }

    @Override
    public String getListOfVertices() {
        return null;
    }

    @Override
    public String getListOfEdges(String vertice) {
        return null;
    }
}
