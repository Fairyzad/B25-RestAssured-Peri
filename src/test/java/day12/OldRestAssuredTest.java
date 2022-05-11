package day12;

import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import utilities.SpartanNewBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class OldRestAssuredTest extends SpartanNewBase {
    @Test
    public void getAllSpartan(){
        given().accept(ContentType.JSON)
                .and().auth().basic("admin","admin")
                .log().all()
                .when().get("/spartans")
                .then().statusCode(200)
                .contentType(ContentType.JSON)
                .and().body("id[0]",is(8))
                .log().all();

    }

    @Test
    public void getAllSpartanOldWay(){
        given().accept(ContentType.JSON).and().auth().basic("admin","admin")
                .log().all()
                .expect().statusCode(200)
                .and().contentType(ContentType.JSON)
                .body("id[0]",is(10))
                .body("id[1]",is(150))
                .logDetail(LogDetail.ALL)
                .when().get("/spartans");

    }
}
