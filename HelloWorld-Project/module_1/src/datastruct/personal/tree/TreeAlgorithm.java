package datastruct.personal.tree;

import datastruct.component.BNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** TODO: Implement removing node from BST
 *  http://www.algolist.net/Data_structures/Binary_search_tree/Removal
 */

/**
 * Binary Search Tree (BST)
 *
 * Logic for adding child
 * - Larger element are added to right child
 * - Smaller elements are added to left child
 */


/**
 * compute the max sum if the Tree path from root to leaf
 * find the min depth and max depth
 */
public class TreeAlgorithm {

	static Map<Integer, Integer> vertical_sum_map = new HashMap();
	Integer maxDepth = new Integer(0);
	static Integer diameter =0;
	static int parent = 0;

	public static void main(String[] args) {
		int[] arr = {7, 2, 3, 9, 4, 8, 10, 5, -13, -1, 6, -14, -15, -16, 50};
		BNode rootNode = new BNode("root");
		int i = 0;

		for (int tmp : arr) {
			String name = "Node" + i;
			System.out.println(String.format("Adding variable {%s} with name {%s}>>", tmp, name));
			addNode(new BNode(name, tmp), rootNode);
			i++;
		}

		int count = 0;
		printDepth(rootNode, count);

		int depth = -1;
		TreeAlgorithm algo = new TreeAlgorithm();
		algo.maxDepth(rootNode, depth);

		System.out.println(String.format("max depth of the tree %s", algo.maxDepth));
		print_node_for_a_depth(rootNode, 2, 0, true);

		int height = height(rootNode);
		System.out.println("Height of the root node >> " + height);

		boolean isBST = isBST(rootNode, Integer.MAX_VALUE, Integer.MIN_VALUE);
		System.out.println(String.format("tree is BST (%s)", isBST));

		System.out.println(String.format("Running in-order traversal of tree"));
		List<Integer> numbers = new ArrayList();
		in_order_traversal(rootNode, numbers);
		StringBuilder buffer = new StringBuilder();
		for (Integer element : numbers) buffer.append(element).append(" ");
		System.out.println("Printing in-order list >> " + buffer.toString());

		System.out.println("Height of the root-node >> " + height(rootNode));

		System.out.println("zig zag traversal  ...");
		zig_zag_traversal(rootNode);

		BNode lca = find_lca(rootNode, -1, 4);
		System.out.println("lca node is >> " + lca.data);

		find_max_height(rootNode);
		System.out.println("diameter of tree >> " + diameter + " parent >> " + parent);

		BNode root = BNode.create("root", 20);
		root.lNode = BNode.create("Node 1", 8);
		root.rNode = BNode.create("Node 2", 22);
		root.lNode.lNode = BNode.create("Node 3", 4);
		root.lNode.rNode = BNode.create("Node 4", 12);
		root.lNode.rNode.lNode = BNode.create("Node 5", 10);
		root.lNode.rNode.rNode = BNode.create("Node 6", 14);

		vertical_sum(root, 0);
		for(int key: vertical_sum_map.keySet()) {
			System.out.println(String.format("the vertical sum of the key %s is value %s", key, vertical_sum_map.get(key)));
		}

		System.out.println("height of root node >> " + find_root_height(root, 0));

	}


	public static int find_root_height(BNode node, int height) {
		if (node == null) return height;

		int lHeight = find_root_height(node.lNode, height++);
		int rHeight = find_root_height(node.rNode, height++);
		return Math.max(lHeight, rHeight);
	}


	public static boolean isBST(BNode node, int maxData, int minData) {
		if (node == null) return true;

		if (node.data >= maxData || node.data <= minData) return false;

		return (isBST(node.lNode, node.data, minData) && isBST(node.rNode, maxData, node.data));
	}

	public static void addNode(BNode node, BNode parentNode) {
		if (parentNode.data == 0) {
			parentNode.data = node.data;
			parentNode.name = parentNode.name + " : " + node.name;
			System.out.println(String.format("adding to the root node {%s} value {%s} ", parentNode.name, parentNode.data));
			return;
		}

		if (node.data > parentNode.data) {
			if (parentNode.rNode == null) {
				parentNode.rNode = node;
				node.parentNode = parentNode;
				System.out.println(String.format("adding to right child node {%s} value {%s}. parent node {%s}", node.name, node.data, parentNode.name));
			} else {
				addNode(node, parentNode.rNode);
			}
		} else {
			if (parentNode.lNode == null) {
				parentNode.lNode = node;
				node.parentNode = parentNode;
				System.out.println(String.format("adding to left child node {%s} value {%s}. parent node {%s}", node.name, node.data, parentNode.name));
			} else {
				addNode(node, parentNode.lNode);
			}
		}
	}

	/**
	 * print all node and there depth from the root node
	 */
	public static void printDepth(BNode node, int depth) {
		if (!node.visited) {
			node.visited = true;
			System.out.println(String.format("Node >> name {%s} data {%s} depth {%s}", node.name, node.data, depth));
		}

		if (node.lNode != null && !node.lNode.visited) {
			printDepth(node.lNode, ++depth);
		}

		if (node.rNode != null && !node.rNode.visited) {
			printDepth(node.rNode, ++depth);
		}

		if (node.parentNode != null) printDepth(node.parentNode, --depth);
	}

	// initialize depth = -1
	public void maxDepth(BNode node, int depth) {
		++depth;
		if (depth > maxDepth) maxDepth = depth;
		if (node.lNode != null) maxDepth(node.lNode, depth);
		if (node.rNode != null) maxDepth(node.rNode, depth);
	}


	public static void print_node_for_a_depth(BNode node, int depth_of_node, int depth, boolean ltr) {
		if (depth == depth_of_node) {
			System.out.println(String.format("Node for depth (%s) --> name {%s} data {%s} ", depth, node.name, node.data));

		} else {
			if (ltr) {
				if (node.lNode != null) print_node_for_a_depth(node.lNode, depth_of_node, depth + 1, ltr);
				if (node.rNode != null) print_node_for_a_depth(node.rNode, depth_of_node, depth + 1, ltr);
			} else {
				if (node.rNode != null) print_node_for_a_depth(node.rNode, depth_of_node, depth + 1, ltr);
				if (node.lNode != null) print_node_for_a_depth(node.lNode, depth_of_node, depth + 1, ltr);
			}

		}
	}

	//	http://en.wikipedia.org/wiki/Tree_traversal
	public static void in_order_traversal(BNode node, List<Integer> numbers) {
		if (node.lNode != null) {
			in_order_traversal(node.lNode, numbers);
		}

		numbers.add(node.data);

		if (node.rNode != null) {
			in_order_traversal(node.rNode, numbers);
		}
	}

	public static int height(BNode node) {
		int rHeight = 0;
		int lHeight = 0;
		if (node.lNode != null) lHeight = 1 + height(node.lNode);
		if (node.rNode != null) rHeight = 1 + height(node.rNode);

		return Math.max(rHeight, lHeight);
	}

	public static void zig_zag_traversal(BNode rootNode) {
		int h = height(rootNode);

		for (int i = 0; i <= h; i++) {
			boolean ltr = (i % 2 == 0) ? true : false;
			print_node_for_a_depth(rootNode, i, 0, ltr);
		}

	}

	public static int find_max_height(BNode node) {
		if(node== null) return 0;
		int lHeight = 0;
		int rHeight = 0;

		if (node.lNode != null) lHeight = 1 + find_max_height(node.lNode);
		if (node.rNode != null) rHeight = 1 + find_max_height(node.rNode);

		if (lHeight + rHeight > diameter) {
			diameter = lHeight + rHeight;
			parent = node.data;
		}

		return Math.max(lHeight, rHeight);
	}

	public static BNode find_lca(BNode node, int  a, int b) {
		if (node.data > a && node.data > b && node.lNode !=null) {
			return  find_lca(node.lNode, a , b);
		}

		if (node.data < a && node.data < b && node.rNode != null) {
			return find_lca(node.lNode, a , b);
		}

		return node;
	}

	public static void vertical_sum (BNode node, int position) {
		if (vertical_sum_map.containsKey(position)) vertical_sum_map.put(position, (vertical_sum_map.get(position) + node.data));
		else vertical_sum_map.put(position, node.data);


		if (node.lNode != null) vertical_sum(node.lNode, position - 1);
		if (node.rNode != null) vertical_sum(node.rNode, position + 1);
	}
}
