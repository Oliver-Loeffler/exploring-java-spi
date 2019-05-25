package greeting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import greeting.spi.Greeter;

class GreeterServiceProviderTest {
	
	private final GreeterServiceProvider classUnderTest = GreeterServiceProvider.getInstance();

	@Test
	void getGreeterWithoutConfiguration() {
		
		Optional<Greeter> greeter = classUnderTest.getGreeter();
		
		assertFalse( greeter.isPresent() );
		
	}

}
