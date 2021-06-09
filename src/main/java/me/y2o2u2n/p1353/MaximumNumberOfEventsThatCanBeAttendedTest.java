package me.y2o2u2n.p1353;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/06/09
 */
class MaximumNumberOfEventsThatCanBeAttendedTest {
	private final MaximumNumberOfEventsThatCanBeAttended sut = new MaximumNumberOfEventsThatCanBeAttended();

	@Test
	void case1() {
		assertEquals(3, sut.maxEvents(new int[][] {{1, 2}, {2, 3}, {3, 4}}));
	}

	@Test
	void case2() {
		assertEquals(4, sut.maxEvents(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 2}}));
	}

	@Test
	void case3() {
		assertEquals(4, sut.maxEvents(new int[][] {{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}}));
	}

	@Test
	void case4() {
		assertEquals(1, sut.maxEvents(new int[][] {{1, 100000}}));
	}

	@Test
	void case5() {
		assertEquals(7, sut.maxEvents(new int[][] {{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}}));
	}

	@Test
	void case6() {
		assertEquals(4, sut.maxEvents(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 2}}));
	}

	@Test
	void case7() {
		assertEquals(4, sut.maxEvents(new int[][] {{1, 3}, {1, 3}, {1, 3}, {3, 4}}));
	}

	@Test
	void case8() {
		assertEquals(5, sut.maxEvents(new int[][] {{1, 2}, {1, 2}, {3, 3}, {1, 5}, {1, 5}}));
	}

	@Test
	void case9() {
		assertEquals(4, sut.maxEvents(new int[][] {{1, 2}, {2, 2}, {3, 3}, {3, 4}, {3, 4}}));
	}
}