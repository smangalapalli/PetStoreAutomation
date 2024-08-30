package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints;
import api.payload.Category;
import api.payload.Pet;
import api.payload.Tag;
import io.restassured.response.Response;

public class PetTests {
	Faker faker;		
	Pet petPayload;  //Create User Objects	
	Category category;
	Tag tag1, tag2, tag3;
	String [] p_photoUrls = {"https://klike.net/uploads/posts/2023-01/1675061232_3-62.jpg", "two.jpg", "three.jpg"};
	Tag [] tags = new Tag[3]; 	 // Create an array of Tag Object    
	
	public Logger logger; //create a variable for logs
	
	
	@BeforeClass
	public void setup() {
		faker = new Faker();
		Category category = new Category();
		category.setId(faker.idNumber().hashCode());
		category.setName(faker.name().name());
		
		Tag tag1 = new Tag();
		tag1.setId(faker.idNumber().hashCode());
		tag1.setName(faker.name().name());
		tags[0] = tag1;
		
		Tag tag2 = new Tag();
		tag2.setId(faker.idNumber().hashCode());
		tag2.setName(faker.name().name());
		tags[1] = tag2;
		
		Tag tag3 = new Tag();
		tag3.setId(faker.idNumber().hashCode());
		tag3.setName(faker.name().name());
		tags[2] = tag3;
		
		petPayload = new Pet();
		petPayload.setId(faker.idNumber().hashCode());
		petPayload.setCategory(category);
		petPayload.setName(faker.name().name());
		petPayload.setPhotoUrls(p_photoUrls);
		petPayload.setTags(tags);
		petPayload.setStatus("pending");	
        
		//logs
		logger = LogManager.getLogger(this.getClass());
		
	}	
	
	@Test(priority = 1)
	public void TestPostPet() {
		logger.info("**************Creating Pet **************");	
		Response res = PetEndPoints.createPet(petPayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		// Print the response body
		System.out.println("Response Body is: " + res.getBody().asString());
		
		logger.info("**************Pet is Created **************");
	}

	
	@Test(priority = 2)
	public void TestGetPetByStatus() {
		logger.info("**************Pets By Status **************");
		Response res = PetEndPoints.readStatus();
		res.then().log().all();
		res.statusCode();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		// Print the response body
		System.out.println("Response for pending status is: " + res.getBody().asString());
		
		logger.info("**************Pets by status is displayed **************");
	}
	
	@Test(priority = 3)
	public void TestGetPetByID() {
		logger.info("**************Pet By ID **************");
		Response res = PetEndPoints.readId(this.petPayload.getId());
		res.then().log().all();
		res.statusCode();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		// Print the response body
		System.out.println("Response for Getting Pet By ID is: " + res.getBody().asString());
		
		logger.info("**************Pet by ID is displayed **************");
	}
	/*
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
*/
	
}
	
	

