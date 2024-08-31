package api.endpoints;

import static io.restassured.RestAssured.given;
import java.io.File;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import api.payload.*;

//PetEndPoints.java
//Created for Performing Create, Upload, Read, Update and Delete requests for the Pet API

public class PetEndPoints {
	
	//Create Pet
	
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
	
	public static Response updatePet(int petID, String namevalue, String statusvalue){
		Response res = given()
			.contentType(ContentType.URLENC)
			.accept(ContentType.JSON)
			.formParam("name", namevalue)
			.formParam("status", statusvalue)	
			.pathParam("petId", petID)
		.when()
			.post(Routes.update_pet_url);
		return res;
	}
	
	public static Response uploadImage(int petID, File imageFile, String metadata){
		Response res = given()
			.contentType(ContentType.MULTIPART)
			.accept(ContentType.JSON)
			.multiPart("file", imageFile, "image/jpeg")
			.multiPart("additionalMetadata", metadata)
			.pathParam("petId", petID)
		.when()
			.post(Routes.upload_pet_image_url);
		return res;
	}
		
	public static Response deletePet(int petID){
		Response res = given()
			.pathParam("petId", petID)
		.when()
			.delete(Routes.delete_pet_url);
		return res;		
	}
	
	public static Response putPet(Pet payload){
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			
			.body(payload)
		.when()
			.put(Routes.create_pet_url);
		return res;		
	}	

}
