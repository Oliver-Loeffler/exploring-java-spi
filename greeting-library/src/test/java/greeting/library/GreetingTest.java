package greeting.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import greeting.service.GreeterServiceProvider;
import greeting.service.spi.Greeter;

public class GreetingTest {

	private Greeter classUnderTest;
	
	@DisplayName("that the service returns \"HelloDuke\" as salutation.")
	@Test
	void testImplementation() {
		classUnderTest = new Greeting();
		
		assertEquals("ProductionLibrary: HelloDuke", classUnderTest.getSalutation());
	}
	
	@DisplayName("that there is one service implementing \"greeting.service.spi.Greeter\".")
	@Test
	void testServiceDiscovery() {
		
		GreeterServiceProvider provider = GreeterServiceProvider.getInstance();
		Greeter greeter = provider.getGreeter();
		
		assertNotNull( greeter );
		
	}

}
