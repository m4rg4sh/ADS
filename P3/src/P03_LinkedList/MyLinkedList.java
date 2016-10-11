package P03_LinkedList;

/**
 * This class implements a LinkedList for the ADS module @ ZHAW
 *
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
class MyLinkedList<Type> {
    protected Node<Type> head;
    private int size;

    MyLinkedList() {
        head = new Node<>();
        size = 0;
    }

    /**
     * @return true if the list is empty
     */
    boolean isEmpty() {
        return (head.getNext() == null);
    }

    /**
     * @return the amount of values in the list
     */
    int size() {
        /*int counter = 0;
        Node<Type> currentNode = head;
        while (currentNode.getNext() != null) {
            counter++;
            currentNode = currentNode.getNext();
        }*/
        return size;
    }

    /**
     * Returns the specified object from the list
     *
     * @param index the index of the object to be returned
     * @return the value of the element
     * @throws IndexOutOfBoundsException if the index doesn't exist in the list
     */
    Type get(int index) throws IndexOutOfBoundsException {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<Type> currentNode = head;
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    /**
     * @return the first value in the list
     * @throws ListEmptyException If the list is empty
     */
    Type getFirst() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        return get(0);
    }

    /**
     * @return the last value in the list
     * @throws ListEmptyException if the list is empty
     */
    Type getLast() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        return get(size() - 1);
    }

    /**
     * Adds a new element at the specified location in the list
     *
     * @param index the location in the list
     * @param value the value of the new element
     * @throws IndexOutOfBoundsException if the index doesn't exist in the list
     */
    void add(int index, Type value) throws IndexOutOfBoundsException {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<Type> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        Node<Type> nextNode = currentNode.getNext();
        currentNode.setNext(new Node<>(value, nextNode));
        size++;
    }

    /**
     * Adds a new node to the beginning of the list
     *
     * @param value the value of the node
     */
    void addFirst(Type value) {
        add(0, value);
    }

    /**
     * Adds a new element to the end of the list
     *
     * @param value the element to add
     */
    void addLast(Type value) {
        add(size(), value);
    }

    /**
     * Returns the value of a specified element and removes it from the list
     *
     * @param index the index of the element
     * @return the value of the element
     * @throws IndexOutOfBoundsException if the index doesn't exist in the list
     */
    Type remove(int index) throws IndexOutOfBoundsException {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<Type> nodeToRemove = head;
        Node<Type> previousNode = null;

        for (int i = 0; i <= index; i++) {
            previousNode = nodeToRemove;
            nodeToRemove = nodeToRemove.getNext();
        }
        previousNode.setNext(nodeToRemove.getNext());
        size--;
        return nodeToRemove.getValue();

    }

    /**
     * Returns the value of the first element in the list and removes it
     *
     * @return the value of the first element in the list
     * @throws ListEmptyException if the list is empty
     */
    Type removeFirst() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        return remove(0);
    }

    /**
     * Returns the value of the last element in the list and removes it
     *
     * @return the value of the last element in the list
     * @throws ListEmptyException if the list is empty
     */
    Type removeLast() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        return remove(size() - 1);
    }
}
