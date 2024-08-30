package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import api.payload.*;

//UserEndPoints.java
//Created for Performing Create, Read, Update and Delete requests for the User API

public class UserEndPoints2 {
	
	//method to read the routes.properties file to get all the URL endpoints.
	static ResourceBundle getURL()
	{
		ResourceBundle rb = ResourceBundle.getBundle("routes");
		return rb;
	}
	
	
	//Create User
	
	public static Response createUser(User payload){
		// Get the URL string from the routes.properties file and pass it to the POST API call.
		String p_url = getURL().getString("post_url");
		
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(p_url);
		return res;		
	}
	
	public static Response readUser(String userName){
		
		// Get the URL string from the routes.properties file and pass it to the GET API call.
		String g_url = getURL().getString("get_url");
		Response res = given()
			.pathParam("username", userName)
		.when()
			.get(g_url);
		return res;		
	}
	
	public static Response updateUser(String userName, User payload){
		
		// Get the URL string from the routes.properties file and pass it to the Update API call.
		String update_url = getURL().getString("update_url");
		
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
		.when()
			.put(update_url);
		return res;
	}
	
	public static Response deleteUser(String userName){
		
		// Get the URL string from the routes.properties file and pass it to the Delete API call.
		String d_url = getURL().getString("delete_url");
		
		Response res = given()
			.pathParam("username", userName)
		.when()
			.delete(d_url);
		return res;		
	}
	

}
