package reqres.users.get;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestGET {

    File usersSchema = new File("C:\\projects\\qa31-api-test\\src\\test\\resources\\gederizeSchema.json");

    @Test
    public void testStatusCode() {
        given()
                .get("https://reqres.in/api/users")
                .then().statusCode(200);
    }

    @Test
    public void testScheme() {
        given()
                .get("https://reqres.in/api/users")
                .then()
                .body(JsonSchemaValidator.matchesJsonSchema(usersSchema));
    }

    @Test
    public void testNonExistingPage() {
        given()
                .param("page", -10)
                .get("https://reqres.in/api/users")
                .then()
                .body("data", emptyArray());
    }
}
