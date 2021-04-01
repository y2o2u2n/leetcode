package me.y2o2u2n.p208;

/**
 * Created by JunSeok Youn on 2021-04-01
 */
public class Trie {
	private Node root;

	private Trie() {
		root = new Node();
	}

	private void insert(String word) {
		Node current = root;

		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (current.next[index] == null) {
				current.next[index] = new Node();
			}

			current = current.next[index];
		}

		current.hit = true;
	}

	private boolean search(String word) {
		Node current = root;

		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (current.next[index] == null) {
				return false;
			}

			current = current.next[index];
		}

		return current.hit;
	}

	private boolean startsWith(String prefix) {
		Node current = root;

		for (int i = 0; i < prefix.length(); i++) {
			int index = prefix.charAt(i) - 'a';
			if (current.next[index] == null) {
				return false;
			}

			current = current.next[index];
		}

		return true;

	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple")); // return True
		System.out.println(trie.search("app")); // return False
		System.out.println(trie.startsWith("app")); // return True
		trie.insert("app");
		System.out.println(trie.search("app")); // return True

		// Trie trie = new Trie();
		// System.out.println(trie.search("a")); // return false
	}

	private class Node {
		Node[] next;
		boolean hit;

		Node() {
			next = new Node[26];
		}
	}
}
