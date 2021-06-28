package me.y2o2u2n.p1299;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-06-28
 */
class ReplaceElementsWithGreatestElementOnRightSideTest {
	private final ReplaceElementsWithGreatestElementOnRightSide sut = new ReplaceElementsWithGreatestElementOnRightSide();

	@Test
	void case1() {
		assertArrayEquals(new int[] {18, 6, 6, 6, 1, -1}, sut.replaceElements(new int[] {17, 18, 5, 4, 6, 1}));
	}

}