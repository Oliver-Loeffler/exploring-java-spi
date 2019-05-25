package greeting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import greeting.spi.Greeter;

public class GreetingTest {

	private Greeter classUnderTest;
	
	@Test
	void testImplementation() {
		classUnderTest = new Greeting();
		
		assertEquals("HelloDuke", classUnderTest.getSalutation());
	}
	
	@Test
	void testServiceDiscovery() {
		
		GreeterServiceProvider provider = GreeterServiceProvider.getInstance();
		Optional<Greeter> greeter = provider.getGreeter();
		
		assertTrue( greeter.isPresent() );
		
	}

}
