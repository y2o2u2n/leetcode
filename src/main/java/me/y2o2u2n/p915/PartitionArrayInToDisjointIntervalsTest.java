package me.y2o2u2n.p915;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PartitionArrayInToDisjointIntervalsTest {
	private final PartitionArrayInToDisjointIntervals sut = new PartitionArrayInToDisjointIntervals();

	@Test
	void case1() {
		assertEquals(3, sut.partitionDisjoint(new int[] {5, 0, 3, 8, 6}));
	}

	@Test
	void case2() {
		assertEquals(4, sut.partitionDisjoint(new int[] {1, 1, 1, 0, 6, 12}));
	}
}