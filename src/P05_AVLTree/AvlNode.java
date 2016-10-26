package P05_AVLTree;

/**
 * Copyright © by http://blog.blackbam.at/2012/05/04/avl-tree-implementation-in-java
 */

public class AvlNode {
    public AvlNode left;
    public AvlNode right;
    public AvlNode parent;
    public int key;
    public int balance;

    public AvlNode(int k) {
        left = right = parent = null;
        balance = 0;
        key = k;
    }
    public String toString() {
        return "" + key;
    }

}