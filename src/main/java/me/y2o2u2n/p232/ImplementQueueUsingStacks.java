package me.y2o2u2n.p232;

import java.util.Stack;

/**
 * Created by JunSeok Youn on 2021-04-14
 */
public class ImplementQueueUsingStacks {
	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		myQueue.push(1); // queue is: [1]
		myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		System.out.println(myQueue.peek()); // return 1
		System.out.println(myQueue.pop()); // return 1, queue is [2]
		System.out.println(myQueue.empty()); // return false
	}

	private static class MyQueue {
		private Stack<Integer> left;
		private Stack<Integer> right;

		/** Initialize your data structure here. */
		MyQueue() {
			this.left = new Stack<>();
			this.right = new Stack<>();
		}

		/** Push element x to the back of queue. */
		void push(int x) {
			if (this.left.isEmpty()) {
				while (!this.right.isEmpty()) {
					int pop = this.right.pop();
					this.left.push(pop);
				}
			}

			this.right.push(x);
		}

		/** Removes the element from in front of queue and returns that element. */
		int pop() {
			if (this.left.isEmpty()) {
				while (!this.right.isEmpty()) {
					int pop = this.right.pop();
					this.left.push(pop);
				}
			}

			return this.left.pop();
		}

		/** Get the front element. */
		int peek() {
			if (this.left.isEmpty()) {
				while (!this.right.isEmpty()) {
					int pop = this.right.pop();
					this.left.push(pop);
				}
			}

			return this.left.peek();
		}

		/** Returns whether the queue is empty. */
		boolean empty() {
			return this.left.isEmpty() && this.right.isEmpty();
		}
	}

}
