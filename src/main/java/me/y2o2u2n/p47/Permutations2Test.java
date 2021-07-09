package me.y2o2u2n.p47;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Permutations2Test {
    private final Permutations2 sut = new Permutations2();

    @Test
    void case1() {
        List<List<Integer>> expected = List.of(
                List.of(1, 1, 2),
                List.of(1, 2, 1),
                List.of(2, 1, 1)
        );
        List<List<Integer>> actual = sut.permuteUnique(new int[]{1, 1, 2});

        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual));
        assertTrue(actual.containsAll(expected));
    }

    @Test
    void case2() {
        List<List<Integer>> expected = List.of(
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1, 3),
                List.of(2, 3, 1),
                List.of(3, 1, 2),
                List.of(3, 2, 1)
        );
        List<List<Integer>> actual = sut.permuteUnique(new int[]{1, 2, 3});

        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual));
        assertTrue(actual.containsAll(expected));
    }
}