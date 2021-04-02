package me.y2o2u2n.p230;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-04-02
 */
public class KthSmallestElmentInABst {
	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(
			3,
			new TreeNode(
				1,
				null,
				new TreeNode(2)
			),
			new TreeNode(4)
		);

		System.out.println(kthSmallest(r1, 1)); // 1

		TreeNode r2 = new TreeNode(
			5,
			new TreeNode(
				3,
				new TreeNode(
					2,
					new TreeNode(1),
					null
				),
				new TreeNode(4)
			),
			new TreeNode(6)
		);

		System.out.println(kthSmallest(r2, 3)); // 3
	}

	private static int kthSmallest(TreeNode root, int k) {
		List<Integer> ret = new ArrayList<>();
		inorder(root, ret);
		return ret.get(k - 1);
	}

	private static void inorder(TreeNode node, List<Integer> ret) {
		if (node == null) {
			return;
		}

		inorder(node.left, ret);
		ret.add(node.val);
		inorder(node.right, ret);
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
