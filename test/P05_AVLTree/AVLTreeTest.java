package P05_AVLTree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by lucaegli on 23.10.16.
 */
public class AVLTreeTest {
    AvlTree tree;

    @Before
    public void setup(){
        tree = new AvlTree();
    }

    @Test
    public void testInsert(){
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);

        AvlNode root = tree.root;

        assertEquals(2, root.key);
        assertEquals(1, root.left.key);
        assertEquals(3, root.right.key);
    }

    @Test
    public void testBalanceFactors(){
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);

        AvlNode root = tree.root;
        AvlNode six = root.right;

        assertEquals(1, root.balance);
        assertEquals(0, root.left.balance);
        assertEquals(-1, six.balance);
        assertEquals(0, six.left.balance);
    }

    @Test
    public void testRemove(){
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(4);

        tree.remove(1);

        AvlNode root = tree.root;

        assertEquals(4, root.key);
        assertEquals(3, root.left.key);
        assertEquals(5, root.right.key);
    }



}