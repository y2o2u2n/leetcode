package me.y2o2u2n.p958;

import java.util.LinkedList;
import java.util.Queue;

import me.y2o2u2n.common.TreeNode;

public class CheckCompletenessOfABinaryTree {
	public boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		boolean hasNull = false;

		while (!queue.isEmpty()) {
			TreeNode poll = queue.poll();

			TreeNode left = poll.left;
			TreeNode right = poll.right;

			if (left != null) {
				if (hasNull) {
					return false;
				} else {
					queue.offer(left);
				}
			} else {
				hasNull = true;
			}

			if (right != null) {
				if (hasNull) {
					return false;
				} else {
					queue.offer(right);
				}
			} else {
				hasNull = true;
			}
		}

		return true;
	}
}
