package me.y2o2u2n.p784;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/07/01
 */
class LetterCasePermutationTest {
	private final LetterCasePermutation sut = new LetterCasePermutation();

	@Test
	void case1() {
		List<String> expected = List.of("a1b2","a1B2","A1b2","A1B2");
		List<String> actual = sut.letterCasePermutation("a1b2");

		assertEquals(expected.size(), actual.size());
		assertTrue(expected.containsAll(actual));
		assertTrue(actual.containsAll(expected));
	}

	@Test
	void case2() {
		List<String> expected = List.of("3z4","3Z4");
		List<String> actual = sut.letterCasePermutation("3z4");

		assertEquals(expected.size(), actual.size());
		assertTrue(expected.containsAll(actual));
		assertTrue(actual.containsAll(expected));
	}
}