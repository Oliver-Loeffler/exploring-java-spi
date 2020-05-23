package greeting.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import greeting.service.spi.Greeter;

public class AppTest {
	
	private App classUnderTest = new App();
	
	@Test
	void getSlogan() {
		String slogan = classUnderTest.getSlogan();
		
		assertNotNull(slogan);
		assertEquals("TestLibrary: WelcomeJavaSPI!", slogan);
	}
	
	@Test
	void getGreeterImplementationClass() {
		Class<? extends Greeter> implementationClass 
			= classUnderTest.getGreeterClass();
		
		assertEquals("other.Welcome", implementationClass.getName());
	}
	
}
