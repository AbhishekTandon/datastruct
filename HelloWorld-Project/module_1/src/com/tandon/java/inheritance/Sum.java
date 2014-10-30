package com.tandon.java.inheritance;

public class Sum implements Expression<Double> {
	Expression<Double> expression1;
	Expression<Double> expression2;

	public Sum(Expression expr1, Expression expr2) {
		expression1 = expr1;
		expression2 = expr2;
	}

	public Double getValue() {
		return expression1.getValue() + expression2.getValue();
	}

	public static void main(String[] args) {
		Number n1 = new Number(1.0);
		Number n2 = new Number(1.0);
		Number n3 = new Number(4.0);

		Expression expr = new Sum(new Sum(n1, n2), n3);
		System.out.println("Printing the value of the expression >> " + expr.getValue());
	}
}


