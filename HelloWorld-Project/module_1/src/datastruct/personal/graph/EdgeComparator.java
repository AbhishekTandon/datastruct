package datastruct.personal.graph;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge> {

	@Override
	public int compare(Edge edge1, Edge edge2)	{
		if (edge1.weight < edge2.weight) return -1;
		if (edge1.weight > edge2.weight) return 1;
		return 0;
	}
}
