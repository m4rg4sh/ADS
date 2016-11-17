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
	
	public static void sort(int[] numbers) {
		if (numbers != null) Arrays.sort(numbers);	
	}

	public static int[] insertionSort(int[] numbers){
		if (numbers == null) return null;
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
		return numbers;
	}

	public static int[] quickSort(int[] numbers){
		if (numbers == null) return null;
		return quickSort(numbers,0,numbers.length-1);
	}

	public static int[] quickSort(int[] numbers, int u, int o){
		if (o > u) {
			int pivotPosition = u + ((o-u)/2);
			pivotPosition = divide(numbers,u,o,pivotPosition);
			quickSort (numbers, u, pivotPosition-1);
			quickSort (numbers, pivotPosition+1, o);
		}
		return numbers;
	}

	private static int divide(int[] numbers, int u, int o, int pivotPosition){
		int pivotValue = numbers[pivotPosition];
		numbers[pivotPosition] = numbers[o];
		numbers[o] = pivotValue;
		pivotPosition = u;
		for (int i = u; i < o;i++) {
			if (numbers[i] <= pivotValue) {
				int save = numbers[pivotPosition];
				numbers[pivotPosition] = numbers[i];
				numbers[i] = save;
				pivotPosition++;
			}
		}
		numbers[o] = numbers[pivotPosition];
		numbers[pivotPosition] = pivotValue;

		return pivotPosition;
	}

}
