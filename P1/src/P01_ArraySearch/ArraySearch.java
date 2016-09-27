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

    public static void main(String[] args) {
        int length = 20000000;
        int item = 19999999;

        int[] testarray = createPositiveNumArray(length);

        long startTime = 0;
        long endTime = 0;

        System.out.println("Testing squential search with " + length + " items. key is at position " + item + ":");
        startTime = System.currentTimeMillis();
        sequentialSearch(testarray,item);
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        System.out.println("Doing same thing with binary search algorithm:");
        startTime = System.currentTimeMillis();
        binarySearch(testarray,item);
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }

    private static int[] createPositiveNumArray(int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = i;
        }
        return result;
    }
}