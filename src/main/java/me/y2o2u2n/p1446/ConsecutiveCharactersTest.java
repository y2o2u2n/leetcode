package me.y2o2u2n.p1446;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/07/01
 */
class ConsecutiveCharactersTest {
	private final ConsecutiveCharacters sut = new ConsecutiveCharacters();

	@Test
	void case1() {
		assertEquals(2, sut.maxPower("leetcode"));
	}

	@Test
	void case2() {
		assertEquals(5, sut.maxPower("abbcccddddeeeeedcba"));
	}

	@Test
	void case3() {
		assertEquals(5, sut.maxPower("triplepillooooow"));
	}
}