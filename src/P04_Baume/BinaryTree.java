package P04_Baume;

import java.util.*;
import java.util.Queue;

import P03_LinkedList.ListEmptyException;
import P03_Queue.*;

/**
 * This class implements a binary tree for the ADS module @ ZHAW
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class BinaryTree<E extends Comparable<E>> {
    private TreeNode<E> root;

    BinaryTree(E rootElement) {
        root = new TreeNode<E>(rootElement);
    }

    BinaryTree() {
        root = null;
    }

    /**
     * Preorder entrance point to start the recursive search.
     * @return Content of the binary tree, sorted with the preorder method
     */
    ArrayList<E> traversePreorder() {
        return traversePreorder(root);
    }

    /**
     * Preorder tree traversal.
     * @param currentnode the current tree node to work with
     * @return the content of this binary (sub)tree sorted with the preorder method
     */
    private ArrayList<E> traversePreorder(TreeNode<E> currentnode) {
        ArrayList<E> treecontent = new ArrayList<>();
        if (currentnode != null) {
            if (currentnode.getElement() != null) {
                treecontent.add(currentnode.getElement());
            }
            if (currentnode.getLeft() != null) {
                treecontent.addAll(traversePreorder(currentnode.getLeft()));
            }
            if (currentnode.getRight() != null) {
                treecontent.addAll(traversePreorder(currentnode.getRight()));
            }
        }
        return treecontent;
    }

    /**
     * Postorder entrance point to start the recursive search.
     * @return Content of the binary tree, sorted with the postorder method
     */
    ArrayList<E> traversePostorder() {
        return traversePostorder(root);
    }

    /**
     * Postorder tree traversal.
     * @param currentnode the current tree node to work with
     * @return the content of this binary (sub)tree sorted with the postorder method
     */
    private ArrayList<E> traversePostorder(TreeNode<E> currentnode) {
        ArrayList<E> treecontent = new ArrayList<>();
        if (currentnode != null) {
            if (currentnode.getLeft() != null) {
                treecontent.addAll(traversePostorder(currentnode.getLeft()));
            }
            if (currentnode.getRight() != null) {
                treecontent.addAll(traversePostorder(currentnode.getRight()));
            }
            if (currentnode.getElement() != null) {
                treecontent.add(currentnode.getElement());
            }
        }
        return treecontent;
    }

    /**
     * Inorder entrance point to start the recursive search.
     * @return Content of the binary tree, sorted with the inorder method
     */
    ArrayList<E> traverseInorder() {
        return traverseInorder(root);
    }

    /**
     * Inorder tree traversal.
     * @param currentnode the current tree node to work with
     * @return the content of this binary (sub)tree sorted with the inorder method
     */
    private ArrayList<E> traverseInorder(TreeNode<E> currentnode) {
        ArrayList<E> treecontent = new ArrayList<>();
        if (currentnode != null) {
            if (currentnode.getLeft() != null) {
                treecontent.addAll(traverseInorder(currentnode.getLeft()));
            }
            if (currentnode.getElement() != null) {
                treecontent.add(currentnode.getElement());
            }
            if (currentnode.getRight() != null) {
                treecontent.addAll(traverseInorder(currentnode.getRight()));
            }
        }
        return treecontent;
    }

    /**
     * Levelorder tree traversal.
     * @return the content of this binary tree sorted with the levelorder method
     */
    ArrayList<E> traverseLevelorder() {
        ArrayList<E> treecontent = new ArrayList<>();
        if (root != null) {
            P03_Queue.Queue<TreeNode<E>> queue = new P03_Queue.Queue<>();
            if (root != null) {
                queue.add(root);
            }
            while (!queue.isEmpty()) {
                try {
                    TreeNode<E> currentNode = queue.remove();
                    treecontent.add(currentNode.getElement());
                    if (currentNode.getLeft() != null) {
                        queue.add(currentNode.getLeft());
                    }
                    if (currentNode.getRight() != null) {
                        queue.add(currentNode.getRight());
                    }
                }
                catch (ListEmptyException e) {
                    throw new RuntimeException("I processed an empty queue although I shouldn't.");
                }
            }
        }
        return treecontent;
    }

    /**
     * @return the root node of the tree
     */
    TreeNode<E> getRoot() {
        return root;
    }

    /**
     * @param newRoot the new root node of the tree
     */
    void setRoot(TreeNode newRoot) {
        root = newRoot;
    }
}
