import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    // NOT: Github'da target dosyasi ile ilgili cakismalari onlemek icin 2 yol vardir.
    // 1=> Terminalde mvn clean komutu target'i temizler
    // 2=> Target dosyasini git ignore yapariz
    @Test
    public void test01() {
        String url = "-";
        Response response = given().when().get(url);
        //given().when().get(url); => End point'e gondermek icin request olusturmus olduk.
        // Response response => API tarafindan dondurulen response (cevap)

        //Response response=given().auth().basic("user","password").when().get(url);
        // Basic aut ile request gondermek
        response.prettyPrint(); //Response'daki body'i yazdirir
        // response.prettyPeek(); // response'daki her seyi yazdirir (Header'i da yazdirir)
        //response.peek(); // prettyPeek() gibi her seyi getiri ancak body'yi String olarak yan yana yazdirir.


    }
}
