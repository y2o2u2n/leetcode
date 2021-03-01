package me.y2o2u2n.p101;

public class SymmetricTree {
	public static void main(String[] args) {

		TreeNode e1 = new TreeNode(
			1,
			new TreeNode(2, new TreeNode(3), new TreeNode(4)),
			new TreeNode(2, new TreeNode(4), new TreeNode(3))
		);

		System.out.println(isSymmetric(e1));

		TreeNode e2 = new TreeNode(
			1,
			new TreeNode(2, null, new TreeNode(3)),
			new TreeNode(2, null, new TreeNode(3))
		);

		System.out.println(isSymmetric(e2));
	}

	private static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		return compare(root.left, root.right);
	}

	private static boolean compare(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left.val != right.val)
			return false;

		return compare(left.left, right.right) && compare(left.right, right.left);
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
