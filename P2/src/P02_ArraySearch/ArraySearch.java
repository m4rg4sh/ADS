package P02_ArraySearch;

/**
 * Created by margash on 29/09/16.
 */
public class ArraySearch {
    static final int KEY_NOT_FOUND = -1;

    public static void main(String[] args) {
        int[] values = {1,2,3,4};
        System.out.println(binarySearchRecursive(values,3));
    }

    static int binarySearchRecursive(int[] values, int key) {
        if (values.length == 0) {
            return KEY_NOT_FOUND;
        } else {
            return binarySearchRecursive(values, key, 0, values.length - 1);
        }
    }

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
