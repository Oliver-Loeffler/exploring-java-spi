package greeting.app;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;

import greeting.service.GreeterServiceProvider;
import greeting.service.spi.Greeter;

public class ServiceDiscoveryTest {
	
	private final GreeterServiceProvider provider = GreeterServiceProvider.getInstance();
	
	@Test
	void that_at_least_one_service_is_found() {
		
		List<Greeter> greeter = provider.getAllAvailableImplementations();
		
		assertFalse(greeter.isEmpty(), "There must be at least one service implementation.");

		System.out.println("Found " + greeter.size() + " Implementations.");
		
		for (Greeter g : greeter) {
			System.out.println(g.getClass().getName());
		}
		
	}
	
	
	
}
