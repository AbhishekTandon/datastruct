package datastruct.graph.mst;

import datastruct.graph.Graph;
import datastruct.graph.Node;

import java.util.*;

/**
 * refer implementation in
 * http://www.sanfoundry.com/java-program-find-mst-using-kruskals-algorithm/
 */
public class KruskalAlgorithm_Personal {

	public List<Edge> edges = new ArrayList<Edge>();
	public List<Edge> mst = new ArrayList<Edge>();
	Map<String, List<Edge>> connected_components = new HashMap();
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

			String key1 = null;
			String key2 = null;
			for (String key : connected_components.keySet()) {
				List<Edge> connected_component = connected_components.get(key);
				NodeConnection nodeConnection = does_connected_components_contain_edge(connected_component, e);
				if (nodeConnection.isDestNodeConnected == nodeConnection.isSrcNodeConnected && nodeConnection.isDestNodeConnected) {
					// Adding this node into the connected_component list will cause creation of the cycle
					key1 = key;
					key2 = key;
				} else if (nodeConnection.isDestNodeConnected == true || nodeConnection.isSrcNodeConnected == true) {
					if (key1 == null) key1 = key;
					else if (key2 == null) key2 = key;
				}
			}

			if (key1 != null && key2 != null && !key1.equals(key2)) {
				List<Edge> cc1 = connected_components.remove(key1);
				List<Edge> cc2 = connected_components.remove(key2);
				cc1.addAll(cc2);
				connected_components.put(key1 + key2, cc1);
				mst.add(e);
			} else if (key1 != null && key2 == null) {
				connected_components.get(key1).add(e);
				mst.add(e);
			} else if (key1 == null && key2 != null) {
				connected_components.get(key2).add(e);
				mst.add(e);
			} else if (key1 == null && key2 == null){
				List<Edge> connected_component = new ArrayList();
				connected_component.add(e);
				connected_components.put(key++ + "", connected_component);
				mst.add(e);
			}
		}

		for (Edge e: mst) {
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
		 *graph copied from:
		 * http://en.wikipedia.org/wiki/Kruskal%27s_algorithm
		 */

		Node nA = new Node('A');
		Node nB = new Node('B');
		Node nC = new Node('C');
		Node nD = new Node('D');
		Node nE = new Node('E');
		Node nF = new Node('F');
		Node nG = new Node('G');

		Graph g = new Graph();
		g.addNode(nA);
		g.addNode(nB);
		g.addNode(nC);
		g.addNode(nD);
		g.addNode(nE);
		g.addNode(nF);
		g.addNode(nG);
		g.setRootNode(nA);

		g.connectNodeWithWeight(nA, nB, 7, 7); // A-B
		g.connectNodeWithWeight(nB, nC, 8, 8); // B-C
		g.connectNodeWithWeight(nA, nD, 5, 5); // A-D
		g.connectNodeWithWeight(nD, nB, 9, 9); // D-B
		g.connectNodeWithWeight(nB, nE, 7, 7);    // B-E
		g.connectNodeWithWeight(nC, nE, 5, 5); // C-E
		g.connectNodeWithWeight(nD, nE, 15, 15); // D-E
		g.connectNodeWithWeight(nD, nF, 6, 6); // D-F
		g.connectNodeWithWeight(nF, nE, 8, 8); // F-E
		g.connectNodeWithWeight(nG, nE, 9, 9); // G-E
		g.connectNodeWithWeight(nF, nG, 11, 11); // F-G

		/**
		 * set non-filled edges to MAX-VALUE
		 */
		int number_of_vertices = g.nodes.size();
		for (int i = 0; i < number_of_vertices; i++) {
			for (int j = 0; j < number_of_vertices; j++) {
				if (i == j) {
					g.adjMatrix[i][j] = 0;
					continue;
				}
				if (g.adjMatrix[i][j] == 0) {
					g.adjMatrix[i][j] = MAX_VALUE;
				}
			}
		}

		KruskalAlgorithm_Personal algo = new KruskalAlgorithm_Personal();
		algo.kruskalAlgorithm(g);


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