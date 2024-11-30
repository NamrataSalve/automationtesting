package org.petstore;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PetStore {
    public static final String URL = "https://petstore.swagger.io/v2";
    @Test
    public void user(){
        Response response = RestAssured.given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 101,\n" +
                        "  \"username\": \"Namrata\",\n" +
                        "  \"firstName\": \"Namrata\",\n" +
                        "  \"lastName\": \"Salve\",\n" +
                        "  \"email\": \"namrat@gmail.com\",\n" +
                        "  \"password\": \"Namrata\",\n" +
                        "  \"phone\": \"123654\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .post(URL+"/user");
        response.prettyPeek();
        response.then().statusCode(200);
    }

    @Test
    public void userLogin(){
        Response response = RestAssured.given()
                .header("accept","application/json")
//                .pathParam("userName","Namrata")
//                .pathParam("pass","Namrata")
                .queryParam("user","namrata")
                .queryParam("pass","namrata")
                .when()
//                .get("https://petstore.swagger.io/v2/user/login?username=Namrata&password=Namrata");
        .get("https://petstore.swagger.io/v2/user/login");
        response.prettyPeek();
        response.then().assertThat().statusCode(200);
//        String Id = response.path("id");
//        Assert.assertEquals(Id,"1");
    }

    @Test
    public void displayUserByUserName(){
        String userName = "Namrata";
        Response response =  RestAssured.given()
                .header("accept","application/json")
                .when()
                .get(URL+"/user/"+userName);
        response.prettyPeek();

    }

    @Test
    public void userLogOut(){
        Response response =RestAssured.given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/logout");
        response.prettyPeek();

    }

    @Test
    public void deleteUserByUserName(){
        String userName = "Namrata";
        Response response = RestAssured.given()
                .header("accept","application/json")
                .when()
                .delete(URL+"/user/"+userName);
        response.prettyPeek();
    }

    @Test
    public void pet(){
        Response response = RestAssured.given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 101,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"Dogs\"\n" +
                        "  },\n" +
                        "  \"name\": \"Tom\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 1,\n" +
                        "      \"name\": \"Friendly\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post(URL+"/pet");
        response.prettyPeek();
    }

    @Test
    public void getPetByPetId(){
        int petId = 101;
        Response response = RestAssured.given()
                .header("accept","application/json")
                .when()
                .get(URL+"/pet/"+petId);
        response.prettyPeek();
    }

    @Test
    public void updatePetDetails() {
        Response response = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 3,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 3,\n" +
                        "    \"name\": \"Dog\"\n" +
                        "  },\n" +
                        "  \"name\": \"Bell\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 3,\n" +
                        "      \"name\": \"Helpful\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/pet");
        response.prettyPeek();
    }

    @Test
    public void deletePet(){
        Response response=RestAssured.given()
                .header("accept","application/json")
                // .header("Content-Type","application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/1");
        response.prettyPeek();

    }

    @Test
    public void addStore() {
        Response response = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"petId\": 1,\n" +
                        "  \"quantity\": 1,\n" +
                        "  \"shipDate\": \"2024-11-23T13:11:05.352Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/store/order");


    }

}

