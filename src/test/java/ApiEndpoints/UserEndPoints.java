package ApiEndpoints;



import static io.restassured.RestAssured.given;

import ApiPayload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/* Create for perform Create, Read, Update, Delete request the user API */

public class UserEndPoints {

    public static Response createUser(User payload)
    {
        /* Create users (Post): https://petstore.swagger.io/v2/user */

        Response response = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)

        .when()
            .post(Routers.post_url); /* truy xuất từ ApiEndPoints.Routers */

        return response;
    }

    public static Response readUser(String username)
    {

        Response response = given()
            .pathParam("username", username) /* Get users (Get): https://petstore.swagger.io/v2/user/{username} */

        .when()
            .get(Routers.get_url); /* truy xuất từ ApiEndPoints.Routers */

        return response;
    }

    public static Response updateUser(String username, User payload)
    {

        Response response = given()

            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .pathParam("username", username) /* Update users (PUT): https://petstore.swagger.io/v2/user/{username} */
            .body(payload)
            

        .when()
            .put(Routers.update_url); /* truy xuất từ ApiEndPoints.Routers */

        return response;
    }

    public static Response deleteUser(String username)
    {

        Response response = given()
            .pathParam("username", username) /* Delete users (Delete: https://petstore.swagger.io/v2/user/{username}) */

        .when()
            .delete(Routers.delete_url); /* truy xuất từ ApiEndPoints.Routers */

        return response;
    }
    
}
