package api.endpoints;

/*Pre-Requisites:
 1. Create Maven Project
 2. Create POM file with dependencies
 3. Create folder structure
 4. Create Routes.java-- contains the URLs
 5. Create User EndPoint.java ----- CRUD(Create, Retrieve, Updating, Deleting) Methods implementation
 6. Create user.java class and import this class in Endpoint.java
 7. Create User Testcases
 8. Create data driven tests
 		create an excel sheet with test data and move it to the testData folder in our project
 		Copy the Excel Utility file from Internet to api.utilities folder
 		Data providers (multiple data driven tests will have multiple data providers) -- will get data from the excel sheet.
 		first dataprovider created to get all data from the excel sheet and post it to create multiple users
 		second dataProvider takes in only the usernames from the excel file and posts it to delete all users based on their usernames.
 9. Generate Extent Report 
 		using Extent ReportUtility
 		Testng.xml file to keep the Utility file
 10. Add Logs
 		Add Log4j2 dependency in pom.xml
 		Add log4j2.xml file to src/test resources folder
 		Write Code to Generate Logs
 		
 11.  Move the EndPoint URLs to a properties file under "src\test\resources" folder and read from the routes.properties file
 		Created a routes.properties file
 		Created UserEndPoints2.java file (Copy of UserEndPoints.java)to read the URLs from the properties file and pass it to the API Endpoints
 		Created UserTest2.java file(Copy of UserTests.java) to Read from the UserEndPoints2 class.
 		Updated TestNG.xml file to run the tests from UserTests2.java file instead of UserTests.java.
 12. Run the tests remotely via CMD prompt from POM.XML
 		make sure that pom.xml is executed via eclipse before trying to run pom.xml via cmd prompt.
  		Add Plugins: surefire plugin and maven compiler plugin
  		Update Maven project-->Right click on the PetStoreAutomation->Maven->Update project-> Check Force Update and click OK
  		run the POM.XML file.-- Right click on the PetStoreAutomation->Run As->Maven Test  		
  13. In Eclipse, Maven is already present. to run remotely using CI/CD process, we have to install Maven at OS level(on Windows or Mac) and run POM.xml remotely via cmd prompt.
  		Download the Maven binary Zip file for windows and Source Zip file for MAC and extract All.
  		Copy the Extracted folder directly to C:/ Drive
  		Copy the bin folder path and Set the path variable under system variables in the Environment variables. 
  		Check the maven version by typing the following cmd under the Cmd prompt:C:\Users\sansr>mvn -version
  			Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
			Maven home: C:\apache-maven-3.9.9-bin\apache-maven-3.9.9
			Java version: 22.0.1, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-22
			Default locale: en_US, platform encoding: UTF-8
			OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
		Run the POM .XML from the current project location in the CMD window.
			C:\Users\sansr> cd C:\Users\sansr\maven-workspace\PetStoreAutomation
			C:\Users\sansr\maven-workspace\PetStoreAutomation>mvn clean test
			C:\Users\sansr\maven-workspace\PetStoreAutomation>mvn test
		If you have issues running the maven tests and see that you get Java compatibility errors,
		then download the latest java version and add the path to the environment variables under system variables
  13.1 Run the Tests via pom.xml in Eclipse
  13.2 Run the Tests via pom.xml in cmd prompt
  14. Commit code in local repository(git)
  		Install Git software
  15. Push code to remote repository(github)
  		Have a Github account
  16. Run project in jenkins (from git github)	
  17. Working Directory: C:\Users\sansr\maven-workspace\PetStoreAutomation
  18. Create local repository by using git init cmd -- creates empty repository in your working directory
  19. First time you have to use these 2 cmds: 
  		 git config --global user.name "Sandhya Mangalapalli"
  		 git config --global user.email "sandhya.mangalapalli@gmail.com"


  
		
 		
*/

/*From Swagger URI ---> https://petstore.swagger.io
 * BaseUrl: petstore.swagger.io/v2

Create User (POST) : https://petstore.swagger.io/v2/user
Get User (GET): https://petstore.swagger.io/v2/user/{username}
Update User (PUT): https://petstore.swagger.io/v2/user/{username}
Delete User: (DELETE) : https://petstore.swagger.io/v2/user/{username}
Create List of Users with array: https://petstore.swagger.io/v2/user/createWithArray
Create List of Users with List: https://petstore.swagger.io/v2/user/createWithList

//Pet module 
 
Add new Pet to a store: https://petstore.swagger.io/v2/pet
Upload an image: https://petstore.swagger.io/v2/pet/{petId}/uploadImage
Update an existing pet: https://petstore.swagger.io/v2/pet
Find Pet by status: https://petstore.swagger.io/v2/pet/findByStatus"?status=available
Find Pet by ID: https://petstore.swagger.io/v2/pet/{petId}
Update Pet in store with form data: https://petstore.swagger.io/v2/pet/{petId}
Delete a Pet: https://petstore.swagger.io/v2/pet/{petId}
	
//Store Module

Get Inventory status: https://petstore.swagger.io/v2/store/inventory
Place an Order for Pet:https://petstore.swagger.io/v2/store/order  
Find Purchase order by Pet: https://petstore.swagger.io/v2/store/order/{orderId}
Delete Purchase order By Id: https://petstore.swagger.io/v2/store/order/{orderId}

*/

public class Routes {
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User Module
	public static String post_url = base_url + "/user";
	public static String get_url = base_url + "/user/{username}";
	public static String update_url = base_url + "/user/{username}";
	public static String delete_url = base_url + "/user/{username}";
	public static String create_with_array_url = base_url + "/user/createWithArray";
	public static String create_with_list_url = base_url + "/user/createWithList";
	
	//Pet module 
	public static String create_pet_url = "https://petstore.swagger.io/v2/pet";
	public static String upload_pet_image_url = base_url + "/pet/{petId}/uploadImage";
	public static String find_pet_by_status_url = "https://petstore.swagger.io/v2/pet/findByStatus"; //status query params: available, pending, sold
	//public static String find_pet_by_status_url = "https://petstore.swagger.io/v2/pet/findByStatus"?status=available";
	public static String get_pet_by_id_url = "https://petstore.swagger.io/v2/pet/{petId}";
	public static String update_pet_url = "https://petstore.swagger.io/v2/pet/{petId}";
	public static String delete_pet_url = "https://petstore.swagger.io/v2/pet/{petId}";
					
	//Store Module	
	public static String get_store_inventory_url = "https://petstore.swagger.io/v2/store/inventory";
	public static String place_pet_order_url = "https://petstore.swagger.io/v2/store/order";
	public static String get_order_by_id_url = "https://petstore.swagger.io/v2/store/order/{orderId}";
	public static String delete_order_by_id_url = "https://petstore.swagger.io/v2/store/order/{orderId}";
			
	
	
	
	
	
	/*curl -X 'POST' \
	  'https://petstore.swagger.io/v2/pet/23456/uploadImage' \
	  -H 'accept: application/json' \
	  -H 'Content-Type: multipart/form-data' \
	  -F 'additionalMetadata=asdfgh' \
	  -F 'file=@dog1.jpg;type=image/jpeg' */
	
	/*
	 * 
	 * curl -X 'POST' \
  'https://petstore.swagger.io/v2/pet' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": 0,
  "category": {
    "id": 0,
    "name": "string"
  },
  "name": "doggie",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "status": "available"
}'
	 */
	 

}
