package badcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegisterBusinessTest {

	@Test
	void case01() {
		RegisterBusiness business = new RegisterBusiness();
		Speaker speaker = new Speaker();
		speaker.setFirstName("firstName");
		speaker.setLastName("lastName");
		speaker.setEmail("email@gmail.com");
		SpeakerRepository repository = new SpeakerRepository() {

			@Override
			public Integer saveSpeaker(Speaker speaker) {
				return 100;
			}

		};
		Integer speakerId = business.register(repository, speaker);
		assertEquals(100, speakerId);
	}

	@Test
	void case02() {
		RegisterBusiness business = new RegisterBusiness();
		Speaker speaker = new Speaker();
		speaker.setFirstName("firstName");
		speaker.setLastName("lastName");
		speaker.setEmail("email@gmail.com");
		speaker.setExp(0);
		SpeakerRepository repository = new SpeakerRepository() {

			@Override
			public Integer saveSpeaker(Speaker speaker) {
				assertEquals(500, speaker.getRegistrationFee());
				return 100;
			}

		};
		business.register(repository, speaker);
	}

	@Test
	void case03() {
		RegisterBusiness business = new RegisterBusiness();
		Speaker speaker = new Speaker();
		speaker.setFirstName("firstName");
		speaker.setLastName("lastName");
		speaker.setEmail("email@gmail.com");
		speaker.setExp(3);
		SpeakerRepository repository = new SpeakerRepository() {

			@Override
			public Integer saveSpeaker(Speaker speaker) {
				assertEquals(250, speaker.getRegistrationFee());
				return 100;
			}

		};
		business.register(repository, speaker);
	}

	@Test
	void case04() {
		RegisterBusiness business = new RegisterBusiness();
		Speaker speaker = new Speaker();
		speaker.setFirstName("firstName");
		speaker.setLastName("lastName");
		speaker.setEmail("email@gmail.com");
		speaker.setExp(5);
		SpeakerRepository repository = new SpeakerRepository() {

			@Override
			public Integer saveSpeaker(Speaker speaker) {
				assertEquals(100, speaker.getRegistrationFee());
				return 100;
			}

		};
		business.register(repository, speaker);
	}

	@Test
	void case05() {
		RegisterBusiness business = new RegisterBusiness();
		Speaker speaker = new Speaker();
		speaker.setFirstName("firstName");
		speaker.setLastName("lastName");
		speaker.setEmail("email@gmail.com");
		speaker.setExp(9);
		SpeakerRepository repository = new SpeakerRepository() {

			@Override
			public Integer saveSpeaker(Speaker speaker) {
				assertEquals(50, speaker.getRegistrationFee());
				return 100;
			}

		};
		business.register(repository, speaker);
	}
}
