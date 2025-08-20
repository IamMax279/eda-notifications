# Event Driven Notification System #

This is just a simple Spring Boot project that utilizes RabbitMQ and Resend API - when a user gets registered, a message is sent to the email service which then sends a confirmation email to the user.

>[!IMPORTANT]
>Before running the app, you must first fill in the missing fields in the docker-compose file and each service's application.properties file (e.g. postgres db credentials)

## Running the api ##
After completing the aforementioned instruction, just run:
```bash
docker-compose up --build
```
Then, to test the api functionality, you can use an HTTP client like Postman using this url:
```bash
http://localhost:8080/user/create-user
```
Remember to use the "Basic Auth" method, where Username=user and Password is whatever the user-service container generated (just check the logs)
