package me.y2o2u2n.p543;

/**
 * Created by JunSeok Youn on 2021-03-11
 */
public class DiameterOfBinaryTree {
	private static int diameter = Integer.MIN_VALUE;

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(
			1,
			new TreeNode(
				2,
				new TreeNode(4),
				new TreeNode(5)
			),
			new TreeNode(3)
		);

		System.out.println(diameterOfBinaryTree(root1));
	}

	private static int diameterOfBinaryTree(TreeNode root) {
		height(root);
		return diameter;
	}

	private static int height(TreeNode node) {
		if (node == null) {
			return -1;
		} else {
			int leftHeight = height(node.left) + 1;
			int rightHeight = height(node.right) + 1;
			diameter = Math.max(diameter, leftHeight + rightHeight);
			return Math.max(leftHeight, rightHeight);
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
