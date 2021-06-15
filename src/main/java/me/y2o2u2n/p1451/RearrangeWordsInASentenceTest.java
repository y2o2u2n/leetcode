package me.y2o2u2n.p1451;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/06/15
 */
class RearrangeWordsInASentenceTest {
	private final RearrangeWordsInASentence sut = new RearrangeWordsInASentence();

	@Test
	void case1() {
		assertEquals("Is cool leetcode", sut.arrangeWords("Leetcode is cool"));
	}

	@Test
	void case2() {
		assertEquals("On and keep calm code", sut.arrangeWords("Keep calm and code on"));
	}

	@Test
	void case3() {
		assertEquals("To be or to be not", sut.arrangeWords("To be or not to be"));
	}
}