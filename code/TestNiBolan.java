package me.bird;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestNiBolan {

	public static void main(String[] args) {
		System.out.println(new Normal().getValue("1,2,5,3,-,*,+"));
		System.out.println(new Fansy().getValue("1,2,5,3,-,*,+"));
	}

}

class Normal {

	private Stack<Integer> stacks = new Stack<>();

	public int getValue(String input) {

		String[] cells = input.split(",");
		for (String cell : cells) {
			boolean isNumber = true;
			for (Operator operator : Operator.values()) {
				if (operator.getSymbol().equals(cell)) {
					isNumber = false;
					stacks.push(operator.calculate(stacks.pop(), stacks.pop()));
				}
			}
			if (isNumber) {
				stacks.push(Integer.valueOf(cell));
			}
		}
		return stacks.pop();
	}

}

class Fansy {

	private Stack<Integer> stacks = new Stack<>();

	public int getValue(String input) {
		List<LambdaOperator> ops = Stream.of(LambdaOperator.values()).collect(Collectors.toList());
		Arrays.stream(input.split(","))
			.filter(s -> ops.stream().noneMatch(op -> {
				boolean b = op.getSymbol().equals(s);
				if (b) stacks.push(op.applyAsInt(stacks.pop(), stacks.pop()));
				return b;
			})).forEach(s -> stacks.push(Integer.valueOf(s)));
		return stacks.pop();
	}

}
