package me.y2o2u2n.p104;

public class MaximumDepthOfBinaryTree {
	private static Integer maxDepth = 1;

	public static void main(String[] args) {

		TreeNode e1 = new TreeNode(
			3,
			new TreeNode(9, null, null),
			new TreeNode(20, new TreeNode(15), new TreeNode(7))
		);

		System.out.println(maxDepth(e1));
	}

	private static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		dfs(root, 1);
		return maxDepth;
	}

	private static void dfs(TreeNode node, int depth) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			maxDepth = Math.max(depth, maxDepth);
		}

		if (node.left != null)
			dfs(node.left, depth + 1);
		if (node.right != null)
			dfs(node.right, depth + 1);
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
