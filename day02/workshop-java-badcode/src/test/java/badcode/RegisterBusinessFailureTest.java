package badcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegisterBusinessFailureTest {

	@Test
	void case01_first_name_required() {
		RegisterBusiness business = new RegisterBusiness();
		Exception exception = assertThrows(ArgumentNullException.class, () -> {
			business.register(null, new Speaker());
		});
		assertEquals("First name is required.", exception.getMessage());
	}

	@Test
	void case02_last_name_required() {
		RegisterBusiness business = new RegisterBusiness();
		Speaker speaker = new Speaker();
		speaker.setFirstName("firstName");
		Exception exception = assertThrows(ArgumentNullException.class, () -> {
			business.register(null, speaker);
		});
		assertEquals("Last name is required.", exception.getMessage());
	}

}
