package me.y2o2u2n.p539;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class MinimumTimeDifferenceTest {
	private final MinimumTimeDifference sut = new MinimumTimeDifference();

	@Test
	void case1() {
		assertEquals(1, sut.findMinDifference(List.of("23:59", "00:00")));
	}

	@Test
	void case2() {
		assertEquals(0, sut.findMinDifference(List.of("00:00", "23:59", "00:00")));
	}

	@Test
	void case3() {
		assertEquals(120, sut.findMinDifference(List.of("00:00", "04:00", "22:00")));
	}
}