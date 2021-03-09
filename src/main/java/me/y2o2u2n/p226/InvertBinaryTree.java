package me.y2o2u2n.p226;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by JunSeok Youn on 2021-03-09
 */
public class InvertBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(
			4,
			new TreeNode(2,
				new TreeNode(1),
				new TreeNode(3)),
			new TreeNode(7,
				new TreeNode(6),
				new TreeNode(9))
		);
		bfs(root);
		bfs(invertTree(root));
	}

	private static TreeNode invertTree(TreeNode root) {
		invert(root);
		return root;
	}

	private static void invert(TreeNode node) {
		if (node == null) {
			return;
		}

		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;

		invert(node.left);
		invert(node.right);
	}

	private static void bfs(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.val);

			if (node.left != null) {
				queue.add(node.left);
			}

			if (node.right != null) {
				queue.add(node.right);
			}
		}

		System.out.println();
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
