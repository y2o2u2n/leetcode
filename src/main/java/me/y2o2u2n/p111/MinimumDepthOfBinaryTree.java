package me.y2o2u2n.p111;

/**
 * Created by JunSeok Youn on 2021-04-02
 */
public class MinimumDepthOfBinaryTree {
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

		System.out.println(minDepth(r1));

		TreeNode r2 = new TreeNode(
			2,
			null,
			new TreeNode(
				3,
				null,
				new TreeNode(
					4,
					null,
					new TreeNode(
						5,
						null,
						new TreeNode(6)
					)
				)
			)
		);

		System.out.println(minDepth(r2));
	}

	private static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return depth(root);
	}

	private static int depth(TreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		return Math.min(depth(root.left), depth(root.right)) + 1;
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
