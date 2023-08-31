package Workflow;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Test_Post {

    @Test
    public void test_post() {
//        Map<String, Object> userData = new HashMap<>();
//        userData.put("Name", "Olawale");
//        userData.put("Job", "Test Automation Engineer");
//        System.out.println(userData);
        JSONObject request = new JSONObject();
        request.put("Name", "Olawale");
        request.put("Job", "Test Automation Engineer");
        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .log().body();
    }
}
