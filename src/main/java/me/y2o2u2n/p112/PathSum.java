package me.y2o2u2n.p112;

/**
 * Created by JunSeok Youn on 2021-04-02
 */
public class PathSum {

	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(
			5,
			new TreeNode(
				4,
				new TreeNode(
					11,
					new TreeNode(7),
					new TreeNode(2)
				),
				null
			),
			new TreeNode(
				8,
				new TreeNode(13),
				new TreeNode(
					4,
					null,
					new TreeNode(1)
				)
			)
		);

		System.out.println(hasPathSum(r1, 22));
	}

	private static boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}

		return hasPath(root, targetSum);
	}

	private static boolean hasPath(TreeNode node, int remain) {
		if (remain == node.val && node.left == null && node.right == null) {
			return true;
		} else {

			if (node.left != null) {
				if (hasPath(node.left, remain - node.val)) {
					return true;
				}
			}

			if (node.right != null) {
				if (hasPath(node.right, remain - node.val)) {
					return true;
				}
			}

			return false;
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
