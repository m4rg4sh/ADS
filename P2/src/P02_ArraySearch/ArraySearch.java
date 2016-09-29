package P02_ArraySearch;

/**
 * Implementation of the binary search algorithm: iterative and recursive
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class ArraySearch {
    static final int KEY_NOT_FOUND = -1;

    public static void main(String[] args) {
        int[] values = {1,2,3,4};
        System.out.println(binarySearchRecursive(values,3));
    }

    /**
     * recursive binary search algorithm
     *
     * @param values values to search through, must be sorted ascending
     * @param key    value to find
     * @return index of the value in the array, or KEY_NOT_FOUND
     */
    static int binarySearchRecursive(int[] values, int key) {
        if (values.length == 0) {
            return KEY_NOT_FOUND;
        } else {
            return binarySearchRecursive(values, key, 0, values.length - 1);
        }
    }

    /**
     * recursive binary search algorithm
     * @param values values to search through, must be sorted ascending
     * @param key value to find
     * @param minIndex algorithm won't search in indexes lower than this
     * @param maxIndex algorithm won't search in indexes higher than this
     * @return index of the value in the array, or KEY_NOT_FOUND
     */
    static int binarySearchRecursive(int[] values, int key, int minIndex, int maxIndex) {

        int indexToCheck = minIndex + ((maxIndex - minIndex) / 2);
        int indexOfKey = KEY_NOT_FOUND;

        if (maxIndex <= minIndex && values[indexToCheck] != key) {
            indexOfKey = KEY_NOT_FOUND;
        } else {
            if (values[indexToCheck] == key) {
                indexOfKey = indexToCheck;
            } else if (key > values[indexToCheck]) {
                indexOfKey = binarySearchRecursive(values,key,++indexToCheck,maxIndex );
            } else if (key < values[indexToCheck]) {
                indexOfKey = binarySearchRecursive(values,key,minIndex,--indexToCheck);
            }
        }
        return indexOfKey;
    }

    /**
     * iterative implementation of the binary search algorithm
     * @param values values to search through, must be sorted ascending
     * @param key value to find
     * @return index of the value in the array, or KEY_NOT_FOUND
     */
    static int binarySearchIterative(int[] values, int key){
        int indexOfKey = KEY_NOT_FOUND;
        int minIndex = 0;
        int maxIndex = values.length - 1;
        int indexToCheck = 0;

        while (indexOfKey == KEY_NOT_FOUND && (maxIndex >= minIndex)) {
            indexToCheck = minIndex + ((maxIndex - minIndex) / 2);
            if (values[indexToCheck] == key) {
                indexOfKey = indexToCheck;
            } else if (key > values[indexToCheck]) {
                minIndex = indexToCheck + 1;
            } else if (key < values[indexToCheck]) {
                maxIndex = indexToCheck - 1;
            }
        }
        return indexOfKey;
    }
}
