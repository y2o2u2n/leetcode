package me.y2o2u2n.p1054;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2021-05-26
 */
public class DistantBarcodes {
	public int[] rearrangeBarcodes(int[] barcodes) {
		Map<Integer, Integer> frequency = new HashMap<>();

		for (int barcode : barcodes) {
			Integer count = frequency.getOrDefault(barcode, 0);
			frequency.put(barcode, count + 1);
		}

		ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequency.entrySet());
		entries.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

		int[] ans = new int[barcodes.length];
		int i = 0;

		for (Map.Entry<Integer, Integer> entry : entries) {
			Integer barcode = entry.getKey();
			Integer count = entry.getValue();

			while (count > 0) {
				count--;

				ans[i] = barcode;
				i += 2;

				if (i >= barcodes.length) {
					i = 1;
				}
			}
		}

		return ans;
	}
}
