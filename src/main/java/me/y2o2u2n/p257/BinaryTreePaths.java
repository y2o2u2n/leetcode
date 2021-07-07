package me.y2o2u2n.p257;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import me.y2o2u2n.common.TreeNode;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> answers = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		dfs(root, stack, answers);
		return answers;
	}

	private void dfs(TreeNode node, Stack<TreeNode> stack, List<String> answers) {
		if (node == null) {
			return;
		}
		
		// leaf node
		if (node.left == null && node.right == null) {
			stack.push(node);
			String answer = stack.stream()
				.map(n -> n.val)
				.map(String::valueOf)
				.collect(Collectors.joining("->"));
			answers.add(answer);
			stack.pop();
			return;
		}

		stack.push(node);
		dfs(node.left, stack, answers);
		stack.pop();
		// System.out.println(node.val);
		stack.push(node);
		dfs(node.right, stack, answers);
		stack.pop();
	}
}
