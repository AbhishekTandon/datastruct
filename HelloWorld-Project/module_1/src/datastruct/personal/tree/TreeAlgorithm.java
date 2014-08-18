package datastruct.personal.tree;

/**
 * Implementation for
 * Binary Search Tree (BST)
 */
public class TreeAlgorithm {

	public static void main (String[] args) {
		int[] arr = {7, 2, 3, 9, 4, 8, 10, 4, 5};
		TNode rootNode = new TNode("root");
		int i = 0;

		for (int tmp: arr) {
			String name = "Node"+i;
			System.out.println(String.format("Adding variable {%s} with name {%s}>>",tmp, name));
			addNode(new TNode(name, tmp), rootNode);
			i++;
		}

		int depth = 0;
		printDepth(rootNode, depth);

	}

	public static void addNode(TNode node, TNode parentNode) {
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
	public static void printDepth(TNode node, int depth) {
		if (!node.visited) {
			node.visited = true;
			System.out.println(String.format("Node >> name {%s} data {%s} depth {%S}", node.name, node.data, depth));
		}

		if (node.lNode != null && !node.lNode.visited) {
			printDepth(node.lNode, ++depth);
		}

		if (node.rNode != null && !node.rNode.visited) {
			printDepth(node.rNode, ++depth);
		}

		if (node.parentNode != null) printDepth(node.parentNode, --depth);
	}
}
