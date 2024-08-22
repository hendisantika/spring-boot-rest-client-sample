# spring-boot-rest-client-sample

Spring Framework 6.1-M2 has introduced a new Synchronous HTTP client. It has an infrastructure similar to Rest Template,
but is a fluent API and hence is similar to Web Client , but is Synchronous.

RestClient is a Fluent API and hence allows to have method chaining unlike RestTemplate. It is recommended to move from
RestTemplate to RestClient as per Spring Docs

Let's start by creating a Demo Project to dive into the features of Rest Client.

API Consumed:

https://jsonplaceholder.typicode.com/users

### Things todo list

1. Clone this repository: `git clone https://github.com/hendisantika/spring-boot-rest-client-sample.git`
2. Navigate to the folder: `cd spring-boot-rest-client-sample`
3. Run the application: `mvn clean spring-boot:run`
4. Open POSTMAN Collection file
5. Open your favorite browser: http://localhost:8080/api/v1/users

