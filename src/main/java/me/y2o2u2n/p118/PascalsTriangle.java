package me.y2o2u2n.p118;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-04-07
 */
public class PascalsTriangle {
	public static void main(String[] args) {
		printListList(generate(5));
		printListList(generate(1));
	}

	private static List<List<Integer>> generate(int numRows) {
		int[][] m = new int[numRows][numRows];

		for (int i = 0; i < numRows; i++) {
			m[i][0] = 1;
			m[i][i] = 1;
		}

		for (int j = 1; j < numRows; j++) {
			for (int i = 1; i < j; i++) {
				m[j][i] = m[j - 1][i - 1] + m[j - 1][i];
			}
		}


		List<List<Integer>> ret = new ArrayList<>();
		for (int j = 0; j < numRows; j++) {
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i <= j; i++) {
				temp.add(m[j][i]);
			}
			ret.add(temp);
		}

		return ret;
	}

	private static void printListList(List<List<Integer>> threeSum) {
		for (List<Integer> list : threeSum) {
			for (int i : list) {
				System.out.print(i);
			}
			System.out.println();
		}
		System.out.println();
	}
}
