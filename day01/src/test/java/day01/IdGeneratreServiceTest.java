package day01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IdGeneratreServiceTest {

	@Test
	void test() {
		IdGeneratreService service = new IdGeneratreService();
		String result = service.getData();
		assertEquals("CODE6", result);
	}

}
