package me.y2o2u2n.p322;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2021-06-17
 */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		return s3(coins, amount);
	}

	private Map<Integer, Integer> countByAmount = new HashMap<>();

	private int s3(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}

		if (countByAmount.containsKey(amount)) {
			return countByAmount.get(amount);
		}

		int n = amount + 1;

		for (int coin : coins) {
			int current = 0;
			if (amount >= coin) {
				int next = coinChange(coins, amount - coin);
				if (next >= 0) {
					current = next + 1;
				}
			}

			if (current > 0) {
				n = Math.min(n, current);
			}
		}

		int count = n == amount + 1 ? -1 : n;
		countByAmount.put(amount, count);
		return count;
	}

	// 2 5 3 6, 10, 2

	// Time Limit Exceeded
	private int s2(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}

		int n = amount + 1;

		for (int coin : coins) {
			int current = 0;
			if (amount >= coin) {
				int next = coinChange(coins, amount - coin);
				if (next >= 0) {
					current = next + 1;
				}
			}

			if (current > 0) {
				n = Math.min(n, current);
			}
		}

		return n == amount + 1 ? -1 : n;
	}

	// Wrong Answer
	private int s1(int[] coins, int amount) {
		List<Integer> coinList = new ArrayList<>();
		for (int coin : coins) {
			coinList.add(coin);
		}

		coinList.sort(Collections.reverseOrder());

		int ans = 0;

		for (int coin : coinList) {
			while (amount >= coin) {
				amount -= coin;
				ans++;
			}
		}

		if (amount > 0) {
			return -1;
		}

		return ans;
	}
}
