package me.y2o2u2n.p1871;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/06/11
 */
class JumpGame7Test {
	private final JumpGame7 sut = new JumpGame7();

	@Test
	void case1() {
		assertEquals(true, sut.canReach("011010", 2, 3));
	}

	@Test
	void case2() {
		assertEquals(false, sut.canReach("01101110", 2, 3));
	}
}
