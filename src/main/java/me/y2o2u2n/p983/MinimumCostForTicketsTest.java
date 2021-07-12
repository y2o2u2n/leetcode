package me.y2o2u2n.p983;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MinimumCostForTicketsTest {
	private final MinimumCostForTickets sut = new MinimumCostForTickets();

	@Test
	void case1() {
		assertEquals(11, sut.mincostTickets(new int[] {1, 4, 6, 7, 8, 20}, new int[] {2, 7, 15}));
	}

	@Test
	void case2() {
		assertEquals(17, sut.mincostTickets(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[] {2, 7, 15}));
	}

	@Test
	void case3() {
		assertEquals(6, sut.mincostTickets(new int[] {1, 4, 6, 7, 8, 20}, new int[] {7, 2, 15}));
	}

}