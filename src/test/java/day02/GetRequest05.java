package day02;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest05 {
    @Test
    public void test05(){

        // Token girmemiz gereken yerde Token Alma

        String url="https://www.gmibank.com/api/tp-customers";
        String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRjaDgxIiwiYXV0aCI6IlJPTEVfQURNSU4iLCJleHAiOjE2NzAwMDUwMTV9." +
                "aBi3YiMtAFXREMOJuCyBe0FSPydJ8RWyvyLc9oob39DRPTh3D4SlDToRVcmw-vjdX_o0qGgKpTwe54AhBStW3A";
        Response response=given().headers("Authorization", "Bearer " + token).when().get(url);
        response.prettyPrint();



    }

}
