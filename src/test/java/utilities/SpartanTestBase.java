package utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class SpartanTestBase {


        //beforeAll is the same thing with beforeClass in testng
        @BeforeAll
        public static void init() {
            RestAssured.baseURI = "http://44.201.121.105:8000";

            String dburl = "jdbc:oracle:thin:@44.201.121.105:1521:XE";
            String dbUserName = "SP";
            String dbPassword = "SP";

            DButils.createConnection(dburl,dbUserName,dbPassword);
        }
        @AfterAll
    public static void close(){
            DButils.destroy();
        }

}
