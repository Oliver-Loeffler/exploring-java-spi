package other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import greeting.service.spi.Greeter;

public class WelcomeTest {

	private Greeter classUnderTest;
	
	@Test
	void that_welcome_is_the_greeting() {

		classUnderTest = new Welcome();
		
		assertEquals("TestLibrary: WelcomeJavaSPI!", classUnderTest.getSalutation());
	}

}
