package me.y2o2u2n.p979;

/**
 * Created by JunSeok Youn on 2021-04-23
 */
public class DistributeCoinsInBinaryTree {
	private static int ans;

	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(1);
		r1.left = new TreeNode(0);
		r1.left.right = new TreeNode(3);
		r1.right = new TreeNode(0);

		System.out.println(distributeCoins(r1));
	}

	private static int distributeCoins(TreeNode root) {
		ans = 0;
		dfs(root);
		return ans;
	}

	private static int dfs(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int left = dfs(node.left);
		int right = dfs(node.right);
		ans += Math.abs(left) + Math.abs(right);
		return node.val + left + right - 1;

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
