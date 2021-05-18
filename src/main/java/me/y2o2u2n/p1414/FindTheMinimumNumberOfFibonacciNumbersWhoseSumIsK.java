package me.y2o2u2n.p1414;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-05-19
 */
public class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK {

	public static void main(String[] args) {
		System.out.println(findMinFibonacciNumbers(1));
		System.out.println(findMinFibonacciNumbers(5));
		System.out.println(findMinFibonacciNumbers(7));
		System.out.println(findMinFibonacciNumbers(10));
		System.out.println(findMinFibonacciNumbers(19));
	}

	private static int findMinFibonacciNumbers(int k) {
		List<Integer> f = new ArrayList<>();
		f.add(0);
		f.add(1);
		f.add(2);

		int i = 3;
		while (true) {
			int next = f.get(i - 1) + f.get(i - 2);

			if (next > k) {
				break;
			}

			f.add(next);
			i++;
		}

		int pivot = f.size() - 1;

		int count = 0;

		while (k > 0) {
			count += (k / f.get(pivot));
			k %= f.get(pivot);

			pivot--;
		}

		return count;
	}
}
