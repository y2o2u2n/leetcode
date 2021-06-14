package me.y2o2u2n.p729;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/06/14
 */
class MyCalendarTest {

	@Test
	void case1() {
		MyCalendar sut = new MyCalendar();
		assertTrue(sut.book(10, 20));
		assertFalse(sut.book(15, 25));
		assertTrue(sut.book(20, 30));
	}
}