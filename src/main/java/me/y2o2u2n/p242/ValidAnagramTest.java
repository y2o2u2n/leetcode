package me.y2o2u2n.p242;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-06-17
 */
class ValidAnagramTest {
	private final ValidAnagram sut = new ValidAnagram();

	@Test
	void case1() {
		assertTrue(sut.isAnagram("anagram", "nagaram"));
	}

	@Test
	void case2() {
		assertFalse(sut.isAnagram("rat", "car"));
	}
}