Tools Used:
IDE (Eclipse or IntelliJ preferably)
Maven
Git Bash
Spring Boot

Instructions

To Launch Web Application

FROM IDE:
-Import registration-app folder as a maven project in preferred IDE (Eclipse, IntelliJ, etc).
-Run App.java class under com.user.service.registration package as a java application in order to launch the web application.

FROM COMMAND LINE:
-Go into registration-app directory
-Execute "mvn package" or "mvn install" command to generate application jar
-After jar is generated execute java -jar target/registration-app-0.0.1-SNAPSHOT.jar to launch web application

Once spring application is up and running:

To register a new user a POST request can be made to http://localhost:8080/user/service/register with a rest client
using the following json format:

{
	"userName":"JWick",
	"password":"Pass1",
	"dob":"1980/10/14",
	"ssn":"5192986332"
}

Users can be added to the blacklist / exclusion list by calling rest service http://localhost:8080/user/service/blacklist using
the same json format / POST method.

Junit test cases can be run from IDE, and are under:
/registration-app/src/test/java/com/user/service/registration/registration/RegistrationControllerTest.java