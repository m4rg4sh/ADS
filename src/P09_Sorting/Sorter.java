package P09_Sorting;

import java.util.Arrays;

/**
 * @author Stefan Epprecht &lt;epprest1@students.zhaw.ch&gt;
 * @author Lawrence Markwalder &lt;markwlaw@students.zhaw.ch&gt;
 * @author Luca Egli &lt;eglilu01@students.zhaw.ch&gt;
 *
 * Source: Saake/Sattler for the insertionSort and quicksort algorithms
 */
public class Sorter {
	private static final int PARALLEL_THRESHOLD = 10;

	/**
	 * Sorts an array with the default sorting algorithm in the Arrays class
	 * @param numbers the array to be sorted
	 */
	public static void sort(int[] numbers) {
		if (numbers != null) Arrays.sort(numbers);	
	}

	/**
	 * Sorts an array with the insertion sort algorithm from Saake/Sattler
	 * @param numbers the array to be sorted
	 */
	public static void insertionSort(int[] numbers){
		if (numbers == null) return;
		insertionSort(numbers,0,numbers.length-1);
	}


	/**
	 * Sorts an array with the insertion sort algorithm from Saake/Sattler
	 * @param numbers the array to be sorted
	 * @param l lower bound index
	 * @param u upper bound index
	 */
	private static void insertionSort(int[] numbers,int l, int u){
		for (int i = l; i <= u;i++){
			int currentElement = numbers[i];
			boolean stop = false;
			int j = i-1;
			while (j >= 0 && !stop){
				if (numbers[j] > currentElement){
					numbers[j+1] = numbers[j];
					j--;
				} else {
					stop = true;
				}
			}
			numbers[j+1] = currentElement;
		}
	}

	/**
	 * Sorts an array with the quicksort algorithm from Saake/Sattler.
	 * The algorithm uses the element in the middle of the array as the starting pivot element.
	 * @param numbers the array to be sorted
	 */
	public static void quickSortClassic(int[] numbers){
		if (numbers == null) return;
		quickSortClassic(numbers,0,numbers.length-1);
	}

	/**
	 * Sorts an array with the quicksort algorithm from Saake/Sattler.
	 * The algorithm uses the element in the middle of the array as the starting pivot element.
	 * @param numbers the array to be sorted
	 * @param l lower bound index
	 * @param u upper bound index
	 */
	private static void quickSortClassic(int[] numbers, int l, int u){
		if (u > l) {
			int pivotPosition = l + ((u-l)/2);
			pivotPosition = divide(numbers,l,u,pivotPosition);
			quickSortClassic(numbers, l, pivotPosition-1);
			quickSortClassic(numbers, pivotPosition+1, u);
		}
	}

	/**
	 * Sorts an array with the quicksort algorithm from Saake/Sattler.
	 * The algorithm uses the median of the first, middle and last element of the array as the starting pivot element.
	 * @param numbers the array to be sorted
	 */
	public static void quickSortMedian(int[] numbers){
		if (numbers == null) return;
		int pivotPosition = indexOfMedian(numbers);
		pivotPosition = divide(numbers, 0, numbers.length - 1, pivotPosition);
		quickSortMedian(numbers, 0, pivotPosition - 1);
		quickSortMedian(numbers, pivotPosition + 1, numbers.length - 1);
	}

	/**
	 * Sorts an array with the quicksort algorithm from Saake/Sattler.
	 * The algorithm uses the median of the first, middle and last element of the array as the starting pivot element.
	 * @param numbers the array to be sorted
	 * @param l lower bound index
	 * @param u upper bound index
	 */
	private static void quickSortMedian(int[] numbers, int l, int u){
		if (u > l) {
			int pivotPosition = l + ((u-l)/2);
			pivotPosition = divide(numbers,l,u,pivotPosition);
			quickSortMedian(numbers, l, pivotPosition-1);
			quickSortMedian(numbers, pivotPosition+1, u);
		}
	}

	/**
	 * Sorts an array with the quicksort algorithm from Saake/Sattler.
	 * The algorithm uses the median of the first, middle and last element of the array as the starting pivot element.
	 * @param numbers the array to be sorted
	 */
	public static void quickSortTurbo(int[] numbers){
		if (numbers == null) return;
		int pivotPosition = indexOfMedian(numbers);
		pivotPosition = divide(numbers, 0, numbers.length - 1, pivotPosition);
		quickSortTurbo(numbers, 0, pivotPosition - 1);
		quickSortTurbo(numbers, pivotPosition + 1, numbers.length - 1);
	}

	/**
	 * Sorts an array with the quicksort algorithm from Saake/Sattler.
	 * The algorithm uses the median of the first, middle and last element of the array as the starting pivot element.
	 * @param numbers the array to be sorted
	 * @param l lower bound index
	 * @param u upper bound index
	 */
	protected static void quickSortTurbo(int[] numbers, int l, int u){
		if (u > l) {
			if (u-l > 500) {
				int pivotPosition = l + ((u-l)/2);
				pivotPosition = divide(numbers, l, u, pivotPosition);
				quickSortTurbo(numbers, l, pivotPosition - 1);
				quickSortTurbo(numbers, pivotPosition + 1, u);
			} else {
				insertionSort(numbers,l,u);
			}
		}
	}

	/**
	 * Sorts the elements in the array relative to the pivot element.
	 * All elements smaller than the pivot go to its left, larger elements to its right.
	 * Only includs elements between the lower and the upper bound
	 * @param numbers the array to be sorted
	 * @param l lower bound index
	 * @param u upper bound index
	 * @param pivotPosition current position of the pivot element in the array
	 * @return the new position of the pivot element
	 */
	private static int divide(int[] numbers, int l, int u, int pivotPosition){
		int pivotValue = numbers[pivotPosition];
		swap(numbers,u,pivotPosition);
		pivotPosition = l;
		for (int i = l; i < u;i++) {
			if (numbers[i] <= pivotValue) {
				int save = numbers[pivotPosition];
				numbers[pivotPosition] = numbers[i];
				numbers[i] = save;
				pivotPosition++;
			}
		}
		swap(numbers,u,pivotPosition);

		return pivotPosition;
	}

	/**
	 * swaps the position of two values in an array
	 * @param numbers the array
	 * @param index1 index of value 1
	 * @param index2 index of value 2
	 */
	private static void swap(int[] numbers, int index1, int index2) {
		int save = numbers[index1];
		numbers[index1] = numbers[index2];
		numbers[index2] = save;
	}

	/**
	 * calculates the median of the three indices
	 * Source: http://stackoverflow.com/a/19045659
	 * @param numbers the array that contains the elements

	 * @return index of the median element
	 */
	private static int indexOfMedian(int[] numbers){
		int a = numbers[0];
		int b = numbers[numbers.length/2];
		int c = numbers[numbers.length-1];
		int median = Math.max(Math.min(a,b), Math.min(Math.max(a,b),c));

		if (median == a) {
			return 0;
		} else if (median == b) {
			return numbers.length/2;
		} else if (median == c) {
			return numbers.length-1;
		} else {
			throw new RuntimeException("Incorrect median");
		}
	}

	/**
	 * Sorts an array using quickSortTurbo with an adequate number of parallel threads (1 or 2).
	 * @param numbers the array to sort
	 */
	public static void quickSortParallel(int [] numbers){
		if (numbers == null) return;
		int pivotPosition = indexOfMedian(numbers);
		pivotPosition = divide(numbers, 0, numbers.length - 1, pivotPosition);
		quickSortParallel(numbers, 0, pivotPosition - 1);
		quickSortParallel(numbers, pivotPosition + 1, numbers.length - 1);
	}

	/**
	 * Sorts an array using quickSortTurbo with an adequate number of parallel threads (1 or 2).
	 * @param numbers the array to sort
	 * @param l lower bound index
	 * @param u upper bound index
	 */
	private static void quickSortParallel(int[] numbers, int l, int u) {
		if (numbers.length > PARALLEL_THRESHOLD) {
			int pivotPosition = l + ((u-l)/2);
			pivotPosition = divide(numbers, l, u, pivotPosition);

			Thread t1 = new Thread(new ParallelSorter(numbers, l, pivotPosition - 1), "Sorter A");
			Thread t2 = new Thread(new ParallelSorter(numbers, pivotPosition + 1, u), "Sorter B");

			t1.start();
			t2.start();

			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
			}
		} else {
			quickSortTurbo(numbers);
		}
	}

}
