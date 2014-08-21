package datastruct.component;

public class Edge {
	public Node sourcevertex;
	public Node destinationvertex;
	public int weight;

	public String toString() {
		return String.format("sourceVertex (%s) destinationvertex (%s) weight(%s)", sourcevertex, destinationvertex, weight);
	}
}