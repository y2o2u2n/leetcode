package me.y2o2u2n.p380;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-06-22
 */
public class RandomizedSet {
	private final Set<Integer> set;
	private final Random random;

	public RandomizedSet() {
		set = new HashSet<>();
		random = new Random();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		boolean ret = !set.contains(val);
		set.add(val);
		return ret;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		boolean ret = set.contains(val);
		set.remove(val);
		return ret;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		Integer[] arr = set.toArray(new Integer[set.size()]);
		int index = random.nextInt(set.size());
		return arr[index];
	}
}
