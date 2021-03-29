package me.y2o2u2n.p102;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		printListList(
			levelOrder(
				new TreeNode(
					3,
					new TreeNode(9),
					new TreeNode(
						20,
						new TreeNode(15),
						new TreeNode(7)
					)
				))
		);

		printListList(levelOrder(new TreeNode(1)));

		printListList(levelOrder(null));

		printListList(
			levelOrder(
				new TreeNode(
					1,
					new TreeNode(
						2,
						new TreeNode(
							3,
							new TreeNode(
								4, new TreeNode(
								5),
								null),
							null)
						, null),
					null
				))
		);
	}

	private static List<List<Integer>> levelOrder(TreeNode root) {
		// (level, value)
		Map<Integer, List<Integer>> map = new LinkedHashMap<>();

		Queue<WithLevel> queue = new LinkedList<>();
		queue.add(new WithLevel(root, 0));

		while (!queue.isEmpty()) {
			WithLevel withLevel = queue.poll();
			TreeNode node = withLevel.node;
			int level = withLevel.level;

			if (node == null) {
				// do nothing
			} else {
				List<Integer> list = map.get(level);
				if (list == null) {
					list = new ArrayList<>();
					list.add(node.val);
					map.put(level, list);
				} else {
					list.add(node.val);
					map.put(level, list);
				}

				queue.add(new WithLevel(node.left, level + 1));
				queue.add(new WithLevel(node.right, level + 1));
			}
		}

		List<List<Integer>> ret = new ArrayList<>();
		for (int level : map.keySet()) {
			List<Integer> list = map.get(level);
			ret.add(list);
		}

		return ret;
	}

	private static class WithLevel {
		TreeNode node;
		int level;

		WithLevel(TreeNode node, int level) {
			this.node = node;
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

	private static void printListList(List<List<Integer>> threeSum) {
		for (List<Integer> list : threeSum) {
			for (int i : list) {
				System.out.print(i + ",");
			}
			System.out.println();
		}
		System.out.println();
	}

}
