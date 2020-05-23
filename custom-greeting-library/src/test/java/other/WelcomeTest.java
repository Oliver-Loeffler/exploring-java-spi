package other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import greeting.service.spi.Greeter;

public class WelcomeTest {

	private Greeter classUnderTest;
	
	@Test
	void testMyCustomImplementation() {
		classUnderTest = new Welcome();
		
		assertEquals("TestLibrary: WelcomeJavaSPI!", classUnderTest.getSalutation());
	}

}
