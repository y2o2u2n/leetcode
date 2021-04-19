package me.y2o2u2n.p1557;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-04-19
 */
public class MinimumNumberOfVerticesToReachAllNodes {

	public static void main(String[] args) {
		printList(
			findSmallestSetOfVertices(
				6,
				List.of(
					List.of(0, 1),
					List.of(0, 2),
					List.of(2, 5),
					List.of(3, 4),
					List.of(4, 2)
				)
			)
		);

		printList(
			findSmallestSetOfVertices(
				5,
				List.of(
					List.of(0, 1),
					List.of(2, 1),
					List.of(3, 1),
					List.of(1, 4),
					List.of(2, 4)
				)
			)
		);
	}

	private static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		Set<Integer> toSet = new HashSet<>();
		for (List<Integer> edge : edges) {
			Integer from = edge.get(0);
			Integer to = edge.get(1);
			toSet.add(to);
		}

		List<Integer> ret = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (!toSet.contains(i)) {
				ret.add(i);
			}
		}

		return ret;
	}

	private static void printList(List<Integer> list) {
		for (int i : list) {
			System.out.print(i);
		}
		System.out.println();
	}
}
