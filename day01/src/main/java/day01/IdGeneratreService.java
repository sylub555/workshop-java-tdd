package day01;

import java.util.Random;

public class IdGeneratreService {

	public String getData() {
		// Dependency
		Random random = new Random();
		int id = random.nextInt(10);
		// Result
		return "CODE" + id;
	}
}
