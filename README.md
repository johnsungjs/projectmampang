# MAMPANG PROJECT

Inspired by project Jakarta Validation, Mampang Validation is an add on for your spring boot application enabling consistent standardized response for your endpoints.

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
     <id>github</id>
     <url>https://mvn.pkg.github/johnsungjs/projectmampang</url>
     <snapshots>
       <enabled>true</enabled>
     </snapshots>
   </repositories>


   <dependency>
	…
     <groupId>org.projectmampang</groupId>
     <artifactId>mampang</artifactId>
     <version>1.0.4</version>
   </dependency>

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
COPY FULL CODE HERE
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
