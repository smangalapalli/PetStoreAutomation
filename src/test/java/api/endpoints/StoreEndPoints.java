package api.endpoints;

import static io.restassured.RestAssured.given;
import java.io.File;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import api.payload.*;

//StoreEndPoints.java
//Created for Performing Placing an Order, Getting Inventory Status, Get Purchase Order by OrderId and Delete Purchase Order by OrderId requests for the Store API

public class StoreEndPoints {
	
	//Create Order
	
	public static Response createOrder(Store payload){
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)			
			.body(payload)
		.when()
			.post(Routes.place_pet_order_url);
		return res;		
	}
	
	public static Response readOrderById(int orderID){
		Response res = given()
			.pathParam("orderId", orderID)
		.when()
			.get(Routes.get_order_by_id_url);
		return res;		
	}
	
	public static Response readStoreInventory(){
		Response res = given()
			.accept(ContentType.JSON)	
		.when()
			.get(Routes.get_store_inventory_url);
		return res;		
	}

	public static Response deleteOrder(int orderID){
		Response res = given()
			.pathParam("orderId", orderID)
		.when()
			.delete(Routes.delete_order_by_id_url);
		return res;		
	}	

}
