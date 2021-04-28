package me.y2o2u2n.p946;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by JunSeok Youn on 2021-04-28
 */
public class ValidateStackSequences {

	public static void main(String[] args) {
		System.out.println(validateStackSequences(new int[] {1, 2, 3, 4, 5}, new int[] {4, 5, 3, 2, 1})); // true
		System.out.println(validateStackSequences(new int[] {1, 2, 3, 4, 5}, new int[] {4, 3, 5, 1, 2})); // false
		System.out.println(validateStackSequences(new int[] {2, 1, 0}, new int[] {1, 2, 0})); // true
	}

	private static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();

		for (int number : popped) {
			queue.offer(number);
		}

		for (int number : pushed) {
			stack.push(number);

			int x = stack.peek();
			int y = queue.peek();

			while (!stack.isEmpty() && !queue.isEmpty() && x == y) {
				stack.pop();
				queue.poll();

				if (!stack.isEmpty() && !queue.isEmpty()) {
					x = stack.peek();
					y = queue.peek();
				}
			}
		}

		return stack.isEmpty() && queue.isEmpty();
	}
}
