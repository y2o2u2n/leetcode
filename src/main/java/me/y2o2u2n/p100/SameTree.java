package me.y2o2u2n.p100;

/**
 * Created by JunSeok Youn on 2021-03-31
 */
public class SameTree {

	public static void main(String[] args) {
		System.out.println(
			isSameTree(
				new TreeNode(
					1,
					new TreeNode(2),
					new TreeNode(3)
				),
				new TreeNode(
					1,
					new TreeNode(2),
					new TreeNode(3)
				)
			)
		);

		System.out.println(
			isSameTree(
				new TreeNode(
					1,
					new TreeNode(2),
					null
				),
				new TreeNode(
					1,
					null,
					new TreeNode(2)
				)
			)
		);
	}

	private static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}

		if ((p != null && q == null) || (p == null && q != null)) {
			return false;
		}

		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
