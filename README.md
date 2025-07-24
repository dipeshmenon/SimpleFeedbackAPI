# Simple Feedback API
### Tech Stack:
- Java 24
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- JUnit + Mockito
- Tested using cURL, Postman and Insomnia

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
- Insomnia and Postman: POST `http://localhost:8080/feedback` `{
  "name": "ABC XYZ",
  "email": "abc.xyz@mail.com",
  "message": "Positive feedback"
  }`
---
- GET /feedback
- Sample Request: `curl http://localhost:8080/feedback`
- Insomnia and Postman: GET `http://localhost:8080/feedback`
 


### Unit test case

- To run the unit tests: `mvn test`
- There are two unit test cases. 
- The first test case tests the saving of the feedback.
- The second test case tests if the entered feedback follows the validation rules. 
- The rules are: name-required - minimum 3 characters, email-required - valid email format and feedback message-required - minimum 10 characters.
- The first test (TestFeedbackService) should succeed and the second test (TestFeedbackInvalid) should fail.