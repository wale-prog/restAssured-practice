package Workflow;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class Test_Get {

    @Test
    public void test01() {
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .log().all()
                .body("data.id.size", equalTo(6))
                .body("data.first_name", hasItems("Tobias", "Lindsay"));
    }
}
