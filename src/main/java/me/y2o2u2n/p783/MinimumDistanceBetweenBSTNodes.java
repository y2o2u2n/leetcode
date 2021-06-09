package me.y2o2u2n.p783;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import me.y2o2u2n.common.TreeNode;

/**
 * Created by JunSeok Youn on 2021/06/09
 */
public class MinimumDistanceBetweenBSTNodes {
	public int minDiffInBST(TreeNode root) {
		List<Integer> numbers = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			numbers.add(node.val);

			if (node.left != null) {
				queue.offer(node.left);
			}

			if (node.right != null) {
				queue.offer(node.right);
			}
		}

		Collections.sort(numbers);

		int min = numbers.get(1) - numbers.get(0);

		for (int i = 1; i < numbers.size() - 1; i++) {
			 min = Math.min(min, numbers.get(i + 1) - numbers.get(i));
		}

		return min;
	}
}
