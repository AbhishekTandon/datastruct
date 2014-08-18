package datastruct.graph;


public class Edge {

	Node sourceNode;
	Node destinationNode;
	int weight;

	Edge(int weight) {
		this.weight = weight;
	}

	public void setSourceNode (Node node) {
		this.sourceNode = node;
	}

	public void setDestinationNode(Node node) {
		this.destinationNode = node;
	}
}
