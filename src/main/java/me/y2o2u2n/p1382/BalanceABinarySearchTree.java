package me.y2o2u2n.p1382;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import me.y2o2u2n.common.TreeNode;

/**
 * Created by JunSeok Youn on 2021/07/01
 */
public class BalanceABinarySearchTree {
	public TreeNode balanceBST(TreeNode root) {
		if (root == null) {
			return null;
		}

		List<TreeNode> nodes = new ArrayList<>(); // sorted
		inorder(root, nodes);
		return build(0, nodes.size() - 1, nodes);
	}

	private void inorder(TreeNode node, List<TreeNode> nodes) {
		if (node == null) {
			return;
		}

		inorder(node.left, nodes);
		nodes.add(node);
		inorder(node.right, nodes);
	}

	private TreeNode build(int start, int end, List<TreeNode> nodes) {
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		TreeNode node = nodes.get(mid);
		node.left = build(start, mid - 1, nodes);
		node.right = build(mid + 1, end, nodes);
		return node;
	}
}
