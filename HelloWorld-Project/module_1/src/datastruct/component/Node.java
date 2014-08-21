package datastruct.component;


public class Node {
	public String label;
	public boolean visited = false;
	public Node parent = this;

	public Node(String l) {
		this.label = l;
	}

	public String toString() {
		return label;
	}

	public  static Node findParent(Node node) {
		if (node.parent == node) {return node;}
		else {
			Node parentNode = node.parent;
			return findParent(parentNode);
		}
	}

}