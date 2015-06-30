package com.tandon.datastruct.personal.permutation;

import java.util.ArrayList;
import java.util.List;

class Expression {
	static char lPar = '(';
	static char rPar = ')';
}

class Node {
	boolean bra;
	boolean ket;
	Node parentNode = this;
	Node childNode = null;
	List<Character> leftExpression = new ArrayList<>();
	List<Character> rightExpression = new ArrayList<>();

	public void addParent(Node node) {
		this.parentNode = node;
	}

	public void addChild(Node node) {
		this.childNode = node;
	}

	public void addBra() {
		if (!bra) bra = true;
	}

	public void addKet() {
		if (!ket) ket = true;

	}

	public void addLeftExpression(char exp) {
		leftExpression.add(exp);
	}

	public void addRightExpression(char exp) {
		rightExpression.add(exp);
	}
}

public class Parentheses {
	public static void main(String[] args) {

		String parentheses = "()()()(()) ((()))";
		char[] chars = parentheses.toCharArray();

		int num = processParentheses(chars);

		if (num == 0) System.out.println(String.format("correct format (%s)", (num == 0)));
		else System.out.println(String.format("in-correct format "));


		char[] expression = "+ ((2 + 3) + )".toCharArray();
		Node rootNode = new Node();
		Node respNode = rootNode;
		for (int i = 0; i < expression.length; i++) {
			respNode = processExpression(expression[i], respNode);
		}

		StringBuilder buffer = new StringBuilder();
		Node n = rootNode;
		printNode(n, buffer);
		System.out.println("output >>" + buffer.toString());

		System.out.println(String.format("expression {%s} is validate=%s", new String(expression), validateExpression(rootNode)));

	}

	static public void printNode(Node n, StringBuilder buffer) {
		if (n.bra && n.ket) buffer.append("(");

		if (n.leftExpression.size() > 0) {
			for (int i = 0; i < n.leftExpression.size(); i++) buffer.append(n.leftExpression.get(i));
		}

		if (n.childNode != null) printNode(n.childNode, buffer);

		if (n.rightExpression.size() > 0) {
			for (int i = 0; i < n.rightExpression.size(); i++) buffer.append(n.rightExpression.get(i));
		}

		if (n.ket) buffer.append(")");
	}


	static public int processParentheses(char[] chars) {
		int num = 0;
		for (int i = 0; i < chars.length; i++) {
			if (num < 0) break;
			else {
				if (chars[i] == Expression.lPar) {
					num = num + 1;
				} else if (chars[i] == Expression.rPar) {
					num = num - 1;
				}
			}
		}

		return num;
	}

	public static boolean validateExpression(Node node) {
		if ((node.bra && !node.ket) || ((!node.bra && node.ket))) return  false;
		if (node.childNode != null) return validateExpression(node.childNode);

		return true;
	}

	/**
	 * Expects parentheses as the first expression
	 * TODO: to create tree for string -- () + ((2 + 3))
	 */
	public static Node processExpression(char c, Node n) {
		Node node = new Node();
		node.addParent(n);

		if (c == Expression.lPar) {
			node.addBra();
			n.addChild(node);
			return n.childNode;
		} else if (c == Expression.rPar) {
			n.addKet();
			return n.parentNode;
		} else if (c == ' ') {
			// Do Nothing
			return n;
		} else {
			if (n.childNode == null) n.addLeftExpression(c);
			else if (n.childNode != null) n.addRightExpression(c);
			return n;
		}
	}
}
