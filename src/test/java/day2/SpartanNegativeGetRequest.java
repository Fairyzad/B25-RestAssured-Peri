package day2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SpartanNegativeGetRequest {

    String url = "http://44.201.121.105:8000";

    /*
        Given Accept type is application/json
        When user send GET request to  /api/spartans end point
        Then status code must be 200
        And response content type must be application/json
     */

    @Test
    public void test1(){
       Response response = RestAssured.get(url);
    }

}
