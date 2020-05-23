package greeting.app;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import greeting.service.GreeterServiceProvider;
import greeting.service.spi.Greeter;

public class ServiceDiscoveryTest {
	
	private final GreeterServiceProvider provider = GreeterServiceProvider.getInstance();
	
	@DisplayName("that at least one service is configured")
	@Test
	void printKnownImplementationsToSystemOut() {
		
		List<Greeter> greeter = provider.getAllAvailableImplementations();

		assertFalse(greeter.isEmpty());

		System.out.println("Found " + greeter.size() + " Implementations.");

		for (final Greeter g : greeter) {
			System.out.println(g.getClass().getName());
		}
		
	}
	
	
	
}
