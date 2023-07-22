package ApiTest;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import ApiEndpoints.UserEndPoints;

import ApiPayload.User;

import io.restassured.response.Response;

import org.junit.Assert;


public class UserTest {

    Faker faker;
    User userPayload;

    @BeforeClass
    public void setupData()
    {

        faker = new Faker();

        userPayload = new User();

        /* truy xuất từ ApiPayLoad.User */

        userPayload.setId(faker.idNumber().hashCode());

        userPayload.setUsername(faker.name().username());

        userPayload.setFirstName(faker.name().firstName());

        userPayload.setLastName(faker.name().lastName());

        userPayload.setEmail(faker.internet().safeEmailAddress());

        userPayload.setPassword(faker.internet().password(5, 10));
        
        userPayload.setPhone(faker.phoneNumber().cellPhone());
        
    }

    

    @Test(priority = 1)
    public void testPostUser(){

        /* truy xuất từ UserEndPoints.CreateUser*/

        Response response = UserEndPoints.createUser(userPayload);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

        
    }

    @Test(priority = 2)
    public void testGetUserByName(){

        /* truy xuất từ UserEndPoints.ReadUser*/

        Response response = UserEndPoints.readUser(this.userPayload.getUsername());

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);



    }
    
}
