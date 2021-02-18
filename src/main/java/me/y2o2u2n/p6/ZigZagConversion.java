package me.y2o2u2n.p6;

public class ZigZagConversion {

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 4));
	}

	private static String convert(String s, int numRows) {
		char[] chars = s.toCharArray();
		int numChars = s.length();

		if (numChars == 1 || numRows == 1) {
			return s;
		}

		char[][] map = new char[numRows][numChars];

		int i = 0;
		int j = 0;
		int k = 0;
		boolean down = true;
		while (k < s.length()) {
			// System.out.println(chars[k]);
			map[i][j] = chars[k];
			if (down) {
				if (i != numRows - 1) {
					i++;
				} else {
					down = false;
					i--;
					j++;
				}
			} else {
				if (i != 0) {
					i--;
					j++;
				} else {
					down = true;
					i++;
				}
			}

			k++;
		}

		StringBuilder builder = new StringBuilder();

		for (int a = 0; a < numRows; a++) {
			for (int b = 0; b <= j; b++) {
				if (map[a][b] != '\0') {
					builder.append(map[a][b]);
				}
			}
		}

		// for (int row = 0; row < map.length; row++) {
		// 	for (int col = 0; col < map[row].length; col++) {
		// 		System.out.print(map[row][col] + ",");
		// 	}
		// 	System.out.println();
		// }

		return builder.toString();
	}

}
