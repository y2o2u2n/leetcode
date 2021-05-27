package me.y2o2u2n.p1447;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-05-28
 */
class SimplifiedFractionsTest {

	@Test
	void simplifiedFractions() {
		SimplifiedFractions sut = new SimplifiedFractions();

		assertTrue(sut.simplifiedFractions(1).containsAll(List.of()));
		assertTrue(sut.simplifiedFractions(2).containsAll(List.of("1/2")));
		assertTrue(sut.simplifiedFractions(3).containsAll(List.of("1/2", "1/3", "2/3")));
		assertTrue(sut.simplifiedFractions(4).containsAll(List.of("1/2", "1/3", "1/4", "2/3", "3/4")));
	}
}