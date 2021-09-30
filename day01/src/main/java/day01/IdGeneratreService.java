package day01;

import java.util.Random;

public class IdGeneratreService {

	private Random random;

	public void setRandom(Random random) {
		this.random = random;
	}

	public String getData() {
		// Dependency
		int id = random.nextInt(10);
		// Result
		return "CODE" + id;
	}
}
