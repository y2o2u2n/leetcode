package me.y2o2u2n.p1137;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NthTribonacciNumberTest {

	@Test
	void tribonacci() {
		NthTribonacciNumber sut = new NthTribonacciNumber();

		assertEquals(4, sut.tribonacci(4));
		assertEquals(1389537, sut.tribonacci(25));
	}
}