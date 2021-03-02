package me.y2o2u2n.p121;

/**
 * Created by JunSeok Youn on 2021-03-02
 */
public class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
		System.out.println(maxProfit(new int[] {7, 6, 4, 3, 1}));
		System.out.println(maxProfit(new int[] {2, 4, 1}));
	}

	private static int maxProfit(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int price : prices) {
			if (price < minPrice) {
				minPrice = price;
			} else if (price - minPrice > maxProfit) {
				maxProfit = price - minPrice;
			}
		}

		return maxProfit;
	}
}
