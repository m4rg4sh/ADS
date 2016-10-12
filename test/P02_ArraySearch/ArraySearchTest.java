package P02_ArraySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArraySearchTest {
	
	
	
	// Iterative search Tests
	
	@Test
	public void shouldFindAllElementsInArrayWithIterativeBinarySearch(){

		int[] positiveNumArrayWith1000Val = createPositiveNumArray(1000);
				
		for (int i : positiveNumArrayWith1000Val) {
			assertEquals("Key, position and value should have been: "+i,i, ArraySearch.binarySearchIterative(positiveNumArrayWith1000Val, i));
		}
	}
	
	@Test
	public void shouldNotFindKeyIn10ElementArrayWithIterativeBinarySearch(){
		
		int[] positiveNumArrayWith1000Val = createPositiveNumArray(1000);
		int keyNotIn = 420000000;
		
		assertEquals(ArraySearch.KEY_NOT_FOUND, ArraySearch.binarySearchIterative(positiveNumArrayWith1000Val, keyNotIn));
	}
	
	@Test
	public void shouldFindNegativeElementInArrayWithIterativeBinarySearch(){
		
		int negativeNumKey = -4;
		int negativeNumPos = 5;
		int[] negativeNumArray = new int[] {-15,-11,-8,-6,-6,-4,-3};
		
		assertEquals(negativeNumPos, ArraySearch.binarySearchIterative(negativeNumArray, negativeNumKey));
	}
	
	@Test
	public void shouldNotFindKeyInEmtpyArrayWithIterativeBinarySearch(){
		int[] emptyArray = {};
		int anyKey = 27;
		
		assertEquals(ArraySearch.KEY_NOT_FOUND, ArraySearch.binarySearchIterative(emptyArray, anyKey));
	}
	
	
	
	
	// Binary search Tests
	
	@Test
	public void shouldFindAllElementsInArrayWithRecursiveBinarySearch(){
		int[] positiveNumArrayWith1000Val = createPositiveNumArray(1000);
		
		for (int i : positiveNumArrayWith1000Val) {
			assertEquals(i, ArraySearch.binarySearchRecursive(positiveNumArrayWith1000Val, i));
		}
	}
	
	@Test
	public void shouldNotFindKeyIn10ElementArrayWithRecursiveBinarySearch(){
		int[] positiveNumArrayWith1000Val = createPositiveNumArray(1000);
		int keyNotIn = 4200000;
		
		assertEquals(ArraySearch.KEY_NOT_FOUND, ArraySearch.binarySearchRecursive(positiveNumArrayWith1000Val, keyNotIn));
	}
	
	@Test
	public void shouldFindNegativeElementInArrayWithRecursiveBinarySearch(){
		int negativeNumKey = -4;
		int negativeNumPos = 5;
		int[] negativeNumArray = new int[] {-15,-11,-8,-6,-6,-4,-3};
		
		assertEquals(negativeNumPos, ArraySearch.binarySearchRecursive(negativeNumArray, negativeNumKey));
	}
	
	@Test
	public void shouldNotFindKeyInEmtpyArrayWithRecursiveBinarySearch(){
		
		int[] emptyArray = {};
		int anyKey = 27;
		
		assertEquals(ArraySearch.KEY_NOT_FOUND, ArraySearch.binarySearchRecursive(emptyArray, anyKey));
	}

	private int[] createPositiveNumArray(int length) {
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = i;
		}
		return result;
	}
}
