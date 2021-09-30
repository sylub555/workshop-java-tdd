package day01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IdGeneratreServiceTest {

	@Test
	void test_getData() {
		Random6 stub = new Random6();
		IdGeneratreService service = new IdGeneratreService();
		service.setRandom(stub);
		String result = service.getData();
		assertEquals("CODE6", result);
	}

	@Test
	void test_getData2() {
		SpyRandom spy = new SpyRandom();
		IdGeneratreService service = new IdGeneratreService();
		service.setRandom(spy);
		service.getData();
		spy.verify(1);
	}

}

class Random6 implements MyRandom {

	@Override
	public int nextInt(int bound) {
		return 6;
	}

}

class SpyRandom implements MyRandom {

	private int count = 0;

	@Override
	public int nextInt(int bound) {
		count++;
		return 6;
	}

	public void verify(int expected) {
		assertEquals(expected, count);
	}

}
