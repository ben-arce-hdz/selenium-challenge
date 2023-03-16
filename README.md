# UI Automation Framework
This is a BDD framework that was built with SpringBoot taking whole the advantages of Spring. 

## Getting Started

These instructions will present a guide on how to execute this project.

### Prerequisites

* Java 11
* Maven

### Installing

Pull the project to your working directory, and download the following dependencies.

### Dependencies

Currently are in use the following dependencies.

|Artifact ID                	|   
|---                        	|
|spring-boot-starter			|
|spring-boot-starter-test		|
|selenium-java              	|
|webdrivermanager           	|
|cucumber-spring            	|
|cucumber-java              	|
|cucumber-testng            	|
|testng                     	|
|lombok                     	|
|assertj-core              		|
|cucumber-reporting        		|

### Usage
This framework is configurable with different properties like:
<br /> -Parallelism Thread Count
<br /> -Browser (chrome/firefox/edge)
<br /> -Headless (true/false)
<br /> -Profiles (qa/dev/prod) 
<br /> -Cucumber tags

#### Local Execution  
```java
Command Line Execution

Execution without report:
mvn clean test

Execution with report:
mvn clean verify

Execution with other profile:
mvn clean verify -Dspring.profiles.active=dev|qa|uat

Execution with specific browser:
mvn clean verify -Dbrowser=firefox|edge|chrome

Execution headless mode:
mvn clean verify -Dbrowser.isheadless=true

Execution specific tags:
mvn clean verify -Dcucumber.options="--tags @regression"

Execution specific number of threads:
mvn clean verify -Dthreadcount=5

Execution all options:
mvn clean verify -Dbrowser=chrome -Dbrowser.isheadless=true -Dspring.profiles.active=dev -Dcucumber.options="--tags @regression" -Dthreadcount=5
```

```java
IDE Execution

Open the CucumberRunner class and execute it - right click run as testng class.
```

### Reporting

![Report](target/image/Report.png)

## Author
Feel free to ask [Benjamin Arce](benjamin_arce1991@hotmail.com) if you need some support or there are any questions.