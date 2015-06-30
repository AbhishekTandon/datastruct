package com.tandon.datastruct.component;

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

	public static BNode create(String name, int data) {
		return new BNode(name, data);
	}

}
