package greeting;

import greeting.spi.Greeter;

public class Greeting implements Greeter {

    private String slogan;

    public Greeting(String slogan) {
        this.slogan = slogan;
    }

	@Override
	public String getSalutation() {
		return this.slogan;
	}
}