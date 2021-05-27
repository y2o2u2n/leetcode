package me.y2o2u2n.p881;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-05-28
 */
class BoatsToSavePeopleTest {

	@Test
	void numRescueBoats() {
		BoatsToSavePeople sut = new BoatsToSavePeople();

		assertEquals(3, sut.numRescueBoats(new int[] {21, 40, 16, 24, 30}, 50));
		assertEquals(3, sut.numRescueBoats(new int[] {3, 2, 3, 2, 2}, 6));
		assertEquals(3, sut.numRescueBoats(new int[] {3, 8, 7, 1, 4}, 9));
		assertEquals(1, sut.numRescueBoats(new int[] {2, 2}, 6));
		assertEquals(1, sut.numRescueBoats(new int[] {1, 2}, 3));
		assertEquals(3, sut.numRescueBoats(new int[] {3, 2, 2, 1}, 3));
		assertEquals(4, sut.numRescueBoats(new int[] {3, 5, 3, 4}, 5));
		assertEquals(2, sut.numRescueBoats(new int[] {5, 1, 4, 2}, 6));
	}
}