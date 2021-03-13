package p617;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by JunSeok Youn on 2021-03-13
 */
public class MergeTwoBinaryTrees {
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(
			1,
			new TreeNode(3,
				new TreeNode(5),
				null
			),
			new TreeNode(2)
		);

		TreeNode root2 = new TreeNode(
			2,
			new TreeNode(1,
				null,
				new TreeNode(4)
			),
			new TreeNode(3,
				null,
				new TreeNode(7))
		);

		printTree(mergeTrees(root1, root2));

	}

	private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null) {
			return root2;
		}

		if (root2 == null) {
			return root1;
		}

		root1.val = root1.val + root2.val;
		root1.left = mergeTrees(root1.left, root2.left);
		root1.right = mergeTrees(root1.right, root2.right);

		return root1;
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

	private static void printTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.println(node.val);
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
	}
}
