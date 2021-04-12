package me.y2o2u2n.p337;

/**
 * Created by JunSeok Youn on 2021-04-12
 */
public class HouseRobber3 {

	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(3);
		r1.left = new TreeNode(2);
		r1.left.left = new TreeNode(1);
		r1.left.right = new TreeNode(5);
		r1.right = new TreeNode(20);
		r1.right.right = new TreeNode(4);

		System.out.println(rob(r1));

		TreeNode r2 = new TreeNode(3);
		r2.left = new TreeNode(2);
		r2.left.right = new TreeNode(3);
		r2.right = new TreeNode(3);
		r2.right.right = new TreeNode(1);

		System.out.println(rob(r2));
	}

	private static int rob(TreeNode root) {
		int[] helper = helper(root);
		return Math.max(helper[0], helper[1]);
	}

	private static int[] helper(TreeNode node) {
		if (node == null) {
			return new int[] {0, 0};
		}

		int[] l = helper(node.left);
		int[] r = helper(node.right);

		int rob = node.val + l[1] + r[1];
		int notRob = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);

		return new int[] {rob, notRob};
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
