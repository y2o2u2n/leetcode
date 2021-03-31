package me.y2o2u2n.p199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created by JunSeok Youn on 2021-03-31
 */
public class BinaryTreeRightSideView {
	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(
			1,
			new TreeNode(
				2,
				null,
				new TreeNode(5)
			),
			new TreeNode(
				3,
				null,
				new TreeNode(4)
			)
		);

		printList(rightSideView(r1)); // 1,3,4

		TreeNode r2 = new TreeNode(
			1,
			new TreeNode(
				2,
				null,
				new TreeNode(5)
			),
			new TreeNode(3)
		);

		printList(rightSideView(r2)); // 1,3,5

		TreeNode r3 = new TreeNode(
			1,
			null,
			new TreeNode(3)
		);

		printList(rightSideView(r3)); // 1,3

		printList(rightSideView(null));
	}

	private static List<Integer> rightSideView(TreeNode root) {
		if (root == null) {
			return List.of();
		}

		TreeMap<Integer, Stack<Integer>> treeMap = new TreeMap<>();
		Queue<WithLevel> queue = new LinkedList<>();
		queue.add(new WithLevel(root, 0));

		while (!queue.isEmpty()) {
			WithLevel withLevel = queue.poll();
			TreeNode node = withLevel.treeNode;
			int level = withLevel.level;
			int value = node.val;

			if (treeMap.get(level) != null) {
				Stack<Integer> stack = treeMap.get(level);
				stack.push(value);
			} else {
				Stack<Integer> stack = new Stack<>();
				stack.push(value);
				treeMap.put(level, stack);
			}

			if (node.left != null) {
				queue.offer(new WithLevel(node.left, level + 1));
			}

			if (node.right != null) {
				queue.offer(new WithLevel(node.right, level + 1));
			}
		}

		List<Integer> ret = new ArrayList<>();
		for (Map.Entry<Integer, Stack<Integer>> entry : treeMap.entrySet()) {
			// Integer level = entry.getKey();
			Stack<Integer> stack = entry.getValue();

			if (stack != null && !stack.isEmpty()) {
				ret.add(stack.pop());
			}
		}

		return ret;
	}

	private static class WithLevel {
		TreeNode treeNode;
		int level;

		WithLevel(TreeNode treeNode, int level) {
			this.treeNode = treeNode;
			this.level = level;
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
