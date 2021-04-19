package me.y2o2u2n.p653;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-04-19
 */
public class TwoSum4 {

	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(5);
		r1.left = new TreeNode(3);
		r1.left.left = new TreeNode(2);
		r1.left.right = new TreeNode(4);
		r1.right = new TreeNode(6);
		r1.right.right = new TreeNode(7);

		System.out.println(findTarget(r1, 9));
		System.out.println(findTarget(r1, 11));
		System.out.println(findTarget(r1, 28));
	}

	private static boolean findTarget(TreeNode root, int k) {
		if (root == null) {
			return false;
		}

		Set<Integer> set = new HashSet<>();
		return find(root, k, set);
	}

	private static boolean find(TreeNode node, int k, Set<Integer> set) {
		if (node == null) {
			return false;
		} else if (set.contains(k - node.val)) {
			return true;
		} else {
			set.add(node.val);
			boolean left = find(node.left, k, set);
			boolean right = find(node.right, k, set);

			return left || right;
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
