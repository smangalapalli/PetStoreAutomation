package api.test;


import java.util.Date;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests {
	Faker faker;		
	Store storePayload;  //Create Store Objects	
	String [] status = new String [] {"available", "pending", "sold"};
	String status_value;
	public Logger logger; //create a variable for logs
	
	
	@BeforeClass
	public void setup() {
		faker = new Faker();
		
		//Get Random Status from the status array
		Random rand = new Random();
		status_value = status[rand.nextInt(status.length)];
		System.out.println("status_value: " + status_value);
		
		//Get Current Date
		Date currentDate = new Date();
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		//String currentDateTime = dateFormat.format(currentDate);
		//System.out.println(currentDateTime);  
	    
	    storePayload = new Store();
		storePayload.setId(faker.idNumber().hashCode());
		storePayload.setPetId(faker.idNumber().hashCode());
		storePayload.setQuantity(faker.idNumber().hashCode());
		storePayload.setShipDate(currentDate);
		storePayload.setStatus(status_value);
		storePayload.setComplete(true);		
		
        
		//logs
		logger = LogManager.getLogger(this.getClass());
		
	}	
	
	@Test(priority = 1)
	public void TestPostStoreOrder() {
		logger.info("**************Creating Pet Order **************");	
		Response res = StoreEndPoints.createOrder(storePayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		// Print the response body
		System.out.println("Response Body is: " + res.getBody().asString());
		
		logger.info("**************Pet Order is Created **************");
	}

	@Test(priority = 2)
	public void TestGetStoreInventory() {
		logger.info("**************Get Pet Store Inventory **************");
		Response res = StoreEndPoints.readStoreInventory();
		res.then().log().all();
		res.statusCode();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		// Print the response body
		System.out.println("Response for Pet Store Inventory is: " + res.getBody().asString());
		
		logger.info("**************Pet Store Inventory is displayed **************");
	}
	
	@Test(priority = 3)
	public void TestGetOrderByID() {
		logger.info("**************Get Pet Order By ID **************");
		Response res = StoreEndPoints.readOrderById(this.storePayload.getId());
		res.then().log().all();
		res.statusCode();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		// Print the response body
		System.out.println("Response for Getting Pet Order By ID is: " + res.getBody().asString());
		
		logger.info("**************Pet Order by ID is displayed **************");
	}
	
	@Test(priority = 4)
	public void TestDeleteOrderByOrderID() {
		logger.info("**************Deleting Pet Order **************");
		Response res = StoreEndPoints.deleteOrder(this.storePayload.getId());
		res.then().log().all();
		res.statusCode();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		// Print the response body
		System.out.println("Response Body for Deleted Order is: " + res.getBody().asString());
		logger.info("**************Pet Order is Deleted **************");
	}	
	
}

	

