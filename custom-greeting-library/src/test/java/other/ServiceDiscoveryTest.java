package other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import greeting.service.GreeterServiceProvider;
import greeting.service.spi.Greeter;

public class ServiceDiscoveryTest {
	
	private final GreeterServiceProvider provider = GreeterServiceProvider.getInstance();
	
	@DisplayName("that only 1 service is discovered")
	@Test
	void thereMustBeOnlyOneImplementation() {
		
		List<Greeter> greeter = provider.getAllAvailableImplementations();
		
		assertEquals( 1, greeter.size() );
		
	}
	
	@DisplayName("that Welcome.class is discovered as service")
	@Test
	void welcomeIsExpectedAsImplementation() {
		
		Greeter greeter = provider.getGreeter();
		
		Class<? extends Greeter> discoveredClass = greeter.getClass();
		
		assertEquals(Welcome.class, discoveredClass);
		
	}
	
}
