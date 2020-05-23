package greeting.service.spi;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GreeterTest {

	private Greeter classUnderTest;
	
	@BeforeEach
	public void prepare() {
		this.classUnderTest = createGreeter("HelloDude");
	}
	
	@Test
	public void getSalutation() {
		assertEquals("HelloDude", classUnderTest.getSalutation());
	}
	
	private Greeter createGreeter(String salutation) {
		Greeter greeter = new Greeter() {

			@Override
			public String getSalutation() {
				return salutation;
			}
			
		};
		return greeter;
	}

}
