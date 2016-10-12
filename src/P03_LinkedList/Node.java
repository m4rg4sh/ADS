package P03_LinkedList;

/**
 * This class implements a Node used in a LinkedList for the ADS module @ ZHAW
 *
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class Node<Type> {
    private Type value;
    private Node<Type> next;

    /**
     * creates a node with a value and a following node
     *
     * @param value the value of the node
     * @param next  the following node
     */
    public Node(Type value, Node<Type> next) {
        this.value = value;
        this.next = next;
    }

    /**
     * creates a node with only a value but no link to a following node
     *
     * @param value the value of the node
     */
    public Node(Type value) {
        this(value, null);
    }

    /**
     * creates an empty node
     */
    public Node() {
        this(null);
    }

    /**
     * @return the next Node or null if there is none
     */
    public Node<Type> getNext() {
        return next;
    }

    /**
     * @return the value of the node or null
     */
    public Type getValue() {
        return value;
    }

    /**
     * Sets the node this one links to
     *
     * @param nextNode the node after this one
     */
    public void setNext(Node<Type> nextNode) {
        next = nextNode;
    }
}
