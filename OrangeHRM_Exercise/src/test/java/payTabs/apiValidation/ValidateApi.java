package payTabs.apiValidation;


import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.netty.handler.codec.json.JsonObjectDecoder;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateApi {
	@Test(enabled = false)
	public void getAllUsers() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification httpreq = RestAssured.given();
		Response res = httpreq.request(Method.GET);
		String result = res.getBody().asString();
		System.out.println(result);
		JSONObject jobj = new JSONObject(result);
		JSONArray jarray = jobj.getJSONArray("data");
		System.out.println(jarray);
		for(int i=0; i<jarray.length(); i++) {
			JSONObject name = (JSONObject) jarray.get(i);
			String fname = (String) name.get("first_name");
			if(fname.equals("Emma")) {
				System.out.println("Json contains required name");
				break;
			}
			else {
				System.out.println("Json does not contains required name");
			}
		}
		int code = res.getStatusCode();
		if(code == 200) {
			System.out.println("Request sent successfully");
		}
		else {
			System.out.println("Request failed");
		}
	}
	
	@Test(enabled = true)
	public void validateInvalidUser() {
		RestAssured.baseURI = "https://reqres.in/api/users/23";
		RequestSpecification httpreq = RestAssured.given();
		Response res = httpreq.request(Method.GET);
		int code = res.getStatusCode();
		System.out.println(code);
		if(code == 404) {
			System.out.println("User Id not found");
		}
		else {
			System.out.println("User Id found");
		}
	}
	
	@Test
	public void createUser() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification httpreq = RestAssured.given();
		JSONObject jobject = new JSONObject();
		jobject.put("name", "Johnson");
		jobject.put("job", "Tester");
		httpreq.header("content-Tpe","application/json");
		httpreq.body(jobject.toString());
		Response res = httpreq.request(Method.POST);
		int code = res.getStatusCode();
		if(code == 201) {
			System.out.println("User Id created sucessfully");
		}
		else {
			System.out.println("User Id not created");
		}
	}
	
	@Test
	public void updateJob() {
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		RequestSpecification httpreq = RestAssured.given();
		JSONObject jobject = new JSONObject();
		jobject.put("name", "morpheus");
		jobject.put("job", "Tester");
		httpreq.header("content-Tpe","application/json");
		httpreq.body(jobject.toString());
		Response res = httpreq.request(Method.PUT);
		int code = res.getStatusCode();
		if(code == 200) {
			System.out.println("Job updted sucessfully");
		}
		else {
			System.out.println("Job not updted");
		}
	}
	
	@Test
	public void deleteEmployee() {
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		RequestSpecification httpreq = RestAssured.given();
		Response res = httpreq.request(Method.DELETE);
		int code = res.getStatusCode();
		System.out.println(code);
		if(code == 204) {
			System.out.println("Employee deleted sucessfully");
		}
		else {
			System.out.println("Employee not deleted");
		}
	}
	
	
	
	
	
}

