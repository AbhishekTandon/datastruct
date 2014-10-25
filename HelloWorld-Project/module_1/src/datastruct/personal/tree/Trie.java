package datastruct.personal.tree;

import com.tandon.java.FileReader;

import java.util.*;

class Node {
	char key;
	boolean flag = false;
	Map<Character, Node> subtree = new HashMap();
}

public class Trie {
	public void add_string(Node node, String str) {
		char key = str.charAt(0);
		int length = str.length();

		if (length > 1) {

			// This follow is repeated in else block
			Node child;
			if (node.subtree.containsKey(key)) {
				child = node.subtree.get(key);
			} else {
				child = new Node();
				child.key = key; // No need to do this
				node.subtree.put(key, child);
			}

			str = str.substring(1); // substring starting at 1
			add_string(child, str);
		} else {

			Node child;
			if (node.subtree.containsKey(key)) {
				child = node.subtree.get(key);
			} else {
				child = new Node();
				child.key = key; // No need to do this
				node.subtree.put(key, child);
			}

			child.flag = true;
		}

	}

	public void search(Node node, String str, String tillNow) {
		char key = str.charAt(0);
		int length = str.length();

		if (node.subtree.containsKey(key)) {
			tillNow = tillNow + key;
			if (length == 1) {
				if (node.flag) System.out.println("Matching complete string >>" + tillNow);
				else {
					// run the depth search for the tree from here onwards
					System.out.println("Running DFS on the tree>>" + tillNow);
					Node child = node.subtree.get(key);
					for(Character c: child.subtree.keySet()) {
						Node branch = child.subtree.get(c);
						dfs(branch, (tillNow+c));
					}

				}
			} else {
				Node child = node.subtree.get(key);
				str = str.substring(1);
				search(child, str, tillNow);
			}
		} else {
			System.out.println("No Match found for >> " + (tillNow + str));

		}
	}

	public void dfs(Node node, String tillNow) {
		if (node.flag) {
			System.out.println("DFS match >> " + tillNow);
		}

		for(Character c: node.subtree.keySet()) {
			Node branch = node.subtree.get(c);
			dfs(branch, (tillNow+c));
		}

	}

	public static void main(String[] args) {
		String filePath = "/home/berkha/Desktop/dictionary.txt";
		FileReader reader = new FileReader();
		List<String> lines = reader.read(filePath);
		Node rootNode = new Node();
		Trie algo = new Trie();

		for (String input: lines) {
			algo.add_string(rootNode, input);
		}

		algo.search(rootNode, "a", "");
	}
}
