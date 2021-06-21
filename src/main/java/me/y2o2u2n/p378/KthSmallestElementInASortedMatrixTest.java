package me.y2o2u2n.p378;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-06-22
 */
class KthSmallestElementInASortedMatrixTest {
	private final KthSmallestElementInASortedMatrix sut = new KthSmallestElementInASortedMatrix();

	@Test
	void case1() {
		assertEquals(
			13,
			sut.kthSmallest(
				new int[][] {
					{1, 5, 9},
					{10, 11, 13},
					{12, 13, 15}
				},
				8
			)
		);
	}

}