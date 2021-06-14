package me.y2o2u2n.p1642;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/06/14
 */
class FurthestBuildingYouCanReachTest {
	private final FurthestBuildingYouCanReach sut = new FurthestBuildingYouCanReach();

	@Test
	void case1() {
		assertEquals(4, sut.furthestBuilding(new int[] {4, 2, 7, 6, 9, 14, 12}, 5, 1));
	}
}
