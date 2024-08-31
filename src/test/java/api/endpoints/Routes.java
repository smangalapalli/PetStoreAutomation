package api.endpoints;

/*Pre-Requisites:  	
  			 
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

}

/*
 * 
 * curl -X 'POST' \
  'https://petstore.swagger.io/v2/store/order' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": 0,
  "petId": 754346482,
  "quantity": 1,
  "shipDate": "2024-08-31T01:20:21.741Z",
  "status": "placed",
  "complete": true
}'

Response body
Download
{
  "id": 12,
  "petId": 754346482,
  "quantity": 1,
  "shipDate": "2024-08-31T01:20:21.741+0000",
  "status": "placed",
  "complete": true
}
*/

/*
 * 
 * curl -X 'GET' \
  'https://petstore.swagger.io/v2/store/inventory' \
  -H 'accept: application/json'
  
  	
Response body
Download
{
  "sold": 4,
  "SOLD": 1,
  "string": 402,
  "pending": 5,
  "available": 149,
  "sold\n": 1
}
*/

/*
 * curl -X 'GET' \
  'https://petstore.swagger.io/v2/store/order/4' \
  -H 'accept: app
  
 	
Response body
Download
{
  "id": 4,
  "petId": 5,
  "quantity": 1,
  "shipDate": "2023-01-01T00:00:00.000+0000",
  "status": "placed",
  "complete": true
} 
*/
/*
 * 
 * curl -X 'DELETE' \
  'https://petstore.swagger.io/v2/store/order/12' \
  -H 'accept: application/json
  
 {
  "code": 200,
  "type": "unknown",
  "message": "12"
} 
*/

