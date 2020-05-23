module api {
    exports greeting.service;
    exports greeting.service.spi;

    uses greeting.service.GreeterServiceProvider;
    uses greeting.service.spi.Greeter;
}