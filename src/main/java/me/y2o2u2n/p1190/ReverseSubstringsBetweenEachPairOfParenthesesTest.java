package me.y2o2u2n.p1190;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-05-19
 */
class ReverseSubstringsBetweenEachPairOfParenthesesTest {

	@Test
	void reverseParentheses() {
		// (ed(et(oc))el)
		// (ed(etco)el)
		// (edocteel)
		// (leetcode)

		ReverseSubstringsBetweenEachPairOfParentheses sut = new ReverseSubstringsBetweenEachPairOfParentheses();
		// assertEquals("leetcode", sut.reverseParentheses("(ed(et(oc))el)"));
		assertEquals("tauswa", sut.reverseParentheses("ta()usw((((a))))"));
	}
}