package me.y2o2u2n.p981;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeMapTest {
	@Test
	void case1() {
		TimeMap timeMap = new TimeMap();
		timeMap.set("foo", "bar", 1);
		assertEquals("bar", timeMap.get("foo", 1));
		assertEquals("bar", timeMap.get("foo", 3));
		timeMap.set("foo", "bar2", 4);
		assertEquals("bar2", timeMap.get("foo", 4));
		assertEquals("bar2", timeMap.get("foo", 5));
	}

	@Test
	void case2() {
		TimeMap timeMap = new TimeMap();
		timeMap.set("love","high",10);
		timeMap.set("love","low",20);
		assertEquals("", timeMap.get("love",5));
		assertEquals("high", timeMap.get("love",10));
		assertEquals("high", timeMap.get("love",15));
		assertEquals("low", timeMap.get("love",20));
		assertEquals("low", timeMap.get("love",25));
	}
}