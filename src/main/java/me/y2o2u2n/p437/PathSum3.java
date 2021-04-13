package me.y2o2u2n.p437;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-04-13
 */
public class PathSum3 {

	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(10);
		r1.left = new TreeNode(5);
		r1.left.left = new TreeNode(3);
		r1.left.left.left = new TreeNode(3);
		r1.left.left.right = new TreeNode(-2);
		r1.left.right = new TreeNode(2);
		r1.left.right.right = new TreeNode(1);
		r1.right = new TreeNode(-3);
		r1.right.right = new TreeNode(11);

		System.out.println(pathSum(r1, 8));

		TreeNode r2 = new TreeNode(5);
		r2.left = new TreeNode(4);
		r2.left.left = new TreeNode(11);
		r2.left.left.left = new TreeNode(7);
		r2.left.left.right = new TreeNode(2);
		r2.right = new TreeNode(8);
		r2.right.left = new TreeNode(13);
		r2.right.right = new TreeNode(4);
		r2.right.right.left = new TreeNode(5);
		r2.right.right.right = new TreeNode(1);

		System.out.println(pathSum(r2, 22));

		TreeNode r3 = new TreeNode(0);
		r3.left = new TreeNode(1);
		r3.right = new TreeNode(1);

		System.out.println(pathSum(r3, 1));
	}

	private static int pathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return 0;
		}

		int depth = 0;
		List<TreeNode> list = new ArrayList<>();
		list.add(root);

		return path(root, targetSum, depth, list);
	}

	private static int path(
		TreeNode node,
		int targetSum,
		int depth,
		List<TreeNode> list
	) {
		int ret = 0;

		int[] m = new int[depth + 1];
		m[depth] = list.get(depth).val;

		for (int i = depth - 1; i >= 0; i--) {
			m[i] = m[i + 1] + list.get(i).val;
		}

		for (int i = 0; i <= depth; i++) {
			if (m[i] == targetSum) {
				ret++;
			}
		}

		if (node.left != null) {
			list.add(depth + 1, node.left);
			ret += path(node.left, targetSum, depth + 1, list);
			list.remove(depth + 1);
		}

		if (node.right != null) {
			list.add(depth + 1, node.right);
			ret += path(node.right, targetSum, depth + 1, list);
			list.remove(depth + 1);
		}

		return ret;
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
