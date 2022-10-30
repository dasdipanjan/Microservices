# Spring Boot Demo


This application demonstrate how can we quickly build restful webservice using **SpringBoot** . Following have been implemented in this application.

1. Basic Restful webservice using User model. For Reference go through HomeController.java and User.java file.
2. Implementation of **@RequestMapping**, **@GetMapping, @PathVariable,**  **@RequestParam** annotation.
3. Basic **CRUD** operation is implemented by taken Employee as an example. For Reference go through EmployeeController.java and Employee.java
4. **POST** method implementation to create Employee resource.
5. **GET** method implementation for Employee resource.
6. **GET** method implementation for Employee resource by employee id.
7. Specific Exception handling implementation (**404 resource not found**).
8. Generic Exception handling implementation for all resources.
9. **DELETE** method implementation to delete an Employee resource.
10. Content Negotiation implementation. Based on client need webservice will provide XML or JSON. JSON content is by default if nothing is customized.
11. Data filtering in restful webservice using **@JsonIgnore** or **@JsonIgnoreProperties**
12. Rest API Versioning.



# Content Negotiation


Content Negotiation is one good example of AOP in Spring Framework. Any method in rest controller can return response in form of JSON or XML or Html or some other type. But it may happen that we need the same method to return a response of different type depending on incoming request.

For example we have a Server application which return the list of employees. We are having 2 UI applications using the same server method to get the list of employees. But one requires xml and the other json. This is where content negotiation comes into picture. As name suggests it negotiates the response type based on the request.

This content negotiation can be achieved in following ways-

- **Using Path Extension -** In the request we specify the required response type using the extension like .json,.xml or .txt. This has the highest preference.

- **Using url parameter -** In the request we specify the required response type using the url parameter like format=xml or format=json. This has the second highest preference.

- **Using Accept Headers -** When making a request using HTTP we specify required response by setting the Accept header property. Its something like this

  ```java
  HttpHeaders headers = new HttpHeaders();
  headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
  ```



#### Example of Content Negotiation using URL Parameter

To implement content negotiation we need to write an implementation class of **WebMvcConfigurer** from <u>org.springframework.web.servlet.config.annotation package</u> Implementation class must be annotated with **@Configuration**

```java
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .favorParameter(true)
                .parameterName("mediaType")
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("json", MediaType.APPLICATION_JSON);
    }
}
```

##### Sample Rest URI:

http://localhost:8080/employees/2e0285e6-4b78-44df-9531-bec56a2640bf?mediaType=xml
