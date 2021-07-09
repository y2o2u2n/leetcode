package me.y2o2u2n.p392;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsSubsequenceTest {
    private final IsSubsequence sut = new IsSubsequence();

    @Test
    void case1() {
        assertTrue(sut.isSubsequence("abc","ahbgdc"));
    }

    @Test
    void case2() {
        assertFalse(sut.isSubsequence("axc","ahbgdc"));
    }
}