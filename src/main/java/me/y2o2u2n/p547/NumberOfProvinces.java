package me.y2o2u2n.p547;

/**
 * Created by JunSeok Youn on 2021-06-24
 */
public class NumberOfProvinces {
	public int findCircleNum(int[][] isConnected) {
		int count = 0;
		int n = isConnected.length;
		boolean[] visited = new boolean[n];

		for (int city = 0; city < n; city++) {
			if (!visited[city]) {
				visit(isConnected, visited, city);
				count++;
			}
		}

		return count;
	}

	private void visit(int[][] isConnected, boolean[] visited, int current) {
		visited[current] = true;
		for (int next = 0; next < isConnected[current].length; next++) {
			if (!visited[next] && isConnected[current][next] == 1) {
				visit(isConnected, visited, next);
			}
		}
	}
}
