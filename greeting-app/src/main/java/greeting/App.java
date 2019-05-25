package greeting;

import java.time.LocalDateTime;
import java.util.Optional;

import greeting.spi.Greeter;

public class App {

    public static void main(String[] args) {
		
    	App app = new App();
    	app.run();

	}
    
    private final Greeter greeter = getGreeterImplementation();
	
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


	private Greeter getGreeterImplementation() {
		
		GreeterServiceProvider provider = GreeterServiceProvider.getInstance();
		Optional<Greeter> service = provider.getGreeter();
		
		if (service.isPresent()) {
			return service.get();
		}
		
		throw new IllegalArgumentException("There is no greeter service configured.");
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