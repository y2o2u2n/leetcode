package me.y2o2u2n.p412;

import java.util.List;

/**
 * Created by JunSeok Youn on 2021-04-14
 */
public class FizzBuzz {
	public static void main(String[] args) {
		printList(fizzBuzz(3));
		printList(fizzBuzz(5));
		printList(fizzBuzz(15));
	}

	private static List<String> fizzBuzz(int n) {
		String[] ret = new String[n];

		for (int i = 0; i < n; i++) {
			int x = i + 1;
			ret[i] = String.valueOf(x);
		}

		for (int i = 0; i < n; i++) {
			int x = i + 1;
			if (x % 3 == 0) {
				ret[i] = "Fizz";
			}

			if (x % 5 == 0) {
				ret[i] = "Buzz";
			}

			if (x % 15 == 0) {
				ret[i] = "FizzBuzz";
			}
		}

		return List.of(ret);
	}

	private static void printList(List<String> list) {
		for (String s : list) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}
