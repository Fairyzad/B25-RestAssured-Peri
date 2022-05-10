package day12;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class CvsFileSourceParameterizedTest {

    /*
    // Write a parameterized test for this request
    // Get the data from csv source
    // GET https://api.zippopotam.us/us/{state}/{city}

     */

    @ParameterizedTest
    @CsvFileSource(resources = "/zipcode.csv",numLinesToSkip = 1) //skip the 1st line-header
    public void zipCodeTestWithFile(String stateArg,String cityArg,int zipCountArg){

        System.out.println("state = " + stateArg);
        System.out.println("city = " + cityArg);
        System.out.println("zipCount = " + zipCountArg);

    }



}
