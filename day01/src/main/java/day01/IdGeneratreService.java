package day01;

public class IdGeneratreService {

	private MyRandom random;

	public void setRandom(MyRandom random) {
		this.random = random;
	}

	public String getData() {
		// Dependency
		int id = random.nextInt(10);
		// Result
		return "CODE" + id;
	}
}
