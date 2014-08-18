package datastruct.personal.tree;

public class TNode {

	public String name;
	public int data;
	public TNode lNode, rNode, parentNode;
	boolean visited = false;

	public TNode(String name) {
		this.name = name;
	}

	public TNode(String name, int data) {
		this.name = name;
		this.data = data;
	}
}
