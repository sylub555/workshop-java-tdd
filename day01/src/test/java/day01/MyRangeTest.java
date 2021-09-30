package day01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyRangeTest {

	@Test
	@DisplayName("ตัวแรกต้องเป็น [ (include) โดยที่ input = [1,5], result = true")
	void case01() {
		String input = "[1,5]";
		MyRange range = new MyRange(input);
		boolean result = range.startWithInclude();
		assertTrue(result, "start with [");
	}

	@Test
	@DisplayName("ตัวแรกต้องเป็น [ (include) โดยที่ input = (1,5], result = false")
	void case02() {
		String input = "(1,5]";
		MyRange range = new MyRange(input);
		boolean result = range.startWithInclude();
		assertFalse(result);
	}

	@Test
	@DisplayName("ตัวเลขเริ่มต้น เป็น 1 input = [1,5], result = 1")
	void case03() {
		String input = "[1,5]";
		MyRange range = new MyRange(input);
		int result = range.getStart();
		assertEquals(1, result);
	}

	@Test
	@DisplayName("ตัวเลขเริ่มต้น เป็น 1 input = (1,5], result = 2")
	void case04() {
		String input = "(1,5]";
		MyRange range = new MyRange(input);
		int result = range.getStart();
		assertEquals(2, result);
	}

	@Test
	@DisplayName("ตัวเลขสุดท้าย เป็น 5 input = [1,5], result = 5")
	void case101() {
		String input = "[1,5]";
		MyRange range = new MyRange(input);
		int result = range.getEnd();
		assertEquals(5, result);
	}

	@Test
	@DisplayName("ตัวเลขสุดท้าย เป็น 5 input = [1,5), result = 4")
	void case102() {
		String input = "[1,5)";
		MyRange range = new MyRange(input);
		int result = range.getEnd();
		assertEquals(4, result);
	}

	@Test
	@DisplayName("เรียงลำดับตัวเลย เป็น 1-5 input = [1,5], result = 1,2,3,4,5")
	void case103() {
		String input = "[1,5]";
		MyRange range = new MyRange(input);
		String result = range.getRange();
		assertEquals("1,2,3,4,5", result);
	}

	@Test
	@DisplayName("เรียงลำดับตัวเลย เป็น 1-5 input = [1,5), result = 1,2,3,4")
	void case104() {
		String input = "[1,5)";
		MyRange range = new MyRange(input);
		String result = range.getRange();
		assertEquals("1,2,3,4", result);
	}
	
	@Test
	@DisplayName("เรียงลำดับตัวเลย เป็น 1-5 input = (1,5], result = 2,3,4,5")
	void case105() {
		String input = "(1,5]";
		MyRange range = new MyRange(input);
		String result = range.getRange();
		assertEquals("2,3,4,5", result);
	}
	
	@Test
	@DisplayName("เรียงลำดับตัวเลย เป็น 1-5 input = (1,5), result = 2,3,4")
	void case106() {
		String input = "(1,5)";
		MyRange range = new MyRange(input);
		String result = range.getRange();
		assertEquals("2,3,4", result);
	}
	
	@Test
	@DisplayName("เรียงลำดับตัวเลย เป็น 1-5 input = [0,5], result = 0,1,2,3,4,5,6,7,8,9")
	void case107() {
		String input = "[0,9]";
		MyRange range = new MyRange(input);
		String result = range.getRange();
		assertEquals("0,1,2,3,4,5,6,7,8,9", result);
	}

}
