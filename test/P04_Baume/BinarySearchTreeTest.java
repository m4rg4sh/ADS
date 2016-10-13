package P04_Baume;

import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinarySearchTreeTest {

	@Test
	public void shouldFindRootValueCorrectly(){
		BinarySearchTree<Integer> onlyRootNodeTree = new BinarySearchTree<>(99);
		assertEquals(onlyRootNodeTree.getRoot(),onlyRootNodeTree.find(99));
	}

	@Test
	public void shouldAddMultipleValuesCorrectly() {
		BinarySearchTree<Integer> manyNodesSortedTree = createManyNodesSortedTree();
		ArrayList<Integer> resultList = createManyNodeResultList();
		assertEquals(resultList,manyNodesSortedTree.traverseInorder());
	}

	@Test
	public void shouldFindCorrectNode(){
		BinarySearchTree<Integer> manyNodesSortedTree = createManyNodesSortedTree();
		assertEquals(manyNodesSortedTree.getRoot(),manyNodesSortedTree.find(100));
		assertEquals(manyNodesSortedTree.getRoot().getLeft(),manyNodesSortedTree.find(50));
		assertEquals(manyNodesSortedTree.getRoot().getLeft().getLeft(),manyNodesSortedTree.find(25));
		assertEquals(manyNodesSortedTree.getRoot().getLeft().getLeft().getRight(),manyNodesSortedTree.find(30));
		assertEquals(manyNodesSortedTree.getRoot().getLeft().getLeft(),manyNodesSortedTree.find(25));
		assertEquals(manyNodesSortedTree.getRoot().getLeft().getRight(),manyNodesSortedTree.find(75));
		assertEquals(manyNodesSortedTree.getRoot().getLeft().getRight().getLeft(),manyNodesSortedTree.find(60));
		assertEquals(manyNodesSortedTree.getRoot().getRight(),manyNodesSortedTree.find(150));
		assertEquals(manyNodesSortedTree.getRoot().getLeft().getLeft().getLeft(),manyNodesSortedTree.find(1));
		assertEquals(manyNodesSortedTree.getRoot().getLeft().getLeft().getLeft().getLeft(),manyNodesSortedTree.find(-1));

	}

	private ArrayList<Integer> createManyNodeResultList() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(-1);
		list.add(1);
		list.add(25);
		list.add(30);
		list.add(50);
		list.add(60);
		list.add(75);
		list.add(100);
		list.add(150);

		return list;
	}

	private BinarySearchTree createManyNodesSortedTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.add(100);
		tree.add(50);
		tree.add(25);
		tree.add(30);
		tree.add(75);
		tree.add(60);
		tree.add(150);
		tree.add(1);
		tree.add(-1);
		return tree;
	}

}
