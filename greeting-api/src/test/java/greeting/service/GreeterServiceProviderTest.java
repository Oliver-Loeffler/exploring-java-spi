package greeting.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class GreeterServiceProviderTest {
	
	private final GreeterServiceProvider classUnderTest = GreeterServiceProvider.getInstance();

	@Test
	void getGreeterWithoutConfiguration() {

		assertThrows(IllegalArgumentException.class,
				()->classUnderTest.getGreeter());
	
	}

}
