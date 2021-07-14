package me.y2o2u2n.p1529;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BulbSwitcher4Test {
	private BulbSwitcher4 sut;

	@BeforeEach
	void setUp() {
		sut = new BulbSwitcher4();
	}

	@Test
	void case1() {
		int expected = 3;
		int actual = sut.minFlips("10111");
		assertEquals(expected, actual);
	}

	@Test
	void case2() {
		int expected = 3;
		int actual = sut.minFlips("101");
		assertEquals(expected, actual);
	}

	@Test
	void case3() {
		int expected = 0;
		int actual = sut.minFlips("00000");
		assertEquals(expected, actual);
	}

	@Test
	void case4() {
		int expected = 5;
		int actual = sut.minFlips("001011101");
		assertEquals(expected, actual);
	}
}