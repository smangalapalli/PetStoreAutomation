package api.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints3;
import api.payload.User;
import api.payload.User2;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;		
	User userPayload, user1, user2, user3, user_a1, user_a2, user_a3;  //Create User Objects	
	List<User> users = new ArrayList<>();  // Create a List of User Object	
    User[] userarray = new User[3];  // Create an array of User Object    
	public Logger logger; //create a variable for logs
	
	
	@BeforeClass
	public void setup() {
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//set up User list
		// Create a list of users
	    //List<User> users = new ArrayList<>();

        // Create user 1
		faker = new Faker();
        User user1 = new User();
        user1.setId(faker.idNumber().hashCode());
        user1.setUsername(faker.name().username());
        user1.setFirstName(faker.name().firstName());
        user1.setLastName(faker.name().lastName());
        user1.setEmail(faker.internet().safeEmailAddress());
        user1.setPassword(faker.internet().password(5, 10));
        user1.setPhone(faker.phoneNumber().cellPhone());
        //user1.setUserStatus(0);

        // Create user 2
        faker = new Faker();
        User user2 = new User();
        user2.setId(faker.idNumber().hashCode());
        user2.setUsername(faker.name().username());
        user2.setFirstName(faker.name().firstName());
        user2.setLastName(faker.name().lastName());
        user2.setEmail(faker.internet().safeEmailAddress());
        user2.setPassword(faker.internet().password(5, 10));
        user2.setPhone(faker.phoneNumber().cellPhone());
        //user2.setUserStatus(0);

        // Create user 3
        faker = new Faker();
        User user3 = new User();
        user3.setId(faker.idNumber().hashCode());
        user3.setUsername(faker.name().username());
        user3.setFirstName(faker.name().firstName());
        user3.setLastName(faker.name().lastName());
        user3.setEmail(faker.internet().safeEmailAddress());
        user3.setPassword(faker.internet().password(5, 10));
        user3.setPhone(faker.phoneNumber().cellPhone());
        //user3.setUserStatus(0);
        
        // Add users to the list
        users.add(user1);
        users.add(user2);
        users.add(user3);

        //****************************************** 
        //set up User Array
        // Create an array of users
        //User[] userarray = new User[3];
        
        // Create userarray[0]
      	faker = new Faker();
        User user_a1 = new User();
        user_a1.setId(faker.idNumber().hashCode());
        user_a1.setUsername(faker.name().username());
        user_a1.setFirstName(faker.name().firstName());
        user_a1.setLastName(faker.name().lastName());
        user_a1.setEmail(faker.internet().safeEmailAddress());
        user_a1.setPassword(faker.internet().password(5, 10));
        user_a1.setPhone(faker.phoneNumber().cellPhone());
        //user_a1.setUserStatus(0);
        userarray[0] = user_a1;

        // Create userarray[1]
        faker = new Faker();
        User user_a2 = new User();
        user_a2.setId(faker.idNumber().hashCode());
        user_a2.setUsername(faker.name().username());
        user_a2.setFirstName(faker.name().firstName());
        user_a2.setLastName(faker.name().lastName());
        user_a2.setEmail(faker.internet().safeEmailAddress());
        user_a2.setPassword(faker.internet().password(5, 10));
        user_a2.setPhone(faker.phoneNumber().cellPhone());
        //user_a2.setUserStatus(0);
        userarray[1] = user_a2;

        // Create userarray[2]
        faker = new Faker();
        User user_a3 = new User();
        user_a3.setId(faker.idNumber().hashCode());
        user_a3.setUsername(faker.name().username());
        user_a3.setFirstName(faker.name().firstName());
        user_a3.setLastName(faker.name().lastName());
        user_a3.setEmail(faker.internet().safeEmailAddress());
        user_a3.setPassword(faker.internet().password(5, 10));
        user_a3.setPhone(faker.phoneNumber().cellPhone());
        //user_a3.setUserStatus(0);      
        userarray[2] = user_a3;      
        
        // Add users to the Array
        //userarray[0] = user_a1;
        //userarray[1] = user_a2;
        //userarray[2] = user_a3;
                
        
		//logs
		logger = LogManager.getLogger(this.getClass());
		
	}	
	
	@Test(priority = 1)
	public void TestPostUser() {
		logger.info("**************Creating User **************");	
		Response res = UserEndPoints.createUser(userPayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		logger.info("**************User is Created **************");
	}
	
	@Test(priority = 2)
	public void TestGetUserByName() {
		logger.info("**************Reading User Name **************");
		Response res = UserEndPoints.readUser(this.userPayload.getUsername());
		res.then().log().all();
		res.statusCode();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("**************User Info is displayed **************");
	}
	
	@Test(priority = 3)
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
	
	@Test(priority = 8)
	public void TestDeleteByUserName() {
		logger.info("**************Deleting User **************");
		Response res = UserEndPoints.deleteUser(this.userPayload.getUsername());
		res.then().log().all();
		res.statusCode();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("**************User is Deleted **************");
	}
	
	
	@Test(priority = 4)
	public void TestPostUserWithList() {		
	
		logger.info("**************Creating User List **************");	
		
		Response res = UserEndPoints.createUserWithList(users);
		res.then().log().all();
		
		// Verify the response status code
		Assert.assertEquals(res.getStatusCode(), 200);
		
        // Verify the response content type
        Assert.assertEquals(res.getContentType(), "application/json", "Expected content type is application/json");
		
        // Print the response body
		System.out.println("Created List Of Users Response Body is: " + res.getBody().asString());
		
		logger.info("**************User List is Created **************");
	}
	
	@Test(priority = 5)
	public void TestPostUserWithArray() {		
	
		logger.info("**************Creating User Array **************");	
		
		Response res = UserEndPoints.createUserWithArray(userarray);
		res.then().log().all();
		
		// Verify the response status code
		Assert.assertEquals(res.getStatusCode(), 200);
		
        // Verify the response content type
        Assert.assertEquals(res.getContentType(), "application/json", "Expected content type is application/json");
		
        // Print the response body
		System.out.println("Created Array Of Users Response Body is: " + res.getBody().asString());
		
		logger.info("**************User Array is Created **************");
	}
	
	@Test(priority = 6)
	public void TestGetListUserByName() {
		
		logger.info("**************Reading List User Name **************");
		
		System.out.println("Username = " + this.users.getFirst().getUsername());
		System.out.println("Username uuuu = " + this.users.get(2).getUsername());
	
		for (int i = 0; i< users.size(); i++) {
			Response res = UserEndPoints.readUser(this.users.get(i).getUsername());
			
			res.then().log().all();
						
			// Verify the response status code
			Assert.assertEquals(res.getStatusCode(), 200);
			
			// Print the response body
			System.out.println("Get Call Response Body is: " + res.getBody().asString());
		}
		logger.info("**************UserNames from List is displayed **************");
	}
	
	@Test(priority = 7)
	public void TestGetArrayUserByName() {
		
		logger.info("**************Reading UserName from Array  **************");
		
		System.out.println("Userarray[0]  = " + this.userarray[0].getUsername());
		
		
		for (int i = 0; i< userarray.length; i++) {
			Response res = UserEndPoints.readUser(this.userarray[i].getUsername());
			
			res.then().log().all();
						
			// Verify the response status code
			Assert.assertEquals(res.getStatusCode(), 200);
			
			// Print the response body
			System.out.println("Get Call Response Body is: " + res.getBody().asString());
		}
		logger.info("**************Array UserNames is displayed **************");
	}
	
}
