package other;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import greeting.GreeterServiceProvider;
import greeting.spi.Greeter;

public class WelcomeTest {

	private Greeter classUnderTest;
	
	@Test
	void testMyCustomImplementation() {
		classUnderTest = new Welcome();
		
		assertEquals("WelcomeJavaSPI!", classUnderTest.getSalutation());
	}
	
	@Test
	void testServiceDiscovery() {
		
		GreeterServiceProvider provider = GreeterServiceProvider.getInstance();
		Optional<Greeter> greeter = provider.getGreeter();
		
		assertTrue( greeter.isPresent() );
		
	}

}
