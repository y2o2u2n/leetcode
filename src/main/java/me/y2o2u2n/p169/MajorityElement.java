package me.y2o2u2n.p169;

import java.util.Stack;

/**
 * Created by JunSeok Youn on 2021-03-05
 */
public class MajorityElement {

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] {3, 2, 3}));
		System.out.println(majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
	}

	private static int majorityElement(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		for (int n : nums) {
			if (stack.isEmpty()) {
				stack.push(n);
			} else {
				int peek = stack.peek();
				if (peek != n) {
					stack.pop();
				} else {
					stack.push(n);
				}
			}
		}

		return stack.peek();
	}
}
