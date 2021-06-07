package me.y2o2u2n.p958;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import me.y2o2u2n.common.TreeNode;

class CheckCompletenessOfABinaryTreeTest {

	private CheckCompletenessOfABinaryTree sut = new CheckCompletenessOfABinaryTree();

	@Test
	void case1() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);

		assertTrue(sut.isCompleteTree(root));
	}

	@Test
	void case2() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(7);

		assertFalse(sut.isCompleteTree(root));
	}
}