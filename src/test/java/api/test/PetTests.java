package api.test;

import java.io.File;

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
	Pet petPayload;  //Create Pet Objects	
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
		
		faker = new Faker();
		Tag tag1 = new Tag();
		tag1.setId(faker.idNumber().hashCode());
		tag1.setName(faker.name().name());
		tags[0] = tag1;
		
		faker = new Faker();
		Tag tag2 = new Tag();
		tag2.setId(faker.idNumber().hashCode());
		tag2.setName(faker.name().name());
		tags[1] = tag2;
		
		faker = new Faker();
		Tag tag3 = new Tag();
		tag3.setId(faker.idNumber().hashCode());
		tag3.setName(faker.name().name());
		tags[2] = tag3;
		
		faker = new Faker();
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
	public void UploadPetImage() {
		logger.info("**************Uploading Pet Image **************");	
		File img_filename = new File("src/test/resources/dog3.jpg");		
		String add_metadata = "this is additional metadata";
		System.out.println("img_filename " + img_filename);
		Response res = PetEndPoints.uploadImage(this.petPayload.getId(), img_filename, add_metadata);		
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		// Print the response body
		System.out.println("Upload Image Response Body is: " + res.getBody().asString());
		
		logger.info("**************Uploaded Pet image **************");
	}
	
	@Test(priority = 2)
	public void TestPostPet() {
		logger.info("**************Creating Pet **************");	
		Response res = PetEndPoints.createPet(petPayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		// Print the response body
		System.out.println("Response Body is: " + res.getBody().asString());
		
		logger.info("**************Pet is Created **************");
	}

	@Test(priority = 3)
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
	
	@Test(priority = 4)
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
	
	@Test(priority = 5)
	public void TestPutPet() {
		logger.info("************** Put Pet API call **************");	
		petPayload.setName(faker.name().name());
		Category get_category  = petPayload.getCategory();
		//System.out.println("Get category: " + petPayload.getCategory());
		//get_category.setId(faker.idNumber().hashCode());
		petPayload.setCategory(get_category);
		tags[1].setName(faker.name().name());
		petPayload.setTags(tags);
		petPayload.setStatus("sold");
		
		Response res = PetEndPoints.putPet(petPayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		// Print the response body
		System.out.println("Response Body for Put pet API call: " + res.getBody().asString());
		
		logger.info("**************Put Pet API Call done **************");
	}
	
	@Test(priority = 6)
	public void UpdatePetFormdata() {
		logger.info("**************Updating Pet Form Data **************");	
		String name_v = faker.name().name();
		String status_v = "available";
		System.out.println("name_v: " + name_v);
		Response res = PetEndPoints.updatePet(this.petPayload.getId(), name_v, status_v);		
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		// Print the response body
		System.out.println("Response Body for updated Pet is: " + res.getBody().asString());
		
		logger.info("**************Updating Pet Form Data **************");
	}	
	
	@Test(priority = 7)
	public void TestDeletePetByPetID() {
		logger.info("**************Deleting Pet **************");
		Response res = PetEndPoints.deletePet(this.petPayload.getId());
		res.then().log().all();
		res.statusCode();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		// Print the response body
		System.out.println("Response Body for updated Pet is: " + res.getBody().asString());
		logger.info("**************Pet is Deleted **************");
	}	
}
	

