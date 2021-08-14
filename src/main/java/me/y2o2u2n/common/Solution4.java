package me.y2o2u2n.common;

/**
 * Created by JunSeok Youn on 2021/08/14
 */
public class Solution4 {
	public int solution(int[] T, int[][] R, int k) {
		boolean[] visited = new boolean[T.length];
		visited[k - 1]= true;
		return visit(T, R, k, visited);
	}

	private int visit(int[] T, int[][] R, int current, boolean[] visited) {
		int currentTime = T[current - 1];
		int maxOthersTime = 0;

		for (int[] r : R) {
			int start = r[0];
			int end = r[1];
			if (end == current && !visited[start - 1]) {
				visited[start - 1] = true;
				maxOthersTime = Math.max(maxOthersTime, visit(T, R, start, visited));
				visited[start - 1] = false;
			}
		}

		return currentTime + maxOthersTime;
	}
}
