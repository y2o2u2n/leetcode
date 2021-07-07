package me.y2o2u2n.p678;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidParenthesisStringTest {
	private final ValidParenthesisString sut = new ValidParenthesisString();

	@Test
	void case1() {
		assertTrue(sut.checkValidString("()"));
	}

	@Test
	void case2() {
		assertTrue(sut.checkValidString("(*)"));
	}

	@Test
	void case3() {
		assertTrue(sut.checkValidString("(*))"));
	}
}