package greeting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
	
	protected List<Greeter> getAllAvailableImplementations() {
		List<Greeter> discoveredImplementations = new ArrayList<>();
		Iterator<Greeter> availableImplementations = loader.iterator();
		while(availableImplementations.hasNext()) {
			Greeter greeter = availableImplementations.next();
			discoveredImplementations.add(greeter);
		}
		return discoveredImplementations;
    }
	
	public Greeter getGreeter() {
		List<Greeter> greeter = getAllAvailableImplementations();
		if (greeter.isEmpty()) {
			throw new IllegalArgumentException("There is no greeter service configured.");
		}
		return greeter.get(0);
	}

}
