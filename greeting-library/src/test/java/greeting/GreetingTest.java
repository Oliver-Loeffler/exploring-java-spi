package greeting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import greeting.spi.Greeter;

public class GreetingTest {

	private Greeter classUnderTest;
	
	@Test
	void test() {
		classUnderTest = new Greeting("HelloDuke");
		
		assertEquals("HelloDuke", classUnderTest.getSalutation());
	}

}
