package datastruct.component;

public class BNode {

	public String name;
	public int data;
	public BNode lNode, rNode, parentNode;
	public boolean visited = false;

	public BNode(String name) {
		this.name = name;
	}

	public BNode(String name, int data) {
		this.name = name;
		this.data = data;
	}
}
