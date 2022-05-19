package day3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.SpartanTestBase;

public class SpartanTestsWithParameters extends SpartanTestBase {

     /*   Given accept type is Json
          And Id parameter value is 5. ( in postman we write api/spartans/:id)
          When user sends GET request to /api/spartans/{id}
          Then response status code should be 200
          And response content-type: application/json
          And "Blythe" should be in response payload (body)
       */

    @Test
    @DisplayName("GET request to api/spartans{id} with ID 5")
    public void paramTest(){

       Response response = RestAssured.given().accept(ContentType.JSON).
                and().pathParam("id",5)
               .when().get("/api/spartans/{id}"); // {id} should match parameter name

       // verify status code should be 200
        Assertions.assertEquals(200,response.statusCode());

        // verify content-type: application/json
        Assertions.assertEquals("application/json",response.contentType());

        // And Verify "Blythe" should be in response payload
        Assertions.assertTrue(response.body().asString().contains("Blythe"));

    }

      /*
        TASK
        Given accept type is Json
        And Id parameter value is 500
        When user sends GET request to /api/spartans/{id}
        Then response status code should be 404
        And response content-type: application/json
        And "Not Found" message should be in response payload
     */


    @Test
    public void paramTest2(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id",500).get(" /api/spartans/{id}");

       Assertions.assertEquals(404,response.statusCode());

        Assertions.assertEquals("application/json",response.contentType());
        // Or Assertions.assertEquals("application/json",response.header(name:contentType);

      Assertions.assertTrue(response.body().asString().contains("Not Found"));
      // or  Assertions.assertEquals(expected:true, response.body().asString().contains("Not Found"));

      response.prettyPrint();

    }
     /*
        Given accept type is Json
        And query parameter values are:
        gender|Female
        nameContains|e
        When user sends GET request to /api/spartans/search
        Then response status code should be 200
        And response content-type: application/json
        And "Female" should be in response payload
        And "Janette" should be in response payload
     */

    @Test
    public void paramsTest(){
       Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("gender","Female")
                .and().queryParam("nameContains","e")
                .when().get("/api/spartans/search");

       Assertions.assertEquals(200,response.statusCode());

       Assertions.assertEquals("application/json",response.contentType());
      // Assertions.assertEquals("application/json",response.header("content-type")); use Header method

       Assertions.assertTrue(response.body().asString().contains("Female"));

       Assertions.assertTrue(response.body().asString().contains("Janette"));


    }

     /*
        TASK
        Given accept type is Json
        And Id parameter value is 500
        When user sends GET request to /api/spartans/{id}
        Then response status code should be 404
        And response content-type: application/json
        And "Not Found" message should be in response payload
     */
    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id",500)
                .log().all()
                .when().get("/api/spartans/{id}");

        Assertions.assertEquals(404,response.statusCode());

        Assertions.assertEquals("application/json",response.contentType());
        // Assertions.assertEquals("application/json",response.header("content-type")); use Header method

        Assertions.assertTrue(response.body().asString().contains("Not Found"));

    }

      /*   Given accept type is Json
          And Id parameter value is 5
          When user sends GET request to /api/spartans/{id}
          Then response status code should be 200
          And response content-type: application/json
          And "Blythe" should be in response payload(body)
       */

 @Test
    public void test3(){
     Response response = RestAssured.given().accept(ContentType.JSON)
             .and().pathParam("id",5)
             .when().get("/api/spartans/{id}");

     Assertions.assertEquals(200,response.statusCode());

     Assertions.assertEquals("application/json",response.contentType());
     // Assertions.assertEquals("application/json",response.header("content-type")); use Header method

     Assertions.assertTrue(response.body().asString().contains("Blythe"));

 }



}
