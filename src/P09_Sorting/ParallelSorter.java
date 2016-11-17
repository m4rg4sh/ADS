package P09_Sorting;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class ParallelSorter extends Sorter implements Runnable {
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
        quickSortTurbo(numbers,l,u);
    }
}
