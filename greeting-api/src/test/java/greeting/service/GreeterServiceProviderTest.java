package greeting.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GreeterServiceProviderTest {
	
	private final GreeterServiceProvider classUnderTest = GreeterServiceProvider.getInstance();

	@DisplayName("that no service is available at all")
	@Test
	void getGreeterWithoutConfiguration() {

		assertThrows(IllegalArgumentException.class,
				()->classUnderTest.getGreeter());
	
	}

}
