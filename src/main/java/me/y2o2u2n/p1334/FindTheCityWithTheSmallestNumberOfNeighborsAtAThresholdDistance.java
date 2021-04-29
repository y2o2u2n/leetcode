package me.y2o2u2n.p1334;

/**
 * Created by JunSeok Youn on 2021-04-29
 */
public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
	public static void main(String[] args) {
		System.out.println(
			findTheCity(
				4,
				new int[][] {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}},
				4
			)
		);

		System.out.println();

		System.out.println(
			findTheCity(
				5,
				new int[][] {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}},
				2
			)
		);
	}

	// Wrong Answer
	private static int findTheCity(int n, int[][] edges, int distanceThreshold) {
		return -1;
		// int min = Integer.MAX_VALUE;
		// int minCity = -1;
		//
		// for (int city = 0; city < n; city++) {
		// 	boolean[] visited = new boolean[n];
		// 	visited[city] = true;
		// 	int val = visit(n, edges, visited, distanceThreshold, city, 0);
		// 	visited[city] = false;
		// 	System.out.println(val);
		// 	if (val <= min) {
		// 		min = val;
		// 		minCity = city;
		// 	}
		// }
		// System.out.println();
		//
		// return minCity;
	}

	// private static int visit(int n, int[][] edges, boolean[] visited, int leftDistance, int city, int depth) {
	// 	if (leftDistance == 0) {
	// 		return 1;
	// 	} else {
	//
	// 		int count = 1;
	//
	// 		for (int i = 0; i < edges.length; i++) {
	// 			int from = edges[i][0];
	// 			int to = edges[i][1];
	// 			int weight = edges[i][2];
	//
	// 			// case 1
	// 			if (from == city && !visited[to] && leftDistance >= weight) {
	// 				visited[to] = true;
	// 				count += visit(n, edges, visited, leftDistance - weight, to, depth + 1);
	// 				visited[to] = false;
	// 			}
	//
	// 			// case 2
	// 			if (to == city && !visited[from] && leftDistance >= weight) {
	// 				visited[from] = true;
	// 				count += visit(n, edges, visited, leftDistance - weight, from, depth + 1);
	// 				visited[from] = false;
	// 			}
	// 		}
	//
	// 		return count;
	// 	}
	// }
}
