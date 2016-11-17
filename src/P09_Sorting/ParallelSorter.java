package P09_Sorting;

/**
 * @author Stefan Epprecht &lt;epprest1@students.zhaw.ch&gt;
 * @author Lawrence Markwalder &lt;markwlaw@students.zhaw.ch&gt;
 * @author Luca Egli &lt;eglilu01@students.zhaw.ch&gt;
 */
public class ParallelSorter implements Runnable {
    private int l;
    private int u;
    private int[] numbers;

    public ParallelSorter(int[] number, int l, int u) {
        this.numbers = number;
        this.l = l;
        this.u = u;
    }

    @Override
    public void run() {
        Sorter.quickSortTurbo(numbers,l,u);
    }
}
