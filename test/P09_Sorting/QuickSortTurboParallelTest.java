package P09_Sorting;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class QuickSortTurboParallelTest {

	@Test
	public void shouldNotDoAnythingForNull() {
		int[] parameter = null;
		Sorter.quickSortParallel(parameter);
		assertNull(parameter);
	}
	

	@Test
	public void shouldNotDoAnythingForSingleElement() {
		int[] parameter = {1};
		int[] expected = {1};
		Sorter.quickSortParallel(parameter);
		assertArrayEquals(expected, parameter);
	}
	
	@Test
	public void shouldKeepAlreadySortedArray() {
		int[] parameter = {-10, -3, 0, 0, 1, 1, 111, 39393939};
		int[] expected = {-10, -3, 0, 0, 1, 1, 111, 39393939};
		Sorter.quickSortParallel(parameter);
		assertArrayEquals(expected, parameter);
	}
	
	@Test
	public void shouldSortAscending() {
		int[] parameter = {4, -10, 2, 5, -10, 3, 202, -111, 0, 1};
		int[] expected = {-111, -10, -10, 0, 1, 2, 3, 4, 5, 202};
		Sorter.quickSortParallel(parameter);
		assertArrayEquals(expected, parameter);
	}

	@Test
	public void shouldSortAscendingLarge() {
		int[] parameter = {4, -10, 2, 5, -10, 3, 202, -111, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] expected = {-111, -10, -10, 0, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 202};
		Sorter.quickSortParallel(parameter);
		assertArrayEquals(expected, parameter);
	}
}
