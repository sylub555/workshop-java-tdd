package day01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelloTest {

	@Test
	@DisplayName("เรากำลังทดสอบด้วย junit 5")
	void test() {
		// Arrrage = Given
		Hello hello = new Hello();
		// Act = When
		String result = hello.say("anuchit");
		// Assert = Then
		assertEquals("Hello anuchit", result);
	}

}
