https://docs.google.com/document/d/1bMKnUCmPoITo6nlPKFVF4pHPB_T4ngqM8uwayxouFBE/edit
MAMPANG PROJECT
Inspired by project Jakarta Validation, Mampang Validation can be an add on for your spring boot application enabling consistent response for your spring boot endpoints.

Features:
Automatic Error Response Exception Handler
Authorization null Checking with error message
@Requestbody null checking with error message
@Requestbody null checking for every field with error message
Invalid URL endpoint with message
Response Generator
Webclient Component, refactor Spring Webflux, enable webclient call with simplified syntax, like webclient.post(url, reqbody, token)

Basic Concepts:
All the response generated will be based on this following class
   public class MampangApiResponse {
    private Object data;
    private String rc;
    private String rd;
   }


Usage:
pom.xml
   <dependency>
	…
     <groupId>org.projectmampang</groupId>
     <artifactId>mampang</artifactId>
     <version>1.0.4</version>
   </dependency>


Example Usage:
For Example purpose, we are going to make a simple application with the requestbody of Person class
PersonRequest.java
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequest {
 private String name;
 private String hobby;
}

PersonController.java initial setup:
@RestController
@RequestMapping("/person")
public class PersonController {


   //CONTROLLERS…
}

This is the full example code
FULL Example 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.testing.test_mampang.model.Person;
import com.testing.test_mampang.request.PersonRequest;


import mampang.validation.annotation.JsAuthorization.JsAuthorization;
import mampang.validation.annotation.JsRequestBodyValidation.JsRequestBodyValidation;
import mampang.validation.component.JsResponseGenerator;
import mampang.validation.dto.MampangApiResponse;


@RestController
@RequestMapping("/person")
public class PersonController {


   @Autowired
   private JsResponseGenerator jsr;


   @GetMapping("/get")
   public ResponseEntity<MampangApiResponse> getPerson() {
       Person result = new Person("DummyPerson", "pingpong");
       return jsr.success(result, "00", "SUCCESS GET PERSON");
   }


   @GetMapping("/get/auth")
   @JsAuthorization
   public ResponseEntity<MampangApiResponse> getPersonAuth() {
       Person result = new Person("DummyPerson", "pingpong");
       return jsr.success(result, "00", "SUCCESS GET PERSON");
   }


   @PostMapping("/post")
   @JsRequestBodyValidation
   public ResponseEntity<MampangApiResponse> postPerson(@RequestBody PersonRequest request) {
       return jsr.success(request, "00", "SUCCESS GET PERSON");
   }


   @PostMapping("/post/auth")
   @JsRequestBodyValidation
   @JsAuthorization
   public ResponseEntity<MampangApiResponse> getTestAuth(@RequestBody PersonRequest request) {
       return jsr.success(request, "00", "SUCCESS GET PERSON");
   }
}



@JsAuthorization
this annotation will validate the null “Authorization” in the header
Case 1 Request with Header “Authorization”
Request:
curl --location 'localhost:8080/person/get' \
--header 'Authorization: 111111' \
--data ''
Response:


Case 2 Request without header “” No Header:
Request:
curl --location 'localhost:8080/person/get/auth' \
--data ''
Response:



@JsRequestBodyValidation
this annotation will validate request body, and return an error message whenever value inside request body is null, in this example we will use the Person.java class as the requestbody
Case 1:
Request With Complete Body:
curl --location 'localhost:8080/person/post' \
--header 'Authorization: 111111' \
--header 'Content-Type: application/json' \
--data '{
   "name": "john",
   "hobby": "pingpong"
}'

Response:

Case 2:
Request With Uncomplete Body:
curl --location 'localhost:8080/person/post' \
--header 'Authorization: 111111' \
--header 'Content-Type: application/json' \
--data '{
   "hobby": "pingpong"
}'

Response:

Case 3:
Request With No Body:
curl --location --request POST 'localhost:8080/person/post' \
--header 'Authorization: 111111' \
--data ''

Response:


