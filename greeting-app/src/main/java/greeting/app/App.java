package greeting.app;

import java.time.LocalDateTime;

import greeting.service.GreeterServiceProvider;
import greeting.service.spi.Greeter;

public class App {

    public static void main(String[] args) {
		
    	App app = new App();
    	app.run();

	}
    
    private final Greeter greeter = getGreeterImplementation();
	
    public void run() {
    	
    	print(getStartupMessage());
    	print(getSlogan());
    	print("Service implementation used: " + greeter.getClass().getName());
    }
    
    public String getSlogan() {
    	return this.greeter.getSalutation();
    }
    
    public Class<? extends Greeter> getGreeterClass() {
    	return this.greeter.getClass();
    }


	private Greeter getGreeterImplementation() {
		GreeterServiceProvider provider = GreeterServiceProvider.getInstance();
		Greeter service = provider.getGreeter();
		return service;
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