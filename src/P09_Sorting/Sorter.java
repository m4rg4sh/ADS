package P09_Sorting;

import java.util.Arrays;

/**
 * @author Stefan Epprecht &lt;epprest1@students.zhaw.ch&gt;
 * @author Lawrence Markwalder &lt;markwlaw@students.zhaw.ch&gt;
 * @author Luca Egli &lt;eglilu01@students.zhaw.ch&gt;
 *
 * Source: Saake/Sattler for the insertionsort and quicksort algorithms
 */
public class Sorter {

	/**
	 * Sorts an array with the default sorting algorithm in the Arrays class
	 * @param numbers the array to be sorted
	 */
	public static void sort(int[] numbers) {
		if (numbers != null) Arrays.sort(numbers);	
	}

	/**
	 * Sorts an array with the insertion sort algorithm from Saake/Sattler
	 * @param numbers
	 */
	public static void insertionSort(int[] numbers){
		if (numbers == null) return;
		for (int i = 1; i < numbers.length;i++){
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
	public static void quickSortClassic(int[] numbers, int l, int u){
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
		quickSortMedian(numbers,0,numbers.length-1);
	}

	/**
	 * Sorts an array with the quicksort algorithm from Saake/Sattler.
	 * The algorithm uses the median of the first, middle and last element of the array as the starting pivot element.
	 * @param numbers the array to be sorted
	 * @param l lower bound index
	 * @param u upper bound index
	 */
	public static void quickSortMedian(int[] numbers, int l, int u){
		if (u > l) {
			int pivotPosition = l;
			if (u-l > 1) {
				pivotPosition = indexOfMedian(numbers,l,l+((u-l)/2),u);
			}
			pivotPosition = divide(numbers,l,u,pivotPosition);
			quickSortMedian(numbers, l, pivotPosition-1);
			quickSortMedian(numbers, pivotPosition+1, u);
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
		numbers[pivotPosition] = numbers[u];
		numbers[u] = pivotValue;
		pivotPosition = l;
		for (int i = l; i < u;i++) {
			if (numbers[i] <= pivotValue) {
				int save = numbers[pivotPosition];
				numbers[pivotPosition] = numbers[i];
				numbers[i] = save;
				pivotPosition++;
			}
		}
		numbers[u] = numbers[pivotPosition];
		numbers[pivotPosition] = pivotValue;

		return pivotPosition;
	}

	/**
	 * calculates the median of the three indices
	 * Source: http://stackoverflow.com/a/19045659
	 * @param numbers the array that contains the elements
	 * @param indexA index of the first element
	 * @param indexB index of the second element
	 * @param indexC index of the third element
	 * @return index of the median element
	 */
	private static int indexOfMedian(int[] numbers, int indexA, int indexB, int indexC){
		int a = numbers[indexA];
		int b = numbers[indexB];
		int c = numbers[indexC];
		int median = Math.max(Math.min(a,b), Math.min(Math.max(a,b),c));

		if (median == a) {
			return indexA;
		} else if (median == b) {
			return indexB;
		} else if (median == c) {
			return indexC;
		} else {
			throw new RuntimeException("Incorrect median");
		}

	}

}
