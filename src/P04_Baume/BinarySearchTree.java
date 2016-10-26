package P04_Baume;

import P03_LinkedList.ListEmptyException;
import P03_Queue.Queue;

/**
 * This class extends the binary tree to make it a sorted binary tree.
 *
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    public BinarySearchTree(E value) {
        super(value);
    }

    public BinarySearchTree() {
        super();
    }

    /**
     * Adds a value at the correct spot in the tree.
     *
     * @param value the value which will be added
     */
    public void add(E value) {
        TreeNode<E> currentNode = getRoot();

        if (currentNode == null) {
            setRoot(new TreeNode(value));
        } else {

            boolean positionFound = false;

            while (!positionFound) {
                int comparison = currentNode.getElement().compareTo(value);
                if (comparison > 0) {
                    if (currentNode.getLeft() == null) {
                        positionFound = true;
                        currentNode.setLeft(new TreeNode<E>(value));
                    } else {
                        currentNode = currentNode.getLeft();
                    }
                } else if (comparison < 0) {
                    if (currentNode.getRight() == null) {
                        positionFound = true;
                        currentNode.setRight(new TreeNode<E>(value));
                    } else {
                        currentNode = currentNode.getRight();
                    }
                } else {
                    positionFound = true;
                }
            }
        }
    }

    /**
     * Searches the tree for the given value.
     *
     * @param value the value to search for
     * @return the node which contains the value or null if no node is found
     */
    public TreeNode<E> find(E value) {
        TreeNode<E> foundNode = null;
        P03_Queue.Queue<TreeNode<E>> queue = new Queue();

        if (getRoot() != null) {
            queue.add(getRoot());
        }

        while (!queue.isEmpty() && foundNode == null) {
            try {
                TreeNode<E> currentNode = queue.remove();
                if (currentNode.getElement().equals(value)) {
                    foundNode = currentNode;
                } else {
                    if (currentNode.getLeft() != null) {
                        queue.add(currentNode.getLeft());
                    }
                    if (currentNode.getRight() != null) {
                        queue.add(currentNode.getRight());
                    }
                }
            }
            catch (ListEmptyException e) {
                throw new RuntimeException("I processed an empty queue although I shouldn't.");
            }
        }
        return foundNode;
    }

    /**
     * Removes an element from the tree
     * @param element the element to remove
     */
    public void remove(E element){
        TreeNode<E> deletionNode;
        deletionNode = find(element);
        if (deletionNode.getRight() == null){
            if (deletionNode == getRoot()) setRoot(getRoot().getLeft());
            else {
                TreeNode<E> parentNode = getRoot();
                TreeNode<E> nextNode = (deletionNode.getElement().compareTo(parentNode.getElement())<0)? parentNode.getLeft() : parentNode.getRight();
                while(nextNode != deletionNode){
                    parentNode = nextNode;
                    nextNode = (deletionNode.getElement().compareTo(parentNode.getElement())<0)? nextNode.getLeft() : nextNode.getRight();
                }
                if (parentNode.getRight() == deletionNode) parentNode.setRight(deletionNode.getLeft());
                else parentNode.setLeft(deletionNode.getLeft());
            }
        }
        else {
            if (deletionNode == getRoot()) setRoot(getRoot().getRight());
            else {
                TreeNode<E> parentNode = getParentNode(deletionNode);
                TreeNode<E> switchNode = parentNode.getLeft();
                deletionNode.setElement(switchNode.getElement());
                if (parentNode.getRight() == switchNode) parentNode.setRight(switchNode.getRight());
                else parentNode.setLeft(switchNode.getRight());
            }
        }
    }

    /**
     * Returns the parent node of a specified node
     * @param node the node
     * @return the parent of the node
     */
    private TreeNode<E> getParentNode(TreeNode<E> node){
        TreeNode<E> parentNode = node;
        TreeNode<E> switchNode = node.getRight();
        if (switchNode == null) throw new IndexOutOfBoundsException();
        while (switchNode.getLeft() != null){
            parentNode = switchNode;
            switchNode = switchNode.getLeft();
        }
        return parentNode;
    }
}
