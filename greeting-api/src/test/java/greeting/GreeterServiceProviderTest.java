package greeting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GreeterServiceProviderTest {
	
	private final GreeterServiceProvider classUnderTest = GreeterServiceProvider.getInstance();

	@Test
	void getGreeterWithoutConfiguration() {

		assertThrows(IllegalArgumentException.class,
				()->classUnderTest.getGreeter());
	}

}
