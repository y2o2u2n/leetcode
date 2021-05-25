package me.y2o2u2n.p134;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-05-26
 */
class GasStationTest {

	@Test
	void canCompleteCircuit() {
		GasStation sut = new GasStation();

		assertEquals(3, sut.canCompleteCircuit(new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5, 1, 2}));
		assertEquals(-1, sut.canCompleteCircuit(new int[] {2, 3, 4}, new int[] {3, 4, 3}));
	}
}