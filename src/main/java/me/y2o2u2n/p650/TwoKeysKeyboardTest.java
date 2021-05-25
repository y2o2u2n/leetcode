package me.y2o2u2n.p650;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-05-25
 */
class TwoKeysKeyboardTest {

	@Test
	void minSteps() {
		TwoKeysKeyboard sut = new TwoKeysKeyboard();

		assertEquals(0, sut.minSteps(1));
		assertEquals(2, sut.minSteps(2));
		assertEquals(3, sut.minSteps(3));
		assertEquals(4, sut.minSteps(4));
		assertEquals(5, sut.minSteps(5));
		assertEquals(5, sut.minSteps(6));
		assertEquals(7, sut.minSteps(7));
		assertEquals(6, sut.minSteps(8));
		assertEquals(6, sut.minSteps(9));
		assertEquals(7, sut.minSteps(10));
		assertEquals(7, sut.minSteps(12));
		assertEquals(8, sut.minSteps(18));
		assertEquals(9, sut.minSteps(24));
		assertEquals(14, sut.minSteps(100));
	}
}