package me.y2o2u2n.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/08/29
 */
class Solution2Test {

	@Test
	public void case1() {
		String[] actual = new Solution2().solution(
			1,
			new String[] {
				"1 fracta",
				"1 sina",
				"1 hana",
				"1 robel",
				"1 abc",
				"1 sina",
				"1 lynn"
			}
		);

		assertArrayEquals(
			new String[]{"sina", "hana", "robel", "abc", "lynn"},
			actual
		);
	}

	@Test
	public void case2() {
		String[] actual = new Solution2().solution(
			4,
			new String[] {
				"1 a",
				"1 b",
				"1 abc",
				"3 b",
				"3 a",
				"1 abcd",
				"1 abc",
				"1 aaa",
				"1 a",
				"1 z",
				"1 q",
				"3 k",
				"3 q",
				"3 z",
				"3 m",
				"3 b"
			}
		);

		assertArrayEquals(
			new String[]{"abc", "abcd", "aaa", "z", "q", "k", "q", "z", "m", "b"},
			actual
		);
	}

}
