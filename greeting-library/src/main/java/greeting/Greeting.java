package greeting;

import greeting.spi.Greeter;

public class Greeting implements Greeter {

    private String slogan;
    
    public Greeting() {
        this.slogan = "ProductionLibrary: HelloDuke";
    }

	@Override
	public String getSalutation() {
		return this.slogan;
	}
}