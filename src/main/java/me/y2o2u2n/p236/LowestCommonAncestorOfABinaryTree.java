package me.y2o2u2n.p236;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-04-07
 */
public class LowestCommonAncestorOfABinaryTree {
	public static void main(String[] args) {
		e1();
		e2();
		e3();
	}

	private static void e1() {
		TreeNode root = new TreeNode(3);

		TreeNode p = new TreeNode(5);
		p.left = new TreeNode(6);
		p.right = new TreeNode(2);
		p.right.left = new TreeNode(7);
		p.right.right = new TreeNode(4);

		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(0);
		q.right = new TreeNode(8);

		root.left = p;
		root.right = q;

		System.out.println(lowestCommonAncestor(root, p, q).val);
	}

	private static void e2() {
		TreeNode root = new TreeNode(3);

		TreeNode p = new TreeNode(5);
		root.left = p;
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		TreeNode q = new TreeNode(4);
		root.left.right.right = q;

		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);

		System.out.println(lowestCommonAncestor(root, p, q).val);
	}

	private static void e3() {
		TreeNode root = new TreeNode(1);

		TreeNode q = new TreeNode(2);
		root.left = q;


		System.out.println(lowestCommonAncestor(root, root, q).val);
	}

	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Map<TreeNode, TreeNode> parentByChild = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();

			if (node.left != null) {
				parentByChild.put(node.left, node);
				queue.add(node.left);
			}

			if (node.right != null) {
				parentByChild.put(node.right, node);
				queue.add(node.right);
			}
		}

		Set<TreeNode> pParents = new HashSet<>();
		while (p != root) {
			pParents.add(p);
			p = parentByChild.get(p);
		}

		while (q != root) {
			if (pParents.contains(q)) {
				return q;
			}

			q = parentByChild.get(q);
		}

		return root;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
