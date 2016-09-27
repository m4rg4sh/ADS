package P01_ArraySearch;

class ArraySearch {
    static final int KEY_NOT_FOUND = -1;

    /**
     * Does a sequential search over an array to find a certain value
     * @param values the array to search through
     * @param key the key to find
     * @return the index of the key or the KEY_NOT_FOUND value if the key wasn't found
     */
    static int sequentialSearch(int[] values, int key) {
        int indexOfKey = KEY_NOT_FOUND;
        for(int i = 0;i<values.length&&indexOfKey == KEY_NOT_FOUND;i++) {
            if (values[i] == key) {
                indexOfKey = i;
            }
        }
        return indexOfKey;
    }

    /**
     * Does a binary search over an array to find a certain value
     * @param values the array to search through. has to be sorted ascending or the results will be faulty!
     * @param key the key to find
     * @return the index of the key or the KEY_NOT_FOUND value if the key wasn't found
     */
    static int binarySearch(int[] values, int key) {
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