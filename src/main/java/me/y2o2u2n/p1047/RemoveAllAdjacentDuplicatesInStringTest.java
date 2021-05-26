package me.y2o2u2n.p1047;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-05-26
 */
class RemoveAllAdjacentDuplicatesInStringTest {

	@Test
	void removeDuplicates() {
		RemoveAllAdjacentDuplicatesInString sut = new RemoveAllAdjacentDuplicatesInString();

		assertEquals("ca", sut.removeDuplicates("abbaca"));
		assertEquals("ay", sut.removeDuplicates("azxxzy"));
	}
}