import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest {




    @Test
    public void testResponse() {
        File genderizeScheme = new File("C:\\Users\\std\\IdeaProjects\\ApiTesting\\src\\test\\resources\\gederizeSchema.json");
        given()
                .when()
                .get("https://api.genderize.io?name=peter")
                .then().statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(genderizeScheme));



    }


}
