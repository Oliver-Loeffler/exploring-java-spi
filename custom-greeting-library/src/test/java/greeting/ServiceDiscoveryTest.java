package greeting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import greeting.spi.Greeter;
import other.Welcome;

public class ServiceDiscoveryTest {
	
	private final GreeterServiceProvider provider = GreeterServiceProvider.getInstance();
	
	@Test
	void thereMustBeOnlyOneImplementation() {
		
		List<Greeter> greeter = provider.getAllAvailableImplementations();
		
		assertEquals( 1, greeter.size() );
		
	}
	
	@Test
	void welcomeIsExpectedAsImplementation() {
		
		Greeter greeter = provider.getGreeter().get();
		
		Class<? extends Greeter> discoveredClass = greeter.getClass();
		
		assertEquals(Welcome.class, discoveredClass);
		
	}
	
}
