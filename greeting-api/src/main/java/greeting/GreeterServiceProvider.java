package greeting;

import java.util.Iterator;
import java.util.Optional;
import java.util.ServiceLoader;

import greeting.spi.Greeter;

public class GreeterServiceProvider {

	public static synchronized GreeterServiceProvider getInstance() {
        if (service == null) {
            service = new GreeterServiceProvider();
        }
        return service;
    }
	
	private static GreeterServiceProvider service;
	
	private ServiceLoader<Greeter> loader;

	private GreeterServiceProvider() {
        loader = ServiceLoader.load(Greeter.class);
    }
	
	public Optional<Greeter> getGreeter() {
		Iterator<Greeter> availableImplementations = loader.iterator();
		while(availableImplementations.hasNext()) {
			Greeter greeter = availableImplementations.next();
			return Optional.of(greeter);
		}
		return Optional.empty();
    }

}
