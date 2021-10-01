package badcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RegisterBusinessGetFreeTest {

	@ParameterizedTest
	@CsvSource({ 
		"0,500" ,
		"1,500" ,
		"2,250" ,
		"3,250" ,
		"4,100" ,
		"5,100" ,
		"8,50" ,
		"9,50" ,
		"10,0" ,
	})
	void getFree(int exp, int free) {
		RegisterBusiness business = new RegisterBusiness();
		int actualFree = business.getFee(exp);
		assertEquals(free, actualFree);
	}
}
