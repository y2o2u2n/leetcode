package me.y2o2u2n.p94;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-03-25
 */
public class BinaryTreeInorderTraversal {
	public static void main(String[] args) {
		printList(inorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
		printList(inorderTraversal(null));
		printList(inorderTraversal(new TreeNode(1)));
		printList(inorderTraversal(new TreeNode(1, new TreeNode(2), null)));
		printList(inorderTraversal(new TreeNode(1, null, new TreeNode(2))));
	}

	private static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		inorder(root, ret);
		return ret;
	}

	private static void inorder(TreeNode node, List<Integer> ret) {
		if (node == null) {
			// do nothing
		} else {
			inorder(node.left, ret);
			ret.add(node.val);
			inorder(node.right, ret);
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

	private static void printList(List<Integer> list) {
		for (int i : list) {
			System.out.print(i);
		}
		System.out.println();
	}
}
