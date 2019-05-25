package greeting;

import java.util.List;

import org.junit.jupiter.api.Test;

import greeting.spi.Greeter;

public class ServiceDiscoveryTest {
	
	private final GreeterServiceProvider provider = GreeterServiceProvider.getInstance();
	
	@Test
	void printKnownImplementationsToSystemOut() {
		
		List<Greeter> greeter = provider.getAllAvailableImplementations();
		
		System.out.println("Found " + greeter.size() + " Implementations.");
		
		for (Greeter g : greeter) {
			System.out.println(g.getClass().getName());
		}
		
	}
	
	
	
}
