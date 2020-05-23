package greeting.service;

import java.util.List;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;
import java.util.stream.Collectors;

import greeting.service.spi.Greeter;

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
	
	public List<Greeter> getAllAvailableImplementations() {
		List<Greeter> greeterImplementations = loader.stream()
													 .map(Provider::get)
													 .collect(Collectors.toList());
		
		return greeterImplementations;
    }
	
	public Greeter getGreeter() {
		List<Greeter> greeter = getAllAvailableImplementations();		
		return getLastImplementation(greeter);
	}

	private Greeter getLastImplementation(List<Greeter> greeter) {
		if (greeter.isEmpty()) {
			throw new IllegalArgumentException("There is no greeter service configured.");
		}
		return greeter.get(greeter.size()-1);
	}

}
