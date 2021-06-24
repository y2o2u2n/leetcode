package me.y2o2u2n.p1184;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-06-24
 */
class DistanceBetweenBusStopsTest {
	private final DistanceBetweenBusStops sut = new DistanceBetweenBusStops();

	@Test
	void case1() {
		assertEquals(1, sut.distanceBetweenBusStops(new int[] {1, 2, 3, 4}, 0, 1));
	}

	@Test
	void case2() {
		assertEquals(3, sut.distanceBetweenBusStops(new int[] {1, 2, 3, 4}, 0, 2));
	}

	@Test
	void case3() {
		assertEquals(4, sut.distanceBetweenBusStops(new int[] {1, 2, 3, 4}, 0, 3));
	}

}