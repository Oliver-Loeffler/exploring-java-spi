module customized {
    requires api;
    
    exports other;
    
    provides greeting.service.spi.Greeter 
        with other.Welcome;
}