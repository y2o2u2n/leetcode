package me.y2o2u2n.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/08/29
 */
class Solution1Test {
	@Test
	public void case1() {
		String[] actual = new Solution1().solution(
			new String[] {
				"alex pizza pasta",
				"alex pizza pizza",
				"alex noddle",
				"bob pasta",
				"bob noodle sandwich pasta",
				"bob steak noodle",
			}
		);

		assertArrayEquals(new String[] {"bob"}, actual);
	}

	@Test
	public void case2() {
		String[] actual = new Solution1().solution(
			new String[] {
				"alex pizza pasta steak",
				"bob noodle sandwich pasta",
				"choi pizza sandwich pizza",
				"alex pizza pasta steak"
			}
		);

		assertArrayEquals(new String[] {"alex", "bob"}, actual);
	}
}
