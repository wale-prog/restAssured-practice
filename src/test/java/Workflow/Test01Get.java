package Workflow;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Test01Get {

    @Test(priority = 1)
    void Tc01() {
        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.statusLine());
        System.out.println(response.getHeader("content-Type"));
        System.out.println(response.getTime());
    }
    @Test(priority = 2)
    public void TC02() {
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[0]", equalTo(7));
    }
}
