package me.y2o2u2n.p1366;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2021-05-20
 */
public class RankTeamsByVotes {

	// ABC
	// ACB
	// ABC
	// ACB
	// ACB

	// WXYZ
	// XYZW

	// BCA
	// CAB
	// CBA
	// ABC
	// ACB
	// BAC
	public String rankTeams(String[] votes) {
		if (votes.length == 1) {
			return votes[0];
		}

		int length = votes[0].length();
		Map<Character, Item> map = new HashMap<>();
		for (String vote : votes) {
			for (int i = 0; i < length; i++) {
				char character = vote.charAt(i);
				map.putIfAbsent(character, new Item(character, new int[length]));
				map.get(character).countByInning[i]++;
			}
		}

		List<Item> list = new ArrayList<>();
		for (Map.Entry<Character, Item> entry : map.entrySet()) {
			list.add(entry.getValue());
		}

		list.sort((o1, o2) -> {
			int[] c1 = o1.countByInning;
			int[] c2 = o2.countByInning;

			for (int i = 0; i < length; i++) {
				if (c1[i] != c2[i]) {
					return c2[i] - c1[i];
				}
			}

			return o1.character - o2.character;
		});

		StringBuilder builder = new StringBuilder();

		for (Item item : list) {
			builder.append(item.character);
		}

		return builder.toString();
	}

	private class Item {
		char character;
		int[] countByInning;

		public Item(char character, int[] countByInning) {
			this.character = character;
			this.countByInning = countByInning;
		}
	}

}
