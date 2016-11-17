package P09_Sorting;


/**
 * @author Stefan Epprecht &lt;epprest1@students.zhaw.ch&gt;
 * @author Lawrence Markwalder &lt;markwlaw@students.zhaw.ch&gt;
 * @author Luca Egli &lt;eglilu01@students.zhaw.ch&gt;
 */
public class PerformanceTest {

    public static final int SIZE = 10000;

    public static void main (String[] args) {
        int[] numbers = fillArray();
        long startTime;
        long endTime;
        System.out.println("Testing quickSortTurbo:");
        startTime = System.currentTimeMillis();
        Sorter.quickSortTurbo(numbers);
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
        numbers = fillArray();
        System.out.println("Testing quickSortParallel:");
        startTime = System.currentTimeMillis();
        Sorter.quickSortParallel(numbers);
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }

    private static int[] fillArray() {
        int[] numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = (int)(Math.random()*10000*Math.random());
        }
        return numbers;
    }
}
