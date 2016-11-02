package P06_Graph;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class WeightedEdge extends Edge {
    private int weight;

    public WeightedEdge(int target, int weight){
        super(target);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

}
