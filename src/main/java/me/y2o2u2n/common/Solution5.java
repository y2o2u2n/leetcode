package me.y2o2u2n.common;

/**
 * Created by JunSeok Youn on 2021/08/14
 */
public class Solution5 {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for (int buy = 0; buy < prices.length; buy++) {
			int benefitDays = 0;
			for (int sell = buy + 1; sell < prices.length; sell++) {
				if (prices[sell] > prices[buy]) {
					benefitDays++;
				}
			}
			answer[buy] = benefitDays;
		}

		return answer;
	}
}
