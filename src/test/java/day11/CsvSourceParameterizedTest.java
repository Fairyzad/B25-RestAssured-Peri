package day11;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class CsvSourceParameterizedTest {

    //The difference between CSV and XLS file formats is that CSV format is a plain text format
    // in which values are separated by commas (Comma Separated Values), while XLS file format
    // is an Excel Sheets binary file format which holds information about all the worksheets
    // in a file, including both content and formatting.

    //Test first number + second number = third number
    //1,3,4
    //2,3,5
    //8,7,15
    //10,9,19

    @ParameterizedTest
    @CsvSource({"1, 3 , 4",
            "2, 3 , 5",
            "8, 7 , 15",
            "10, 9 , 19"})
    public void testAddition(int num1,int num2,int sum){

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("sum = " + sum);

        MatcherAssert.assertThat(num1+num2,Matchers.equalTo(sum));
    }

    // Write a parameterized test for this request
    // GET https://api.zippopotam.us/us/{state}/{city}
    /*
        "NY, New York",
        "CO, Denver",
        "VA, Fairfax",
        "VA, Arlington",
        "MA, Boston",
        "NY, New York",
        "MD, Annapolis"
     */
    //verify place name contains your city name
    //print number of places for each request

    @ParameterizedTest
    @CsvSource({ "NY, New York",
            "CO, Denver",
            "VA, Fairfax",
            "VA, Arlington",
            "MA, Boston",
            "NY, New York",
            "MD, Annapolis"})
    public void zipCodeTest(String state,String city){

        System.out.println("state = " + state);
        System.out.println("city = " + city);

        int placeNumber = given()
                .baseUri("https://api.zippopotam.us")
                .accept(ContentType.JSON)
                .pathParam("state",state)
                .and()
                .pathParam("city",city)
                .when().get("/us/{state}/{city}")
                .then()
                .statusCode(200)
                .and()
                .body("places.'place name'",everyItem(containsStringIgnoringCase(city)))
                .extract().jsonPath().getList("places").size();

        System.out.println("placeNumber = " + placeNumber);


    }




}
