package other;

import greeting.spi.Greeter;

public class Welcome implements Greeter {

    private String myCustomWelcomeFormula;
    
    public Welcome() {
        this.myCustomWelcomeFormula = "TestLibrary: WelcomeJavaSPI!";
    }

	@Override
	public String getSalutation() {
		return this.myCustomWelcomeFormula;
	}
}