package me.y2o2u2n.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by JunSeok Youn on 2021/08/29
 */
public class Solution1 {
	public String[] solution(String[] orders) {
		Map<String, Set<String>> menusByUser = new HashMap<>();

		for (String order : orders) {
			String user = order.substring(0, order.indexOf(" "));
			String[] menuArr = order.substring(order.indexOf(" ") + 1).split(" ");

			Set<String> menus = menusByUser.getOrDefault(user, new HashSet<>());
			menus.addAll(Arrays.asList(menuArr));
			menusByUser.put(user, menus);
		}

		List<Map.Entry<String, Set<String>>> list = new ArrayList<>(menusByUser.entrySet());
		list.sort((o1, o2) -> {
			int s1 = o1.getValue().size();
			int s2 = o2.getValue().size();

			if (s1 - s2 != 0) {
				return s2 - s1;
			}

			String u1 = o1.getKey();
			String u2 = o2.getKey();

			return u1.compareTo(u2);
		});

		int firstSize = list.get(0).getValue().size();

		return list.stream()
			.filter(e -> e.getValue().size() == firstSize)
			.map(Map.Entry::getKey)
			.collect(Collectors.toList())
			.toArray(String[]::new);
	}
}
