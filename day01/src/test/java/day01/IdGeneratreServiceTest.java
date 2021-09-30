package day01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class IdGeneratreServiceTest {

	@Test
	void test() {
		Random stub = new Random6();
		IdGeneratreService service = new IdGeneratreService();
		service.setRandom(stub);
		String result = service.getData();
		assertEquals("CODE6", result);
	}

}

class Random6 extends Random {

	@Override
	public int nextInt(int bound) {
		return 6;
	}

}
