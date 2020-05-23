module library {
    requires api;

    exports greeting.library;
    
    provides greeting.service.spi.Greeter 
        with greeting.library.Greeting;
        
}