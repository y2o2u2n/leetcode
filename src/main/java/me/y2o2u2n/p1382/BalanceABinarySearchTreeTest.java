package me.y2o2u2n.p1382;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import me.y2o2u2n.common.TreeNode;

/**
 * Created by JunSeok Youn on 2021/07/01
 */
class BalanceABinarySearchTreeTest {
	private final BalanceABinarySearchTree sut = new BalanceABinarySearchTree();

	@Test
	void case1() {
		TreeNode head = new TreeNode(1);
		head.right = new TreeNode(2);
		head.right.right = new TreeNode(3);
		head.right.right.right = new TreeNode(4);

		TreeNode actual = sut.balanceBST(head);
		assertTrue(isBalanced(actual));
		assertTrue(isBST(actual));
	}

	private boolean isBalanced(TreeNode node) {
		int lh; /* for height of left subtree */

		int rh; /* for height of right subtree */

		/* If tree is empty then return true */
		if (node == null)
			return true;

		/* Get the height of left and right sub trees */
		lh = height(node.left);
		rh = height(node.right);

		if (Math.abs(lh - rh) <= 1
			&& isBalanced(node.left)
			&& isBalanced(node.right))
			return true;

		/* If we reach here then tree is not height-balanced */
		return false;
	}

	/* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
    /*  The function Compute the "height" of a tree. Height is the
        number of nodes along the longest path from the root node
        down to the farthest leaf node.*/
	int height(TreeNode node) {
		/* base case tree is empty */
		if (node == null)
			return 0;

        /* If tree is not empty then height = 1 + max of left
         height and right heights */
		return 1 + Math.max(height(node.left), height(node.right));
	}

	boolean isBST(TreeNode node)
	{
		if (node == null)
			return true;

		/* False if left is > than node */
		if (node.left != null && node.left.val > node.val)
			return false;

		/* False if right is < than node */
		if (node.right != null && node.right.val < node.val)
			return false;

		/* False if, recursively, the left or right is not a BST */
		if (!isBST(node.left) || !isBST(node.right))
			return false;

		/* Passing all that, it's a BST */
		return true;
	}
}