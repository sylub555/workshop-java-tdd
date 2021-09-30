package day01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
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

	@Test
	@DisplayName("ขึ้นต้นด้วย [, ( เท่านั้น input = 1,5] with junit 5")
	void case02() {
		MyRange range = new MyRange("1,5]");
		Exception e = assertThrowsExactly(InputInvalidException.class, range::validate);
		assertEquals("Input error", e.getMessage());
	}

	@Test
	@DisplayName("ลงท้ายด้วย ], ) เท่านั้น input = [1,5")
	void case03() {
		MyRange range = new MyRange("[1,5");
		Exception e = assertThrowsExactly(InputInvalidException.class, range::validate);
		assertEquals("Input error", e.getMessage());
	}

	@Test
	@DisplayName("ขึ้นต้นด้วย [, ( และ ลงท้ายด้วย ], ) เท่านั้น input = 1,5")
	void case04() {
		MyRange range = new MyRange("1,5");
		Exception e = assertThrowsExactly(InputInvalidException.class, range::validate);
		assertEquals("Input error", e.getMessage());
	}
}
