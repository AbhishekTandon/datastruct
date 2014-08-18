package datastruct.personal.graph;

public class Node {
	String label;
	Node parent = this;

	public Node(String label) {
		this.label = label;
	}
}
