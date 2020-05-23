package greeting.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import greeting.service.spi.Greeter;

public class AppTest {
	
	private App classUnderTest = new App();
	
	@Test
	void that_app_provides_the_expected_slogan() {
		String slogan = classUnderTest.getSlogan();
		
		assertNotNull(slogan);
		assertEquals("TestLibrary: WelcomeJavaSPI!", slogan);
	}
	
	@Test
	void that_customized_library_is_used_during_test() {
		Class<? extends Greeter> implementationClass 
			= classUnderTest.getGreeterClass();
		
		assertEquals("other.Welcome", implementationClass.getName());
	}
	
}
