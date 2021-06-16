package me.y2o2u2n.p373;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-06-16
 */
class FindKPairsWithSmallestSumsTest {
	private final FindKPairsWithSmallestSums sut = new FindKPairsWithSmallestSums();

	@Test
	void case1() {
		List<List<Integer>> expected = List.of(
			List.of(1, 2),
			List.of(1, 4),
			List.of(1, 6)
		);

		List<List<Integer>> actual = sut.kSmallestPairs(new int[] {1, 7, 11}, new int[] {2, 4, 6}, 3);

		assertNestedArrayEquals(expected, actual);
	}

	@Test
	void case2() {
		List<List<Integer>> expected = List.of(
			List.of(1, 1),
			List.of(1, 1)
		);

		List<List<Integer>> actual = sut.kSmallestPairs(new int[] {1, 1, 2}, new int[] {1, 2, 3}, 2);

		assertNestedArrayEquals(expected, actual);
	}

	@Test
	void case3() {
		List<List<Integer>> expected = List.of(
			List.of(1, 3),
			List.of(2, 3)
		);

		List<List<Integer>> actual = sut.kSmallestPairs(new int[] {1, 2}, new int[] {3}, 3);

		assertNestedArrayEquals(expected, actual);
	}

	private void assertNestedArrayEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
		for (int i = 0; i < expected.size(); i++) {
			List<Integer> eList = expected.get(i);
			List<Integer> aList = actual.get(i);

			assertEquals(eList.get(0), aList.get(0));
			assertEquals(eList.get(1), aList.get(1));
		}
	}
}