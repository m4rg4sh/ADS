package P03_LinkedList;

/**
 * This class implements a sorted LinkedList
 *
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
class SortedLinkedList extends MyLinkedList<Integer> {
    private static final int KEY_NOT_FOUND = -1;

    SortedLinkedList() {
        super();
    }

    /**
     * Adds a value at the right spot of the sorted list
     *
     * @param key the value to add
     */
    void addSorted(int key) {
        Node<Integer> currentNode = head;
        Node<Integer> previousNode = null;
        boolean largerValueFound = false;

        while (currentNode.getNext() != null && !largerValueFound) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            if (currentNode.getValue() >= key) {
                largerValueFound = true;
            }
        }
        if (largerValueFound) {
            previousNode.setNext(new Node<>(key, currentNode));
        } else {
            currentNode.setNext(new Node<>(key));
        }
    }

    /**
     * Looks for the location of a given key in the sorted list
     *
     * @param key the key to look for
     * @return the first index of the key
     * @throws KeyNotFoundException if the key is not present in the list
     */
    int getSorted(int key) throws KeyNotFoundException {
        int index = KEY_NOT_FOUND;
        for (int i = 0; i < size(); i++) {
            if (get(i) == key) {
                index = i;
            }
        }
        if (index == KEY_NOT_FOUND) {
            throw new KeyNotFoundException();
        }
        return index;
    }

    /**
     * removes the given key from the list if it is present
     *
     * @param key the key to look for
     * @return the index of the removed item
     * @throws KeyNotFoundException if the key is not present in the list
     */
    int removeSorted(int key) throws KeyNotFoundException {
        int index = getSorted(key);
        remove(index);
        return index;
    }

    //Override malicious methods that mess with the sorting of the list
    @Override
    void addFirst(Integer key) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    void addLast(Integer key) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    void add(int index, Integer key) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
