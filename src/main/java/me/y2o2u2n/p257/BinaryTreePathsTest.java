package me.y2o2u2n.p257;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import me.y2o2u2n.common.TreeNode;

class BinaryTreePathsTest {
	private final BinaryTreePaths sut = new BinaryTreePaths();

	@Test
	void case1() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);

		List<String> expected = List.of("1->2->5", "1->3");
		List<String> actual = sut.binaryTreePaths(root);

		assertEquals(expected.size(), actual.size());
		assertTrue(expected.containsAll(actual));
		assertTrue(actual.containsAll(expected));
	}

	@Test
	void case2() {
		TreeNode root = new TreeNode(1);

		List<String> expected = List.of("1");
		List<String> actual = sut.binaryTreePaths(root);

		assertEquals(expected.size(), actual.size());
		assertTrue(expected.containsAll(actual));
		assertTrue(actual.containsAll(expected));
	}
}