package greeting.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class GreeterServiceProviderTest {
	
	private final GreeterServiceProvider classUnderTest = GreeterServiceProvider.getInstance();

	@Test
	void that_no_services_are_found() {

		assertThrows(IllegalArgumentException.class,
				()->classUnderTest.getGreeter());
	
	}

}
