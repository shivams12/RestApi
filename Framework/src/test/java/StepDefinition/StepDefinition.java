package StepDefinition;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Addplace;
import pojo.Location;
import resources.TestData;
import resources.utils;

public class StepDefinition extends utils {
RequestSpecification res;
ResponseSpecification respec;
Response response;
TestData data = new TestData();
@Given("Add place payload {string} {string} {string}")
public void add_place_payload(String name, String language, String address) throws IOException {
   // Write code here that turns the phrase above into concrete actions

res = given().spec(requestSpecification())
.body(data.addplacePayload(name, address, language));
}

@When("user calls Add Api with post http request")
public void user_calls_Add_Api_with_post_http_request() {
respec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
response = res.when().post("/maps/api/place/add/json").
then().spec(respec).extract().response();
}

@Then("the API call got success with status code {int}")
public void the_API_call_got_success_with_status_code(Integer int1) {
   assertEquals(response.getStatusCode(),200);
}

@Then("{string} in response body is {string}")
public void in_response_body_is(String keyvalue, String Expectedvalue) {
String resp = response.asString();
JsonPath js = new JsonPath(resp);
assertEquals(js.get(keyvalue).toString(),Expectedvalue);
   
}



}