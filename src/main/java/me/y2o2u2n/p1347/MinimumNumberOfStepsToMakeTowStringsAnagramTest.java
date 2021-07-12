package me.y2o2u2n.p1347;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MinimumNumberOfStepsToMakeTowStringsAnagramTest {
	private final MinimumNumberOfStepsToMakeTowStringsAnagram sut = new MinimumNumberOfStepsToMakeTowStringsAnagram();

	@Test
	void case1() {
		assertEquals(1, sut.minSteps("bab", "aba"));
	}

	@Test
	void case2() {
		assertEquals(5, sut.minSteps("leetcode", "practice"));
	}

	@Test
	void case3() {
		assertEquals(0, sut.minSteps("anagram", "mangaar"));
	}

	@Test
	void case4() {
		assertEquals(0, sut.minSteps("xxyyzz", "xxyyzz"));
	}

	@Test
	void case5() {
		assertEquals(4, sut.minSteps("friend", "family"));
	}
}