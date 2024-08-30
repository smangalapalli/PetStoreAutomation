package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import api.payload.*;

//UserEndPoints.java
//Created for Performing Create, Read, Update and Delete requests for the User API

public class PetEndPoints {
	
	//Create User
	
	public static Response createPet(Pet payload){
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.create_pet_url);
		return res;		
	}
	
	public static Response readStatus(){
		Response res = given()
			.queryParam("status", "pending")
			//.pathParam("username", userName)
		.when()
			.get(Routes.find_pet_by_status_url);
		return res;		
	}
	
	public static Response readId(int petID){
		Response res = given()
			.pathParam("petId", petID)
		.when()
			.get(Routes.get_pet_by_id_url);
		return res;		
	}
	
	
	/*public static Response updateUser(String userName, User payload){
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
		.when()
			.put(Routes.update_url);
		return res;
	}
	
	public static Response deleteUser(String userName){
		Response res = given()
			.pathParam("username", userName)
		.when()
			.delete(Routes.delete_url);
		return res;		
	}
	
	public static Response createUserWithList(List<User> users){
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(users)
		.when()
			.post(Routes.create_with_list_url);
		return res;		
	}
		
	public static Response createUserWithArray(User[] userarray){
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(userarray)
		.when()
			.post(Routes.create_with_array_url);
		return res;		
	}*/
	

}
