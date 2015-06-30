package com.tandon.datastruct.personal.graph;

import com.tandon.datastruct.component.Graph;
import com.tandon.datastruct.component.Node;

public class DepthFirstSearch {
	public static void main(String[] args) {

		//Lets create nodes as given as an example in the article
		Node nA = new Node("A");
		Node nB = new Node("B");
		Node nC = new Node("C");
		Node nD = new Node("D");
		Node nE = new Node("E");
		Node nF = new Node("F");

		//Create the graph, add nodes, create edges between nodes
		Graph g = new Graph();
		g.addNode(nA);
		g.addNode(nB);
		g.addNode(nC);
		g.addNode(nD);
		g.addNode(nE);
		g.addNode(nF);
		g.setRootNode(nA);

		g.connectNode(nA, nB);
		g.connectNode(nA, nC);
		g.connectNode(nA, nD);

		g.connectNode(nB, nE);
		g.connectNode(nB, nF);
		g.connectNode(nC, nF);


		Node rootNode = g.getRootNode();
		dfs(g, rootNode);


	}



	// using recursion
	public static void dfs(Graph g, Node node) {
		node.visited = true;
		System.out.println("visiting node >>" + node.label);

		Node childNode;
		while((childNode = g.getUnvisitedChildNode(node)) != null) {
			if (childNode != null) dfs(g, childNode);
		}
	}
}