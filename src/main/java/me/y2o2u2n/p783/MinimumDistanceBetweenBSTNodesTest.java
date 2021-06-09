package me.y2o2u2n.p783;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import me.y2o2u2n.common.TreeNode;

/**
 * Created by JunSeok Youn on 2021/06/09
 */
class MinimumDistanceBetweenBSTNodesTest {
	private final MinimumDistanceBetweenBSTNodes sut = new MinimumDistanceBetweenBSTNodes();

	@Test
	void case1() {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		assertEquals(1, sut.minDiffInBST(root));
	}
}