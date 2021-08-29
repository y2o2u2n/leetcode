package me.y2o2u2n.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by JunSeok Youn on 2021/08/29
 */
public class Solution2 {
	public String[] solution(int n, String[] record) {
		List<Server> servers = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			servers.add(new Server());
		}

		for (String r : record) {
			String[] split = r.split(" ");
			int index = Integer.parseInt(split[0]) - 1;
			String name = split[1];
			servers.get(index).register(name);
		}

		return servers.stream()
			.filter(server -> !server.isEmpty())
			.map(Server::orderedNames)
			.flatMap(Collection::stream)
			.collect(Collectors.toList())
			.toArray(String[]::new);
	}

	private static class Server {
		private static final int MAX = 5;

		Queue<String> queue;
		Set<String> set;

		public Server() {
			this.queue = new LinkedList<>();
			this.set = new HashSet<>();
		}

		public void register(String name) {
			if (set.contains(name)) {
				return;
			}

			if (queue.size() == MAX) {
				String poll = queue.poll();
				set.remove(poll);
			}

			queue.add(name);
			set.add(name);
		}

		public boolean isEmpty() {
			return queue.isEmpty();
		}

		public List<String> orderedNames() {
			return new ArrayList<>(queue);
		}
	}
}

