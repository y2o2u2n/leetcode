package me.y2o2u2n.p1455;

/**
 * Created by JunSeok Youn on 2021/06/15
 */
public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
	public int isPrefixOfWord(String sentence, String searchWord) {
		String[] splited = sentence.split(" ");

		for (int i = 0; i < splited.length; i++) {
			String str = splited[i];

			if (str.indexOf(searchWord) == 0) {
				return i + 1;
			}
		}

		return -1;
	}
}
