package me.y2o2u2n.p1347;

public class MinimumNumberOfStepsToMakeTowStringsAnagram {
	public int minSteps(String s, String t) {
		int[][] frequency = new int['z' - 'a' + 1][2];
		for (int i = 0; i < s.length(); i++) {
			frequency[s.charAt(i) - 'a'][0]++;
			frequency[t.charAt(i) - 'a'][1]++;
		}

		int steps = 0;
		for (int i = 0; i < 'z' - 'a' + 1; i++) {
			if (frequency[i][0] < frequency[i][1]) {
				steps += frequency[i][1] - frequency[i][0];
			}
		}

		return steps;
	}
}
