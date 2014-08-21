package datastruct.personal.tree;

import datastruct.component.BNode;

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

	Integer maxDepth = new Integer(0);

	public static void main (String[] args) {
		int[] arr = {7, 2, 3, 9, 4, 8, 10, 4, 5};
		BNode rootNode = new BNode("root");
		int i = 0;

		for (int tmp: arr) {
			String name = "Node"+i;
			System.out.println(String.format("Adding variable {%s} with name {%s}>>",tmp, name));
			addNode(new BNode(name, tmp), rootNode);
			i++;
		}

		int count = 0;
		printDepth(rootNode, count);

		int depth = -1;
		TreeAlgorithm algo = new TreeAlgorithm();
		algo.maxDepth(rootNode, depth);

		System.out.println(String.format("max depth of the tree %s", algo.maxDepth));

		print_node_for_a_depth(rootNode, 2, 0);

	}

	public static void addNode(BNode node, BNode parentNode) {
		if (parentNode.data == 0) {
			parentNode.data = node.data;
			parentNode.name = parentNode.name + " : " +  node.name;
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

	public  void maxDepth(BNode node, int depth) {
		++depth;
		if (depth > maxDepth) maxDepth = depth;
		if (node.lNode != null) maxDepth(node.lNode, depth);
		if (node.rNode != null) maxDepth(node.rNode, depth);
	}


	public static void print_node_for_a_depth(BNode node, int depth_of_node, int depth) {
		if (depth == depth_of_node) {
			System.out.println(String.format("Node for depth (%s) --> name {%s} data {%s} ", depth, node.name, node.data));
		} else  {
			 if (node.lNode != null) {
				 int new_depth =  depth + 1;
				 print_node_for_a_depth(node.lNode, depth_of_node, new_depth);
			 }

			if (node.rNode != null) {
				int new_depth =  depth + 1;
				print_node_for_a_depth(node.rNode, depth_of_node, new_depth);
			}
		}



	}

	public static void printAllPathToLeaf(BNode node) {

	}

}
