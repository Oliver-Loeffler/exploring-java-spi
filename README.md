# Exploring Java Service Provider Interface (SPI)

The way how the service provider interface API works has changed with Java 9.
All details below apply to Java 7 or Java 8, details for most recent Java versions will be added later.

## Idea

There is a ```Greeter``` interface. This interface has only one method ```String getSalutation();```.
Its task is to provide a salutation such as "Welcome", "Hello" or "Hi". How this salutation is obtained or created is task of the individual implementation.

The ```greeting-library``` always greets with "HelloDuke" whereas ```custom-greeting-library``` always greets with "WelcomeSPI!".

The motivation here is, to enable configuration of certain services in production projects using Java SPI mechanism and to swap out test, integration-test and production components by just configuring dependencies in Gradle or Maven properly.
It is also desirable to have only one implementation available at time. Currently the service loader returns the first implementation found.

### How to run it

```shell

$ git clone https://github.com/Oliver-Loeffler/exploring-java-spi.git spidemo-gradle
$ cd spidemo-gradle
$ gradle clean check run

```


### _What already works_

* API project provides a service provider and the service interface  (```greeting-api```).
* There are 2 different implementations of the service (```greeting-library``` and ```custom-greeting-library```).
* There is an application which uses the service interface (```greeting-app```).
  * The application uses the API project and for runtime one implementation, for test 
    another implementation.

As the service provider always hands over the last registered service, the service 
selection is basically defined by adding a project as a dependency to the proper Gradle 
configuration. 

```gradle

dependencies {

    // the current project uses the API
    implementation project(':greeting-api')

    // one API implementation is used for runtime
    runtimeOnly project(':greeting-library')
    
    testCompileOnly ('org.junit.jupiter:junit-jupiter-api:5.4.0')
    testRuntimeOnly ('org.junit.jupiter:junit-jupiter-engine:5.4.0')

    // another API implementation is used for testing
    testRuntimeOnly project(':custom-greeting-library') 

    // There is no hook yet for integration tests.
    // For integration tests it is possibly desirable to use 
    // the runtime configuration.

}

```

## Goals

* separate API of a library from its implementation
* provide different implementations for test, integration-test and build
* just decide which library to use by adding the dependency in Gradle build at the right stage
* if possible avoid configuration of Gradle, stick with defaults

## Open

* Explore how to configure the ```greeting-library``` for runtime and build.
* Explore how to configure to run another implementation for integration testing
