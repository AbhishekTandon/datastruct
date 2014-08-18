package datastruct.personal.graph;


import java.util.*;

/**
 * refer implementation in
 * http://www.sanfoundry.com/java-program-find-mst-using-kruskals-algorithm/
 * <p/>
 * TODO: optimise the datastructure using union-tree approach
 */
public class KruskalAlgorithm {

	public List<Edge> edges = new ArrayList<Edge>();
	public List<Edge> mst = new ArrayList<Edge>();
	public static Graph graph = new Graph();
	public static final int MAX_VALUE = 999;
	int key = 0;

	private class NodeConnection {
		public boolean isSrcNodeConnected = false;
		public boolean isDestNodeConnected = false;
	}


	public void kruskalAlgorithm(Graph g) {
		create_and_sort_edges(g);

		for (Edge e : edges) {
			System.out.println("processing edge >>" + e.toString());






		}

		for (Edge e : mst) {
			System.out.println(String.format("edge in mst >> %s", e));
		}

	}

	public NodeConnection does_connected_components_contain_edge(List<Edge> connected_component, Edge edge) {
		NodeConnection nodeConnection = new NodeConnection();

		for (Edge cc : connected_component) {
			if (cc.sourcevertex == edge.sourcevertex || cc.destinationvertex == edge.sourcevertex)
				nodeConnection.isSrcNodeConnected = true;
			if (cc.sourcevertex == edge.destinationvertex || cc.destinationvertex == edge.destinationvertex)
				nodeConnection.isDestNodeConnected = true;
		}

		return nodeConnection;
	}

	public static void main(String... arg) {
		/**
		 *graph copied from: http://en.wikipedia.org/wiki/Kruskal%27s_algorithm
		 */
		Node nA = new Node("A");
		Node nB = new Node("B");
		Node nC = new Node("C");
		Node nD = new Node("D");
		Node nE = new Node("E");
		Node nF = new Node("F");
		Node nG = new Node("G");

		graph.addNode(nA);
		graph.addNode(nB);
		graph.addNode(nC);
		graph.addNode(nD);
		graph.addNode(nE);
		graph.addNode(nF);
		graph.addNode(nG);
		graph.setRootNode(nA);

		/**
		 * set default value to the adjacent matric
		 */
		int number_of_vertices = graph.nodes.size();
		for (int i = 0; i < number_of_vertices; i++) {
			for (int j = 0; j < number_of_vertices; j++) {
				graph.adjMatrix[i][j] = MAX_VALUE;
			}
		}

		graph.connectNodeWithWeight(nA, nB, 7, 7); // A-B
		graph.connectNodeWithWeight(nB, nC, 8, 8); // B-C
		graph.connectNodeWithWeight(nA, nD, 5, 5); // A-D
		graph.connectNodeWithWeight(nD, nB, 9, 9); // D-B
		graph.connectNodeWithWeight(nB, nE, 7, 7);    // B-E
		graph.connectNodeWithWeight(nC, nE, 5, 5); // C-E
		graph.connectNodeWithWeight(nD, nE, 15, 15); // D-E
		graph.connectNodeWithWeight(nD, nF, 6, 6); // D-F
		graph.connectNodeWithWeight(nF, nE, 8, 8); // F-E
		graph.connectNodeWithWeight(nG, nE, 9, 9); // G-E
		graph.connectNodeWithWeight(nF, nG, 11, 11); // F-G

		KruskalAlgorithm algo = new KruskalAlgorithm();
		algo.kruskalAlgorithm(graph);
	}

	/**
	 * create and sort Edges
	 */
	public void create_and_sort_edges(Graph g) {
		int number_of_vertices = g.nodes.size();
		for (int source = 0; source < number_of_vertices; source++) {
			for (int destination = 0; destination < source; destination++) {
				if (g.adjMatrix[source][destination] != MAX_VALUE && source != destination) {
					Edge edge = new Edge();
					edge.sourcevertex = source;
					edge.destinationvertex = destination;
					edge.weight = g.adjMatrix[source][destination];
					edges.add(edge);
				}
			}
		}

		Collections.sort(edges, new EdgeComparator());
	}
}