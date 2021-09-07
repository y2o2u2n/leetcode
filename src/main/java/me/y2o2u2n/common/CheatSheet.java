package me.y2o2u2n.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class CheatSheet {

	// n ≤ 1,000,000 일 때 예상된 시간 복잡도는 O(n), O(n*log(n))
	// n ≤ 10,000 일 때 예상된 시간 복잡도는 O(n^2)
	// n ≤ 500 일 때 예상된 시간 복잡도는 O(n^3)

	// dfs
	static class DfsGraph {
		private LinkedList<Integer> adjLists[];
		private boolean visited[];

		// Graph creation
		DfsGraph(int vertices) {
			adjLists = new LinkedList[vertices];
			visited = new boolean[vertices];

			for (int i = 0; i < vertices; i++)
				adjLists[i] = new LinkedList<Integer>();
		}

		// Add edges
		void addEdge(int src, int dest) {
			adjLists[src].add(dest);
		}

		// DFS algorithm
		void DFS(int vertex) {
			visited[vertex] = true;
			System.out.print(vertex + " ");

			Iterator<Integer> ite = adjLists[vertex].listIterator();
			while (ite.hasNext()) {
				int adj = ite.next();
				if (!visited[adj])
					DFS(adj);
			}
		}

		public static void main(String args[]) {
			me.y2o2u2n.common.CheatSheet.DfsGraph g = new me.y2o2u2n.common.CheatSheet.DfsGraph(4);

			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(1, 2);
			g.addEdge(2, 3);

			System.out.println("Following is Depth First Traversal");

			g.DFS(2);
		}
	}

	// bfs
	public static class BfsGraph {
		private int V;
		private LinkedList<Integer> adj[];

		// Create a graph
		BfsGraph(int v) {
			V = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; ++i)
				adj[i] = new LinkedList();
		}

		// Add edges to the graph
		void addEdge(int v, int w) {
			adj[v].add(w);
		}

		// BFS algorithm
		void BFS(int s) {

			boolean visited[] = new boolean[V];

			LinkedList<Integer> queue = new LinkedList();

			visited[s] = true;
			queue.add(s);

			while (queue.size() != 0) {
				s = queue.poll();
				System.out.print(s + " ");

				Iterator<Integer> i = adj[s].listIterator();
				while (i.hasNext()) {
					int n = i.next();
					if (!visited[n]) {
						visited[n] = true;
						queue.add(n);
					}
				}
			}
		}

		public static void main(String args[]) {
			me.y2o2u2n.common.CheatSheet.BfsGraph g = new me.y2o2u2n.common.CheatSheet.BfsGraph(4);

			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(1, 2);
			g.addEdge(2, 0);
			g.addEdge(2, 3);
			g.addEdge(3, 3);

			System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

			g.BFS(2);
		}
	}

	public void pq() {
		PriorityQueue<TreeNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
	}

	private static int binarySearch(int[] arr, int from, int to, int key) {
		int low = from;
		int high = to - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (arr[mid] < key)
				low = mid + 1;
			else if (arr[mid] > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}

	class Solution {
		public boolean isValidBST(TreeNode root) {
			return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		public boolean isValid(TreeNode node, int min, int max) {
			if (node == null) {
				return true;
			}

			return min < node.val && node.val < max
				&& isValid(node.left, min, node.val)
				&& isValid(node.right, node.val, max);
		}
	}

	public static void main(String[] args) {
		CheatSheet cheatSheet = new CheatSheet();
		cheatSheet.bitwise();
	}

	public void stream() {
		List<List<Integer>> contests = new ArrayList<>();
		contests.stream()
			.filter(contest -> contest.get(1) == 0)
			.map(contest -> contest.get(0))
			.sorted((a, b) -> a - b)
			.skip(0)
			.limit(3)
			.reduce((a, b) -> (a + b))
			.get();

		contests.stream()
			.collect(Collectors.toList());

		contests.stream()
			.collect(Collectors.toSet());
	}

	public class MyQueue<T> {
		Stack<T> first;
		Stack<T> second;

		void enqueue(T data) {

		}

	}

	public int gcd(int p, int q) {
		if (q == 0)
			return p;
		return gcd(q, p % q);
	}

	public void stack() {
		Stack stack = new Stack();
	}

	public void compare() {
		new Comparator<>() {
			@Override
			public int compare(Object o1, Object o2) {
				return 0;
			}
		};

		Integer.compare(1, 2);
		"a".compareTo("");
	}

	public void copy() {
		int[] a = new int[] {1, 2, 3, 4};
		int[] b = a.clone();
	}

	public void bitwise() {
		System.out.println(1 & 1); // AND
		System.out.println(1 | 1); // OR
		System.out.println(1 ^ 1); // XOR : 다르면 1
		System.out.println(~1); // NOT
		System.out.println(1 << 2); // LEFT SHIFT
		System.out.println(1024 >> 2); // RIGHT SHIFT
		System.out.println(9L ^ ((1L << 32) - 1));
	}

	public void set() {
		Set<Object> set = new HashSet<>();
		set.add(null);
	}

	public void queue() {
		new LinkedList<>().offer(1);
	}

	public void map() {
		Map<Character, Integer> map = new HashMap<>();

		int count = map.getOrDefault('c', 0);
		map.put('c', count);

		Set<Map.Entry<Character, Integer>> entries = map.entrySet();
		for (Map.Entry<Character, Integer> entry : entries) {
			Character key = entry.getKey();
			Integer value = entry.getValue();
		}

		ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort(new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return 0;
			}
		});
	}

	public void string() {
		String str = "";
		str.charAt(0);
		for (char ch : str.toCharArray()) {

		}
	}

	public void sort() {
		List<Integer> list = new ArrayList<>();
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return 0;
			}
		});

		int[] arr = new int[5];
		Arrays.sort(arr);
	}

	public void list() {
		List<Integer> list = new ArrayList<>();
		list.set(1, 2);
	}
}
