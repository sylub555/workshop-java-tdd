package badcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RegisterBusinessFailureTest {

	@ParameterizedTest
	@CsvSource(value = { "null", "''" }, nullValues = { "null" })
	void case01_first_name_required(String firstName) {
		RegisterBusiness business = new RegisterBusiness();
		Speaker speaker = new Speaker();
		speaker.setFirstName(firstName);
		Exception exception = assertThrows(ArgumentNullException.class, () -> {
			business.register(null, new Speaker());
		});
		assertEquals("First name is required.", exception.getMessage());
	}

	@ParameterizedTest
	@CsvSource(value = { "null", "''" }, nullValues = { "null" })
	void case02_last_name_required(String lastName) {
		RegisterBusiness business = new RegisterBusiness();
		Speaker speaker = new Speaker();
		speaker.setFirstName("firstName");
		speaker.setLastName(lastName);
		Exception exception = assertThrows(ArgumentNullException.class, () -> {
			business.register(null, speaker);
		});
		assertEquals("Last name is required.", exception.getMessage());
	}

	@Test
	void case03_email_required() {
		RegisterBusiness business = new RegisterBusiness();
		Speaker speaker = new Speaker();
		speaker.setFirstName("firstName");
		speaker.setLastName("lastName");
		Exception exception = assertThrows(ArgumentNullException.class, () -> {
			business.register(null, speaker);
		});
		assertEquals("Email is required.", exception.getMessage());
	}

	@Test
	void case04_email_domain_invalid() {
		RegisterBusiness business = new RegisterBusiness();
		Speaker speaker = new Speaker();
		speaker.setFirstName("firstName");
		speaker.setLastName("lastName");
		speaker.setEmail("email");
		Exception exception = assertThrows(DomainEmailInvalidException.class, () -> {
			business.register(null, speaker);
		});
		assertNull(exception.getMessage());
	}

	@Test
	void case05_email_not_meer_rules() {
		RegisterBusiness business = new RegisterBusiness();
		Speaker speaker = new Speaker();
		speaker.setFirstName("firstName");
		speaker.setLastName("lastName");
		speaker.setEmail("email@localhost");
		Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> {
			business.register(null, speaker);
		});
		assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
	}

	@Test
	void case06_can_not_save() {
		RegisterBusiness business = new RegisterBusiness();
		Speaker speaker = new Speaker();
		speaker.setFirstName("firstName");
		speaker.setLastName("lastName");
		speaker.setEmail("email@gmail.com");
		Exception exception = assertThrows(SaveSpeakerException.class, () -> {
			business.register(null, speaker);
		});
		assertEquals("Can't save a speaker.", exception.getMessage());
	}

}
