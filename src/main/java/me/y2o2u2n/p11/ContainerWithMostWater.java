package me.y2o2u2n.p11;

/**
 * Created by JunSeok Youn on 2021-02-24
 */
public class ContainerWithMostWater {
	public static void main(String[] args) {
		System.out.println(maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
		System.out.println(maxArea(new int[] {1, 1}));
		System.out.println(maxArea(new int[] {4, 3, 2, 1, 4}));
		System.out.println(maxArea(new int[] {1, 2, 1}));
	}

	private static int maxArea(int[] height) {
		int n = height.length;
		int max = Integer.MIN_VALUE;

		if (n == 1) {
			return 0;
		}

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
			}
		}

		return max;
	}
}
