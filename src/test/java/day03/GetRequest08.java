package day03;

import io.restassured.response.Response;
import org.junit.Test;
import utilities.GMIBankBaseUrl;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest08 extends GMIBankBaseUrl {
    /*
          http://www.gmibank.com/api/tp-customers/43703

          "firstName": "Alda",
          "lastName": "Monahan",
          "middleInitial": "Nichelle Hermann Kohler",
          "email": "com.github.javafaker.Name@7c011174@gmail.com",
          "mobilePhoneNumber": "909-162-8114",
          "city": "St Louis",
          "ssn": "108-53-6655"

          1) MATCHERS CLASS
          2) JSON PATH
          3) De-Serialization
    */
// NOT: http://www.gmibank.com/api/tp-customers?size=2000 : Postman'de ilgili sayfada 2000 adet kayit verir
    @Test
    public void test08(){
        // 1=> Set the Url
        spec01.pathParams("first","tp-customers","second",43703);

        // 2=> Set the Expected Data
        Map<String,Object> expectedData= new HashMap<>();
        expectedData.put("firstName", "Alda");
        expectedData.put("lastName", "Monahan");
        expectedData.put("middleInitial", "Nichelle Hermann Kohler");
        expectedData.put("email", "com.github.javafaker.Name@7c011174@gmail.com");
        expectedData.put("mobilePhoneNumber", "909-162-8114");
        expectedData.put("city", "St Louis");
        expectedData.put("ssn", "108-53-6655");
        System.out.println("expectedData = " + expectedData);

        // 3=> Send the Request and Get the Response
        Response response=given().spec(spec01).headers("Authorization","Bearer "+generateToken()).get("/{first}/{second}");
        //response.prettyPrint();

        // 4. Do Assertion
        // => De-Serialaziation ile Dogrulama
        Map<String,Object> actualData=response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.get("firstName"),actualData.get("firstName"));
        assertEquals(expectedData.get("lastName"),actualData.get("lastName"));
        assertEquals(expectedData.get("middleInitial"),actualData.get("middleInitial"));
        assertEquals(expectedData.get("email"),actualData.get("email"));
        assertEquals(expectedData.get("mobilePhoneNumber"),actualData.get("mobilePhoneNumber"));
        assertEquals(expectedData.get("city"),actualData.get("city"));
        assertEquals(expectedData.get("ssn"),actualData.get("ssn"));




    }





}
