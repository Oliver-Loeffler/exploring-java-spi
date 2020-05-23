package other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import greeting.service.GreeterServiceProvider;
import greeting.service.spi.Greeter;

public class ServiceDiscoveryTest {
	
	private final GreeterServiceProvider provider = GreeterServiceProvider.getInstance();
	
	@Test
	void that_there_is_only_one_service_implementation() {
		
		List<Greeter> greeter = provider.getAllAvailableImplementations();
		
		assertEquals( 1, greeter.size() );
		
	}
	
	@Test
	void that_Custom_Service_is_discovered() {
		
		Greeter greeter = provider.getGreeter();
		
		Class<? extends Greeter> discoveredClass = greeter.getClass();
		
		assertEquals(Welcome.class, discoveredClass);
		
	}
	
}
