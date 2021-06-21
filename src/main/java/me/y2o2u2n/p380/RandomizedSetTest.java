package me.y2o2u2n.p380;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-06-22
 */
class RandomizedSetTest {

	@Test
	void case1() {
		RandomizedSet sut = new RandomizedSet();

		assertEquals(true, sut.insert(1));
		assertEquals(false, sut.remove(2));
		assertEquals(true, sut.insert(2));
		assertEquals(2, sut.getRandom());
		assertEquals(true, sut.remove(1));
		assertEquals(false, sut.insert(2));
		assertEquals(2, sut.getRandom());
	}
}