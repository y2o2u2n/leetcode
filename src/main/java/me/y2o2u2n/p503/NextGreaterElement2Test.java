package me.y2o2u2n.p503;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/06/09
 */
class NextGreaterElement2Test {
	private final NextGreaterElement2 sut = new NextGreaterElement2();

	@Test
	void case1() {
		assertArrayEquals(new int[] {2, -1, 2}, sut.nextGreaterElements(new int[] {1, 2, 1}));
	}

	@Test
	void case2() {
		assertArrayEquals(new int[] {2, 3, 4, -1, 4}, sut.nextGreaterElements(new int[] {1, 2, 3, 4, 3}));
	}

	@Test
	void case3() {
		assertArrayEquals(new int[] {4, -1, 2, 3, 4}, sut.nextGreaterElements(new int[] {3, 4, 1, 2, 3}));
	}

	@Test
	void case4() {
		assertArrayEquals(new int[] {-1, 5, 5, 5, 5}, sut.nextGreaterElements(new int[] {5, 4, 3, 2, 1}));
	}

}