package day01;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyRangeFailureTest {

	@Test
	@DisplayName("ขึ้นต้นด้วย [, ( เท่านั้น input = 1,5]")
	void case01() {
		try {
			MyRange range = new MyRange("1,5]");
			range.validate();
			fail("not detect input pattern");
		} catch (InputInvalidException e) {
			if (!"Input error".equals(e.getMessage())) {
				fail("error message ผิด " + e.getMessage());
			}
		}
	}

}
