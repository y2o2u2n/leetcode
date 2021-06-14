package me.y2o2u2n.p1455;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/06/15
 */
class CheckIfAWordOccursAsAPrefixOfAnyWordInASentenceTest {
	private final CheckIfAWordOccursAsAPrefixOfAnyWordInASentence sut = new CheckIfAWordOccursAsAPrefixOfAnyWordInASentence();

	@Test
	void case1() {
		assertEquals(4, sut.isPrefixOfWord("i love eating burger", "burg"));
	}
}
