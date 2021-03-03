package me.y2o2u2n.p155;

import java.util.Stack;

/**
 * Created by JunSeok Youn on 2021-03-03
 */
public class MinStack {

	public static void main(String[] args) {
		// MStack e1 = new MStack();
		// e1.push(-2);
		// e1.push(0);
		// e1.push(-3);
		// System.out.println(e1.getMin()); // return -3
		// e1.pop();
		// System.out.println(e1.top());    // return 0
		// System.out.println(e1.getMin()); // return -2

		MStack e2 = new MStack();
		e2.push(0);
		e2.push(1);
		e2.push(0);
		System.out.println(e2.getMin()); // return 0
		e2.pop();
		System.out.println(e2.getMin()); // return 0
	}

	static class MStack {
		Stack<Integer> stack1;
		Stack<Integer> stack2;

		MStack() {
			stack1 = new Stack<>();
			stack2 = new Stack<>();
		}

		void push(int x) {
			stack1.push(x);

			int latestMin = !stack2.isEmpty() ? stack2.peek() : Integer.MAX_VALUE;
			if (x <= latestMin) {
				stack2.push(x);
			}
		}

		void pop() {
			int pop = stack1.pop();
			int latestMin = stack2.peek();
			if (pop == latestMin) {
				stack2.pop();
			}
		}

		int top() {
			return stack1.peek();
		}

		int getMin() {
			return stack2.peek();
		}
	}
}
