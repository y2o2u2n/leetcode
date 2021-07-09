package me.y2o2u2n.p1481;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeastNumberOfUniqueIntegersAfterKRemovalsTest {
    private final LeastNumberOfUniqueIntegersAfterKRemovals sut = new LeastNumberOfUniqueIntegersAfterKRemovals();

    @Test
    void case1() {
        assertEquals(1, sut.findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
    }

    @Test
    void case2() {
        assertEquals(2, sut.findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
    }

}