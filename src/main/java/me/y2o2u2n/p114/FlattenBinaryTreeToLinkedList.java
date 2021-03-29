package me.y2o2u2n.p114;

import java.util.Stack;

/**
 * Created by JunSeok Youn on 2021-03-29
 */
public class FlattenBinaryTreeToLinkedList {

	private static TreeNode prev = null;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(
			1,
			new TreeNode(
				2,
				new TreeNode(3),
				new TreeNode(4)
			),
			new TreeNode(
				5,
				null,
				new TreeNode(6)
			)
		);

		flatten(root);

		flatten(null);

		flatten(new TreeNode(0));
	}

	private static void flatten(TreeNode root) {
		if (root == null ){
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.empty()) {
			TreeNode sub = stack.pop();

			if (sub.right != null) {
				stack.push(sub.right);
			}

			if (sub.left != null) {
				stack.push(sub.left);
			}

			if (!stack.empty()) {
				sub.right = stack.peek();
			}

			sub.left = null;
		}
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {

		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
