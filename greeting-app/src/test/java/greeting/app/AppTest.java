package greeting.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import greeting.service.spi.Greeter;

public class AppTest {
	
	private App classUnderTest = new App();
	
	@DisplayName("that during test the slogan \"WelcomeJavaSPI!\" is provided.")
	@Test
	void getSlogan() {
		String slogan = classUnderTest.getSlogan();
		
		assertNotNull(slogan);
		assertEquals("TestLibrary: WelcomeJavaSPI!", slogan);
	}
	
	@DisplayName("that \"other.Welcome.class\" is used as service.")
	@Test
	void getGreeterImplementationClass() {
		Class<? extends Greeter> implementationClass 
			= classUnderTest.getGreeterClass();
		
		assertEquals("other.Welcome", implementationClass.getName());
	}
	
}
