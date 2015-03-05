package me.bird;

import java.util.function.IntBinaryOperator;

public enum LambdaOperator implements IntBinaryOperator {
	PLUS("+", (l, r) -> l + r), 
	MINUS("-", (l, r) -> r - l), 
	MULTIPLY("*", (l, r) -> l * r),
	DIVIDE("/", (l, r) -> r / l);

	private final String symbol;
	private final IntBinaryOperator binaryOperator;

	private LambdaOperator(final String symbol, final IntBinaryOperator binaryOperator) {
		this.symbol = symbol;
		this.binaryOperator = binaryOperator;
	}

	public String getSymbol() {
		return symbol;
	}

	@Override
	public int applyAsInt(int left, int right) {
		return binaryOperator.applyAsInt(left, right);
	}

}
