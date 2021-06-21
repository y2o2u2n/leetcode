package me.y2o2u2n.p1528;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-06-21
 */
class ShuffleStringTest {
	private final ShuffleString sut = new ShuffleString();

	@Test
	void test1() {
		assertEquals("leetcode", sut.restoreString("codeleet", new int[] {4, 5, 6, 7, 0, 2, 1, 3}));
	}

	@Test
	void test4() {
		assertEquals("arigatou", sut.restoreString("aaiougrt", new int[] {4, 0, 2, 6, 7, 3, 1, 5}));
	}
}