package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

/*Created UserTests2.java file exactly like UserTests.java which
reads from UserEndpoints2.java which in turn reads URLs from routes.properties file and not routes.java file.
*/
public class UserTests2 {
	Faker faker;
	User userPayload, User1, User2;
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
		
		//logs
		logger = LogManager.getLogger(this.getClass());		
		
	}
	@Test(priority = 1)
	public void TestPostUser() {
		logger.info("**************Creating User **************");	
		Response res = UserEndPoints2.createUser(userPayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		logger.info("**************User is Created **************");
	}
	
	@Test(priority = 2)
	public void TestGetUserByName() {
		logger.info("**************Reading User Name **************");
		Response res = UserEndPoints2.readUser(this.userPayload.getUsername());
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
		
		Response res = UserEndPoints2.updateUser(this.userPayload.getUsername(),userPayload);
		res.then().log().all();
		res.then().log().body().statusCode(200);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//Checking data after update		
		Response respafterupdate = UserEndPoints2.readUser(this.userPayload.getUsername());
		respafterupdate.then().log().all();
		respafterupdate.statusCode();
		Assert.assertEquals(respafterupdate.getStatusCode(), 200);
		logger.info("**************User is Updated **************");
	}
	
	@Test(priority = 4)
	public void TestDeleteByUserName() {
		logger.info("**************Deleting User **************");
		Response res = UserEndPoints2.deleteUser(this.userPayload.getUsername());
		res.then().log().all();
		res.statusCode();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("**************User is Deleted **************");
	}
}
