module library {
    requires api;
    
    uses greeting.service.GreeterServiceProvider;

    provides greeting.service.spi.Greeter 
        with greeting.library.Greeting;
        
}