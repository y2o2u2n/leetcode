package me.y2o2u2n.p965;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import me.y2o2u2n.common.TreeNode;

class UnivaluedBinaryTreeTest {
	private final UnivaluedBinaryTree sut = new UnivaluedBinaryTree();

	@Test
	void case1() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.right.right = new TreeNode(1);

		assertTrue(sut.isUnivalTree(root));
	}

	@Test
	void case2() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(2);

		assertFalse(sut.isUnivalTree(root));
	}
}