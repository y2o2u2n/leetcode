package me.y2o2u2n.p42;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-05-20
 */
class TrappingRainWaterTest {

	@Test
	void trap() {
		TrappingRainWater sut = new TrappingRainWater();
		assertEquals(6, sut.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
		assertEquals(9, sut.trap(new int[] {4, 2, 0, 3, 2, 5}));
	}
}