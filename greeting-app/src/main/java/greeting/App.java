package greeting;

import java.time.LocalDateTime;

import greeting.spi.Greeter;

public class App {

    public static void main(String[] args) {
		
    	App app = new App();
    	app.run();

	}
    
    private final Greeter greeter = getGreetingsProvider();
	
    public void run() {
    	
    	print(getStartupMessage());
    	print(getSlogan());
    	
    }
    
    public String getSlogan() {
    	return this.greeter.getSalutation();
    }
    
    public Class<? extends Greeter> getGreeterClass() {
    	return this.greeter.getClass();
    }


	private Greeter getGreetingsProvider() {
		return new Greeting();
	}


	private String getStartupMessage() {
		return new StringBuilder("App started: ")
    			.append("it is now: ")
    			.append(LocalDateTime.now())
    			.append(System.lineSeparator())
    			.toString();
	}
	
	private void print(String value) {
		System.out.println(value);
	}
}