package me.y2o2u2n.p179;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-06-24
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
		List<String> stringList = new ArrayList<>();
		for (int num : nums) {
			stringList.add(String.valueOf(num));
		}

		stringList.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));

		if ("0".equals(stringList.get(0))) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		for (String string : stringList) {
			sb.append(string);
		}

		return sb.toString();
	}
}
