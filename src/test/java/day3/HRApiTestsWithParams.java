package day3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.HRTestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HRApiTestsWithParams extends HRTestBase {
    @Test
    public void test1(){
       Response response = RestAssured.get("/regions");

       response.prettyPrint();

    }
    /*
        Given accept type is Json
        And parameters: q = {"region_id":2}
        When users sends a GET request to "/countries"
        Then status code is 200
        And Content type is application/json
        And Payload should contain "United States of America"
     */
    @DisplayName("GET the query reque")
    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("q","{\"region_id\":2}")
                .log().all()
                .when().get("\"/countries\"");

        // verify  Then status code is 200
        Assertions.assertEquals(200,response.statusCode());

        //And verify Content type is application/json
        Assertions.assertEquals("application/json",response.contentType());

        //  verify Payload should contain "United States of America"
        Assertions.assertTrue(response.body().asString().contains("United States of America"));

    }


     /*
        Send a GET request to employees and get only employees who works as a IT_PROG
         */

    @Test
    public void test3(){
        Response response = RestAssured.given().accept(ContentType.JSON)
               .and().queryParam("q","{\"job_id\":\"IT_PROG\"}")
                .when().get("/employees");

        response.prettyPrint();

        List<String> AllJobID = response.path("items.job_id");

        for(String eachJobID: AllJobID){
            assertEquals("IT_PROG", eachJobID);
        }


    }



}
