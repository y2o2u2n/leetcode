package me.y2o2u2n.p1854;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-05-27
 */
class MaximumPopulationYearTest {

	@Test
	void maximumPopulation() {
		MaximumPopulationYear sut = new MaximumPopulationYear();

		assertEquals(1993, sut.maximumPopulation(new int[][] {{1993, 1999}, {2000, 2010}}));
		assertEquals(1960, sut.maximumPopulation(new int[][] {{1950, 1961}, {1960, 1971}, {1970, 1981}}));
	}
}