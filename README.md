You can git clone this repository.

First make sure you have an instance of docker and mongodb installed.

Then you can do these following commands:

	- docker pull mongo
	- docker -d --name namehere port:port mongo
	
Now the docker container is running on the port you defined.
You can check running containers using : 

	- docker ps -a

Atfer all of these steps, please run :

	- mvn clean install
	- mvn spring-boot:run

Now you can open any browser on : http://localhost:8080/books

This link is a reactive streaming endpoint, if you wanna get some data you need to add some to 
the database.

After any data with calling post method, the model object refresh the http://localhost:8080/books endpoint on 
web brower.
