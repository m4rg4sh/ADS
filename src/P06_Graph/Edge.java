package P06_Graph;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class Edge {

    private int target;

    public Edge(int target){
        this.target = target;
    }

    public int getTarget() {
        return target;
    }
}
