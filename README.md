# Exploring Java Service Provider Interface (SPI)

The way how the service provider interface API works has changed with Java 9.
All details below apply to Java 7 or Java 8, details for most recent Java versions will be added later.

## Idea

There is a ```Greeter``` interface. This interface has only one method ```String getSalutation();```.
Its task is to provide a salutation such as "Welcome", "Hello" or "Hi". How this salutation is obtained or created is task of the individual implementation.

The ```greeting-library``` always greets with "HelloDuke" whereas ```custom-greeting-library``` always greets with "WelcomeSPI!".

The motoviation here is, to enable configuration of certain services in production projects using Java SPI mechanism and to swap out test, integration-test and production components by just configuring dependencies in Gradle or Maven properly.
It is also desirable to have only one implementation available at time. Currently the service loader returns the first implementation found.

## Goals

* separate API of a library from its implementation
* provide different implementations for test, integration-test and build
* just decide which library to use by adding the dependency in Gradle build at the right stage
* if possible avoid configuration of gradle, stick with defaults


## Achievements so far

* API package is defined, a ServiceProvider class exists (```greeting-api```)
* There are 2 implementations of ```greeting-api```:
  * ```greeting-library```
  * ```custom-greeting-library```
* There is one application where the ```custom-greeting-library``` is used during test.

## Open

* Explore how to configure the ```greeting-library``` for runtime and build.
* Explore how to configure to run another implementation for integration testing
