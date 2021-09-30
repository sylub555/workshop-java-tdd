package day01;

public class MyRange {

	private String input;

	public MyRange(String input) {
		this.input = input;
	}

	public boolean startWithInclude() {
		return input.charAt(0) == '[';
	}

	public int getStart() {
		final int result = Integer.parseInt(input.substring(1, 2));
		return startWithInclude() ? result : result + 1;
	}

	public boolean endWithInclude() {
		return input.charAt(input.length() - 1) == ']';
	}

	public int getEnd() {
		final int result = Integer.parseInt(input.substring(3, 4));
		return endWithInclude() ? result : result - 1;
	}

}