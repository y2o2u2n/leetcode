package me.y2o2u2n.p373;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by JunSeok Youn on 2021-06-16
 */
public class FindKPairsWithSmallestSums {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		return s2(nums1, nums2, k);
	}

	// Success - O(k^2)
	private List<List<Integer>> s2(int[] nums1, int[] nums2, int k) {
		PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(o -> (o.get(0) + o.get(1))));

		for (int i = 0; i < Math.min(nums1.length, k); i++) {
			for (int j = 0; j < Math.min(nums2.length, k); j++) {
				List<Integer> candidate = List.of(nums1[i], nums2[j]);
				pq.offer(candidate);
			}
		}

		List<List<Integer>> ans = new ArrayList<>();
		int i = Math.min(pq.size(), k);

		while (i-- > 0) {
			ans.add(pq.poll());
		}

		return ans;
	}

	// Success - O(k^2)
	private List<List<Integer>> s1(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> candidates = new ArrayList<>();

		for (int i = 0; i < Math.min(nums1.length, k); i++) {
			for (int j = 0; j < Math.min(nums2.length, k); j++) {
				List<Integer> candidate = List.of(nums1[i], nums2[j]);
				candidates.add(candidate);
			}
		}

		candidates.sort(Comparator.comparingInt(o -> (o.get(0) + o.get(1))));

		return candidates.subList(0, Math.min(candidates.size(), k));
	}
}
