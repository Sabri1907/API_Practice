package utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {
        /*
    public static void main(String[] args) {
        String guncelToken=generateToken();
        System.out.println("guncelToken = " + guncelToken);
    }
    */

    public static String generateToken(){

        String username="Batch81";
        String password="Batch81+";
        /*
        {
            "password": "string",
            "rememberMe": true,
            "username": "string"
}        }
        NOT=> bu yapiyi swegger/API dokumanindan authentication bolumunden aldik
         */

        Map<String, Object> postBody=new HashMap<>();
        postBody.put("username",username);
        postBody.put("password",password);
        postBody.put("rememberMe",true);

        String endPoint="https://www.gmibank.com/api/authenticate";
        Response response= given().contentType(ContentType.JSON).body(postBody).when().post(endPoint);
        // Postman'de body icinde yaptigimiz post islemini burda body() methoduyla yapiyoruz.
        // Ve Json formatina yakin oldugu icin map ile yaptik.
        // Ancak serialization hatasi verdi, bu hatayi gidermek icin pm.xml'eilgili Dependency'leri (Gson)
        // ekledik.

        JsonPath token=response.jsonPath();
        return token.getString("id_token");

    }
}
