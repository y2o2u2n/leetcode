package me.y2o2u2n.p202;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-04-12
 */
public class HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy(19));
		System.out.println(isHappy(2));
	}

	private static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();

		while (true) {
			int sum = 0;
			while (n > 0) {
				sum += (n % 10) * (n % 10);
				n = n / 10;
			}

			if (sum == 1) {
				return true;
			} else if (set.contains(sum)) {
				return false;
			} else {
				n = sum;
				set.add(n);
			}
		}
	}

}
