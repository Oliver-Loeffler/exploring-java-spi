package greeting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import greeting.spi.Greeter;

public class AppTest {
	
	private App classUnderTest = new App();
	
	@BeforeAll
	static void setup() {
		GreeterServiceProvider
			.getInstance()
			.setTargetImplementation("other.Welcome");
	}
	
	@Test
	void getSlogan() {
		String slogan = classUnderTest.getSlogan();
		
		assertNotNull(slogan);
		assertEquals("WelcomeJavaSPI!", slogan);
	}
	
	@Test
	void getGreeterImplementationClass() {
		Class<? extends Greeter> implementationClass 
			= classUnderTest.getGreeterClass();
		
		assertEquals("other.Welcome", implementationClass.getName());
	}
	
}
