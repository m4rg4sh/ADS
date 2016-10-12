package P03_Queue;

import P03_LinkedList.ListEmptyException;
import P03_LinkedList.Node;

/**
 * This class implements a generic queue for the ADS module @ ZHAW
 *
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
class Queue<Type> {
    private Node<Type> head;

    public Queue() {
        head = new Node<>();
    }

    /**
     * @return true if the queue is empty
     */
    boolean isEmpty() {
        return (head.getNext() == null);
    }

    /**
     * @return the first value in the queue
     * @throws ListEmptyException If the queue is empty
     */
    Type peek() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        Node<Type> currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    /**
     * Adds a new element at the end of the queue
     *
     * @param value the element to add
     */
    void add(Type value) {
        Node<Type> currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(new Node<>(value));
    }

    /**
     * Returns and removes the element that is at the front of the queue
     *
     * @return the first element in the queue
     * @throws ListEmptyException if the queue is empty
     */
    Type remove() throws ListEmptyException {
        Type value = peek();
        head.setNext(head.getNext().getNext());
        return value;
    }
}
