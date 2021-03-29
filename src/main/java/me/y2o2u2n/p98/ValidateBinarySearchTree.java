package me.y2o2u2n.p98;

public class ValidateBinarySearchTree {
	public static void main(String[] args) {
		System.out.println(
			isValidBST(
				new TreeNode(
					2,
					new TreeNode(1),
					new TreeNode(3)
				)
			)
		);

		System.out.println(
			isValidBST(
				new TreeNode(
					5,
					new TreeNode(1),
					new TreeNode(
						4,
						new TreeNode(3),
						new TreeNode(6)
					)
				)
			)
		);

		System.out.println(
			isValidBST(
				new TreeNode(
					5,
					new TreeNode(4),
					new TreeNode(
						6,
						new TreeNode(3),
						new TreeNode(7)
					)
				)
			)
		);

		System.out.println(
			isValidBST(
				new TreeNode(
					3,
					new TreeNode(
						1,
						new TreeNode(0),
						new TreeNode(2)),
					new TreeNode(
						5,
						new TreeNode(4),
						new TreeNode(6)
					)
				)
			)
		);
	}

	private static boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isValid(root, null, null);
	}

	private static boolean isValid(TreeNode node, Integer lower, Integer upper) {
		if (lower != null && node.val <= lower) {
			return false;
		}

		if (upper != null && node.val >= upper) {
			return false;
		}

		TreeNode left = node.left;
		TreeNode right = node.right;

		boolean isLeftValid = left == null || isValid(left, lower, node.val);
		boolean isRightValid = right == null || isValid(right, node.val, upper);

		return isLeftValid && isRightValid;
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
