package me.y2o2u2n.p965;

import me.y2o2u2n.common.TreeNode;

public class UnivaluedBinaryTree {
	public boolean isUnivalTree(TreeNode root) {
		if (root == null) {
			return true;
		}

		int val = root.val;

		return inorder(root, val);
	}

	private boolean inorder(TreeNode node, int val) {
		if (node == null) {
			return true;
		}

		if (node.val != val) {
			return false;
		}

		if (!inorder(node.left, val)) {
			return false;
		}

		if (!inorder(node.right, val)) {
			return false;
		}

		return true;
	}
}
