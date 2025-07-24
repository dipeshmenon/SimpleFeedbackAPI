# Simple Feedback API
### Tech Stack:
- Java 24
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- JUnit + Mockito
- Tested using cURL and Postman

### How to run the project:
1. Make sure PostgreSQL is installed and running
2. Create a database named "feedback" within your PostgreSQL
3. Update the application.properties with your PostgreSQL credentials
4. Run the application with `mvn spring-boot:run`

The APIs will be available at http://localhost:8080.

### API Endpoints

Submit feedback:


- POST /feedback
- Sample Request: `curl -X POST http://localhost:8080/feedback   -H "Content-Type: application/json"   -d '{"name": "ABC", "email": "abc.xyz@mail.com", "message": "Positive feedback"}'`
---
- GET /feedback
- Sample Request: `curl http://localhost:8080/feedback`
 


### Unit test case

- To run the unit tests: `mvn test`
- There are two unit test cases. One that tests the saving of the feedback and the other that tests for validation errors.
- The first test (saveFeedbackTest) should succeed and the second test (invalidFeedback) should fail.