package day3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.HRTestBase;

import java.util.List;

public class HRApiWithPath extends HRTestBase {

  /*  Query Parameters
             -> It is NOT part of url and passed in key+value format
 Path Parameters
            -
    Is a part of URL and followed by the end of full resource url.
   */
    @DisplayName("Get request to countries with Path method")
    @Test
    public void test1(){
        Response response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .and().queryParam("q","{\"region_id\":2}")
                .when()
                .get("/countries");

      //response.prettyPrint();
      //print limit result
      System.out.println(response.path("limit").toString());
      //print hasMore
      System.out.println(response.path("hasMore").toString());
      //print second country id
      System.out.println(response.path("items[1].country_id").toString());
      //print 4th element country name
      System.out.println(response.path("items[3].country_name").toString());

      //get me all country names
      List<String> countryNames= response.path("items.country_name");
      System.out.println(countryNames);

      //assert that in the response all region_ids are 2
      //save all the regions ids inside the list
      List<Integer>  allRegionsIDs = response.path("items.region_id");

      //assert one by one that they are equal to 2
      for (Integer regionsID : allRegionsIDs) {
        Assertions.assertEquals(2,regionsID);
      }
    }

    /*
        send a GET request o employees endpoint, filter only Job_id IT_PROG
        then assert that all job_ids are IT_PROG
     */

  @Test
  public void test2(){
    Response response = RestAssured.given().accept(ContentType.JSON)
            .and().queryParam("q","{\"job_id\":\"IT_PROG\"}")
            .when().get("/employees");

    Assertions.assertEquals(200,response.statusCode());

    //assert all the job id are IT_PROG
    List<String> allJobIDs = response.path("items.job_id");

    //verify each of them is IT_PROG
    for(String each : allJobIDs){
      Assertions.assertEquals("IT_PROG",each);
    }

  }
}
