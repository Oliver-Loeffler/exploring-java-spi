package greeting.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import greeting.service.GreeterServiceProvider;
import greeting.service.spi.Greeter;

public class GreetingTest {

	private Greeter classUnderTest;
	
	@Test
	void that_HelloDuke_is_the_greeting() {
		classUnderTest = new Greeting();
		
		assertEquals("ProductionLibrary: HelloDuke", classUnderTest.getSalutation());
	}
	
	@Test
	void that_at_least_one_service_is_found() {
		
		GreeterServiceProvider provider = GreeterServiceProvider.getInstance();
		Greeter greeter = provider.getGreeter();
		
		assertNotNull( greeter );
		
	}

}
