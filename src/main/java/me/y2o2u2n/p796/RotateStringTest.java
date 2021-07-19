package me.y2o2u2n.p796;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RotateStringTest {
	private RotateString sut;

	@BeforeEach
	void setUp() {
		sut = new RotateString();
	}

	@Test
	void case1() {
		assertTrue(sut.rotateString("abcde", "cdeab"));
	}

	@Test
	void case2() {
		assertFalse(sut.rotateString("abcde", "abced"));
	}
}