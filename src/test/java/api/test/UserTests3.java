package api.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;


import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.github.javafaker.Faker;

import api.endpoints.Routes;
import api.endpoints.UserEndPoints3;
import api.payload.User2;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserTests3 {
	//Faker faker;
	//User userPayload;
	List<User2> users = new ArrayList<>();
	User2 user1, user2, user3;
	public Logger logger; //create a variable for logs
	
	
	@BeforeClass
	public void init() {
		// Create a list of users
        //List<User2> users = new ArrayList<>();

        // Create user 1
        User2 user1 = new User2();
        user1.setId(0);
        user1.setUsername("string1");
        user1.setFirstName("string2");
        user1.setLastName("string3");
        user1.setEmail("string4");
        user1.setPassword("string5");
        user1.setPhone("string6");
        user1.setUserStatus(0);

        // Create user 2
        User2 user2 = new User2();
        user2.setId(1);
        user2.setUsername("string11");
        user2.setFirstName("string21");
        user2.setLastName("string31");
        user2.setEmail("string41");
        user2.setPassword("string51");
        user2.setPhone("string61");
        user2.setUserStatus(0);

        // Create user 3
        User2 user3 = new User2();
        user3.setId(2);
        user3.setUsername("string21");
        user3.setFirstName("string22");
        user3.setLastName("string23");
        user3.setEmail("string24");
        user3.setPassword("string25");
        user3.setPhone("string26");
        user3.setUserStatus(0);

        // Add users to the list
        users.add(user1);
        users.add(user2);
        users.add(user3);
		
		//logs
		logger = LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority = 1)
	public void TestPostUserWithArray() {		

		       /* // Create a list of users
		        List<User2> users = new ArrayList<>();

		        // Create user 1
		        User2 user1 = new User2();
		        user1.setId(0);
		        user1.setUsername("string1");
		        user1.setFirstName("string2");
		        user1.setLastName("string3");
		        user1.setEmail("string4");
		        user1.setPassword("string5");
		        user1.setPhone("string6");
		        user1.setUserStatus(0);

		        // Create user 2
		        User2 user2 = new User2();
		        user2.setId(1);
		        user2.setUsername("string11");
		        user2.setFirstName("string21");
		        user2.setLastName("string31");
		        user2.setEmail("string41");
		        user2.setPassword("string51");
		        user2.setPhone("string61");
		        user2.setUserStatus(0);

		        // Create user 3
		        User2 user3 = new User2();
		        user3.setId(2);
		        user3.setUsername("string21");
		        user3.setFirstName("string22");
		        user3.setLastName("string23");
		        user3.setEmail("string24");
		        user3.setPassword("string25");
		        user3.setPhone("string26");
		        user3.setUserStatus(0);

		        // Add users to the list
		        users.add(user1);
		        users.add(user2);
		        users.add(user3);*/

		      /*  // Define the base URI
		       // RestAssured.baseURI = Routes.BASE_URL;

		        // Send the POST request
		        Response response = RestAssured.given()
		                .contentType(ContentType.JSON)
		                .body(users)
		                .post(Routes.CREATE_USER_WITH_ARRAY);

		        // Print the response body
		        System.out.println("Response Body is: " + response.getBody().asString());

		        // Verify the response status code
		        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");

		        // Verify the response content type
		        Assert.assertEquals(response.getContentType(), "application/json", "Expected content type is application/json");
		    }
		}*/
		//logger = LogManager.getLogger(this.getClass());
		logger.info("**************Creating User **************");	
		Response res = UserEndPoints3.createUserWithList(users);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		System.out.println("Create List Of Users Response Body is: " + res.getBody().asString());
		
		logger.info("**************User is Created **************");
	}
	
	@Test(priority = 2)
	public void TestGetListUserByName() {
		logger.info("**************Reading User Name **************");
		System.out.println("Username = " + this.users.getFirst().getUsername());
		System.out.println("Username uuuu = " + this.users.get(2).getUsername());
	
		for (int i = 0; i< users.size(); i++) {
			Response res = UserEndPoints3.readUser(this.users.get(i).getUsername());
			res.then().log().all();
			res.statusCode();
			Assert.assertEquals(res.getStatusCode(), 200);
			System.out.println("Get Call Response Body is: " + res.getBody().asString());
		}
		logger.info("**************User Info is displayed **************");
	}
	
	/*@Test(priority = 3)
	public void TestUpdateByUserName() {
		
		//update Data using payload
		logger.info("**************Updating User **************");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response res = UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		res.then().log().all();
		res.then().log().body().statusCode(200);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//Checking data after update		
		Response respafterupdate = UserEndPoints.readUser(this.userPayload.getUsername());
		respafterupdate.then().log().all();
		respafterupdate.statusCode();
		Assert.assertEquals(respafterupdate.getStatusCode(), 200);
		logger.info("**************User is Updated **************");
	}
	
	@Test(priority = 4)
	public void TestDeleteByUserName() {
		logger.info("**************Deleting User **************");
		Response res = UserEndPoints.deleteUser(this.userPayload.getUsername());
		res.then().log().all();
		res.statusCode();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("**************User is Deleted **************");
	}*/
	
}
