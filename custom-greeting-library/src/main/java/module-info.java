module customized {
    requires api;
    
    uses greeting.service.GreeterServiceProvider;
    uses greeting.service.spi.Greeter;
}