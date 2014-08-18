package datastruct.graph.mst;

public class Edge {
	public int sourcevertex;
	public int destinationvertex;
	public int weight;

	public String toString() {
		return String.format("sourceVertex (%s) destinationvertex (%s) weight(%s)", sourcevertex, destinationvertex, weight);
	}
}