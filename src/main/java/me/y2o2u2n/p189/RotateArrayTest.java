package me.y2o2u2n.p189;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/06/15
 */
class RotateArrayTest {
	private final RotateArray sut = new RotateArray();

	@Test
	void case1() {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		sut.rotate(nums, 3);
		assertArrayEquals(new int[] {5, 6, 7, 1, 2, 3, 4}, nums);
	}
}
