package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import api.payload.*;

//UserEndPoints.java
//Created for Performing Create, Read, Update and Delete requests for the User API

public class UserEndPoints3 {
	
	//Create User
	
	/*public static Response createUser(User payload){
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
		return res;		
	}*/
	
	public static Response readUser(String userName){
		Response res = given()
			.pathParam("username", userName)
		.when()
			.get(Routes.get_url);
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
	}*/
	
	public static Response createUserWithList(List<User2> users){
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(users)
		.when()
			.post(Routes.create_with_list_url);
		return res;		
	}
	

}
