package me.y2o2u2n.p138;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2021-03-29
 */
public class CopyListWithRandomPointer {
	public static void main(String[] args) {
		Node n0 = new Node(7);
		Node n1 = new Node(13);
		Node n2 = new Node(11);
		Node n3 = new Node(10);
		Node n4 = new Node(1);

		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		n0.random = null;
		n1.random = n0;
		n2.random = n4;
		n3.random = n2;
		n4.random = n0;

		copyRandomList(n0);
	}

	private static Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}

		Map<Node, Integer> before = new HashMap<>();
		Map<Integer, Node> after = new HashMap<>();

		int i = 0;
		Node current = head;
		while (current != null) {
			before.put(current, i);
			i++;
			current = current.next;
		}

		int length = i;
		Node retHead = new Node(-1);
		Node retCurrent = retHead;
		for (int j = 0; j < length; j++) {
			Node n = new Node(-1);
			after.put(j, n);
			retCurrent.next = n;
			retCurrent = retCurrent.next;
		}

		int index = 0;
		current = head;
		while (current != null) {
			Node afterNode = after.get(index);
			afterNode.val = current.val;

			if (current.random != null) {
				int randomIndex = before.get(current.random);
				Node afterRandomNode = after.get(randomIndex);
				afterNode.random = afterRandomNode;
			}

			index++;
			current = current.next;
		}

		return retHead.next;

	}

	private static class NodeInfo {
		int val;
		int nextIndex;
		int randomIndex;
	}

	private static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
}
