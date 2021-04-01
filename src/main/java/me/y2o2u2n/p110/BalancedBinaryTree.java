package me.y2o2u2n.p110;

/**
 * Created by JunSeok Youn on 2021-04-02
 */
public class BalancedBinaryTree {
	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(
			3,
			new TreeNode(9),
			new TreeNode(
				20,
				new TreeNode(15),
				new TreeNode(7)
			)
		);

		System.out.println(isBalanced(r1));
		TreeNode r2 = new TreeNode(
			1,
			new TreeNode(
				2,
				new TreeNode(
					3,
					new TreeNode(4),
					new TreeNode(4)
				),
				new TreeNode(3)
			),
			new TreeNode(2)
		);

		System.out.println(isBalanced(r2));
	}

	private static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (Math.abs(height(root.left) - height(root.right)) > 1) {
			return false;
		}

		return isBalanced(root.left) && isBalanced(root.right);
	}

	private static int height(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return Math.max(height(node.left), height(node.right)) + 1;
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
