package day01;

public class MyRange {

	private String input;

	public MyRange(String input) {
		this.input = input;
	}

	public boolean startWithInclude() {
		return input.charAt(0) == '[';
	}

}
