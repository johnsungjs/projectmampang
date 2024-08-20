# THE MAMPANG PROJECT

Inspired by [The Apache Jakarta Project](https://jakarta.apache.org/), I think it would be fun to create a project with the name inspired by the area in Jakarta and let me introduce to you, The Mampang Project.

## What Problem I am trying to solve?

I am originally a front end developer, and it gets really frustrating for me whenever the backend developers give inconsistent responses.
Until one day I got assigned to a backend project, and i realized in order to gives consistent responses, I have to code with this following pattern:

```java
 @PostMapping("/posts")
 public ResponseEntity<ApiResponse> postData(@RequestBody RequestEntity
 request) {
   try {
     return service.postSomething()
   } catch (Exception e) {
     log.info("EXCEPTION: " + e.getMessage());
     return ResponseEntity
       .status(HttpStatus.INTERNAL_SERVER_ERROR)
       .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
       .body(new ApiResponse(myErrorResponse));
   }
 }
```

The more endpoints I made, the more tedious it is to repeat the same task over and over.
Until one day I got an idea to create a custom annotation to handle authorization, those idea leads me to create a full package that handle the exception by giving a consistent response.

## Minimum Requirements

- Java 17 or higher
- Spring Boot version 3.3.2 or higher

## Features:

- Automatic Error Response Exception Handler
- Authorization null Checking with error message
- @Requestbody null checking with error message
- @Requestbody null checking for every field with error message
  Invalid URL endpoint with message
  Response Generator
- Webclient Component, refactor Spring Webflux, enable webclient call with simplified syntax, like webclient.post(url, reqbody, token)
- Response Generator Component, simplified return of ResponseEntity

## Basic Concept:

All the response generated will be based on this following class

```java
   public class MampangApiResponse {
    private Object data;
    private String rc;
    private String rd;
   }

```

## Installation

Inside your pom.xml:

```xml
  <repositories>
    <repository>
      <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
   </repository>
	</repositories>


   <dependencies>
	…
   <dependency>
      <groupId>com.github.johnsungjs</groupId>
      <artifactId>projectmampang</artifactId>
      <version>1.0.6</version>
   </dependency>
  </dependencies>

```

## Full Example Usage

For Example purpose, we are going to make a simple application with the requestbody of PersonRequest class

##### PersonRequest.java

```java
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequest {
 private String name;
 private String hobby;
}
```

##### PersonController.java

```java
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

```

## In Depth Explanation

### @JsAuthorization

this annotation will validate the null “Authorization” in the header

#### Case 1: Request with Header “Authorization”

##### Request:

```c
curl --location 'localhost:8080/person/get/auth' \
--header 'Authorization: 111111' \
--data ''
```

##### Response:

```json
{
  "data": {
    "name": "DummyPerson",
    "hobby": "pingpong"
  },
  "rc": "00",
  "rd": "SUCCESS GET PERSON"
}
```

#### Case 2: Request without Header “Authorization”

##### Request:

```c
curl --location 'localhost:8080/person/get/auth' \
--data ''
```

##### Response:

```json
{
  "data": null,
  "rc": "01",
  "rd": "AUTHORIZATION MUST NOT BE NULL"
}
```

### @JsRequestBodyValidation

This annotation will validate request body and return error message whenever value inside request body is null, in this example we will use the PersonRequest.java class as the requestbody.

#### Case 1: Request With Complete Body

##### Request:

```c
curl --location 'localhost:8080/person/post' \
--header 'Authorization: 111111' \
--header 'Content-Type: application/json' \
--data '{
   "name": "john",
   "hobby": "pingpong"
}'
```

##### Response:

```json
{
  "data": {
    "name": "john",
    "hobby": "pingpong"
  },
  "rc": "00",
  "rd": "SUCCESS GET PERSON"
}
```

#### Case 2: Request With Uncomplete Body:

```c
curl --location 'localhost:8080/person/post' \
--header 'Authorization: 111111' \
--header 'Content-Type: application/json' \
--data '{
   "hobby": "pingpong"
}'
```

##### Response:

```json
{
  "data": null,
  "rc": "02",
  "rd": "NULL VALUE IN THIS FOLLOWING FIELD => name"
}
```

#### Case 3: Request Without body payload:

```c
curl --location --request POST 'localhost:8080/person/post' \
--header 'Authorization: 111111' \
--data ''
```

##### Response:

```json
{
  "data": null,
  "rc": "98",
  "rd": "BAD REQUEST, POSSIBILITY NULL REQUEST BODY OR NULL REQUEST PARAM"
}
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

## Further Question

If you have any question, feel free to dm me via [linkedin](https://linkedin.com/in/johnsungjs).

## License

[MIT License Copyright (c) 2024 John Sung
](https://github.com/johnsungjs/projectmampang/tree/main?tab=MIT-1-ov-file)
