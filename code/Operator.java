package me.bird;

public enum Operator {

	ADD("+") {
		@Override
		public int calculate(int a, int b) {
			return a + b;
		}
	},
	SUB("-") {
		@Override
		public int calculate(int a, int b) {
			return b - a;
		}
	},
	MUL("*") {
		@Override
		public int calculate(int a, int b) {
			return a * b;
		}
	},
	DIV("/") {
		@Override
		public int calculate(int a, int b) {
			return a / b;
		}
	};

	public abstract int calculate(int a, int b);

	private String symbol;

	private Operator(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return this.symbol;
	}
}
