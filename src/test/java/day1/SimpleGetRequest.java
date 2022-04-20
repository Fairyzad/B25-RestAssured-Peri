package day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleGetRequest {

    String url = "http://44.201.121.105:8000/api/spartans";

    @Test
    public void test1(){

        //send a get request and save response inside the Response object
        /*
        Testing and validating REST services in Java is harder than in dynamic languages such as Ruby and Groovy.
        REST Assured brings the simplicity of using these languages into the Java domain.
        For example, if your HTTP server returns the following JSON at “http://localhost:8080/lotto/{id}”:
        You can easily use REST Assured to validate interesting things from the response:
         */

       Response response = RestAssured.get(url);

        //print response status code
        System.out.println("response.statusCode() = " + response.statusCode());


        //print response body
        response.prettyPrint();


        //verify status code is 200
        Assertions.assertEquals(200,response.statusCode());


    }
}
