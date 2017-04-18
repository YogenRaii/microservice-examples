# Sample-API
Sample API - `/sample-api/` - API description.

## API Endpoints
1. 	**Sample 1**

    ```
    GET               /resource/path/{id}
    ```
    
    Parameters: None

2.	**Sample 2**

    ```
    POST               /resource/path
    ```
    
   The request body should be in format below:
   
   ```
   {
	"request": {
		"type": "string"
	}
}
```
   
   Parameters:
    
    | Name	       | Mandatory	       |  Description                          |
    | -----------  |:-----------------:| -------------------------------------:|
    | param1	   |  Yes	           | Input params                 |

## Workspace Requirements

* environment variables:
    * CONFIG_SERVER_URL = http://localhost:8888/config
    * SPRING_PROFILES_ACTIVE=default,dvl,native
    
    In git-bash, update ~/.bashrc to export variables or if preferred to do it on Window's control panel System > Advanced > Environment variables

* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 1.8+ installed on the computer
* [git-bash](https://git-scm.com/downloads) for Windows

## Setting Up

1. Clone `Sample-API` repository using Git command:

   ```
     git clone https://github.com/sample/sample-api.git
     cd sample
   ```
2. Run ./gradlew. This will fetch all the dependencies. For the first time, you will need to be connected over VPN. To build the project run ./gradlew build.
3. Import the project in Intellij. Install Lombok plugin. Enable annotation processors.

## Setting up Development Server

* open up git-bash, and run the local-config first:
```
$ ./gradlew local-config:bootRun
```
* Open up a second git-bash, and run the flights-detail itself:
```
$ ./gradlew sample-api:bootRun
```
## Swagger UI
open `http://localhost:8080/swagger-ui.html` in any browser

## Configuration
Configuration is represented as YAML and is available under the `config` folder. Different environment profiles are available. The non-profile designated YML `sample-api.yml` is common for all environments.

## Frameworks
* [Spring Framework](http://projects.spring.io/spring-framework/) for [dependency injection and Web MVC framework](http://docs.spring.io/spring/docs/4.2.7.RELEASE/spring-framework-reference/htmlsingle/).
* [Spring Boot](http://projects.spring.io/spring-boot/) for configuration and tooling

## Libraries
* [Tomcat](http://tomcat.apache.org) as embedded application server for local development
* [EhCache 3.0] (http://www.ehcache.org/documentation/3.0/) -  for in-API caching and preventing cached object from mutation. It's the most widely-used Java-based cache because it's robust, proven, full-featured, and integrates with other popular libraries and frameworks
* [Springfox](https://github.com/springfox/springfox) - A Java implementation of [Swagger](http://swagger.io/) for documentation. Chosen because of its easy integration with Spring.
* [JsonPath](https://github.com/jayway/JsonPath) - A Java DSL for reading JSON documents.
* [Lombok] (https://github.com/mplushnikov/lombok-intellij-plugin) - generating getters, setters and some other things, so that you get code completion and are able to work without errors stating the methods don't exists.
* [Google Guava](https://github.com/google/guava) for [Strings](https://google.github.io/guava/releases/19.0/api/docs/com/google/common/base/Strings.html)
* [JodaTime](http://www.joda.org/joda-time/) - DateTime library for Java. There is a Java 8 implementation already but prefer the stand-alone library from the JDK due to portability.
