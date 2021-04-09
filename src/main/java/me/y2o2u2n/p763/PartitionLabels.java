package me.y2o2u2n.p763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-04-09
 */
public class PartitionLabels {

	public static void main(String[] args) {
		printList(partitionLabels("ababcbacadefegdehijhklij"));
	}

	private static List<Integer> partitionLabels(String S) {
		int[] last = new int[26];
		for (int i = 0; i < S.length(); i++) {
			last[S.charAt(i) - 'a'] = i;
		}

		int start = 0;
		int end = 0;
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < S.length(); i++) {
			end = Math.max(end, last[S.charAt(i) - 'a']);

			if (i == end) {
				ans.add(i - start + 1);
				start = i + 1;
			}
		}

		return ans;
	}

	private static void printList(List<Integer> list) {
		for (int i : list) {
			System.out.print(i + ",");
		}
		System.out.println();
	}
}
