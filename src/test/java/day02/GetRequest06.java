package day02;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.Authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest06 extends Authentication {
    @Test
    public void test06(){
        String url="https://www.gmibank.com/api/tp-customers/114351";

        Response response=given().headers("Authorization","Bearer "+ generateToken()).when().get(url);

        /*Postman'de oldugu gibi token kullanilmasi gereken yerde token'i kullanmak icin "Headers"'in altinda
        "Authorization" kisminda "Bearer"'in altina ekledik. Ve Authentication class'inda olusturdugumuz
        generateToken methodunun cagirarak her defasinda uzun uzun token olusturmak zorunda kalmnadik.
        */
        response.prettyPrint();

        // Matcher Class ile nusteri bilgilerini dogrulayin
        response.then().assertThat().body("firstName",equalTo("Della")
                                            ,"lastName",equalTo("Heaney")
                                            ,"email",equalTo("ricardo.larkin@yahoo.com")
                                            ,"mobilePhoneNumber",equalTo("123-456-7893")
                                            ,"accounts[0].balance",equalTo(11190)
                                            ,"accounts[0].accountType",equalTo("CHECKING")
                                            ,"accounts[1].balance",equalTo(69700)
                                            ,"accounts[1].accountType",equalTo("CREDIT_CARD"));

/*
        // JsonPath ile musteri bilgilerini dogrulayin
        JsonPath json = response.jsonPath();
        assertEquals("Della", json.getString("firstName"));
        assertEquals("Heaney", json.getString("lastName"));
        assertEquals("ricardo.larkin@yahoo.com", json.getString("email"));
        assertEquals("123-456-7893", json.getString("mobilePhoneNumber"));
        assertEquals(11190, json.getInt("accounts[0].balance"));
        assertEquals("CHECKING", json.getString("accounts[0].accountType"));
        assertEquals(69700, json.getInt("accounts[1].balance"));
        assertEquals("CREDIT_CARD", json.getString("accounts[1].accountType"));

 */
    }
}
