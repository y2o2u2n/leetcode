package me.y2o2u2n.p771;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JewelsAndStonesTest {
	private final JewelsAndStones sut = new JewelsAndStones();

	@Test
	void case1() {
		assertEquals(3, sut.numJewelsInStones("aA", "aAAbbbb"));
	}

	@Test
	void case2() {
		assertEquals(0, sut.numJewelsInStones("z", "ZZ"));
	}
}