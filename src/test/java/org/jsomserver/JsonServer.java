package org.jsomserver;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class JsonServer {

    @Test
    public void user(){
        Response response = RestAssured.given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body(" {\n" +
                        "        \"id\": \"2\",\n" +
                        "        \"title\": \"testing\",\n" +
                        "        \"author\": \"Namrata\"\n" +
                        "}")
                .when()
                .post("http://localhost:3000/posts");
        response.prettyPeek();
    }

    @Test
    public void viewUser(){

        Response response =  RestAssured.given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .when()
                .get("http://localhost:3000/posts");

        response.prettyPeek();

    }

    @Test
    public void updateUserDetails(){
        Response response = RestAssured.given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
//                .pathParam("id",1)
                .when()
                .body("   {\n" +
                        "        \"id\": \"1\",\n" +
                        "        \"title\": \"Api testing\",\n" +
                        "        \"author\": \"kiran\"\n" +
                        "    }")
                .put("http://localhost:3000/posts/1");

        response.prettyPeek();
        response.then().statusCode(200);

    }

    @Test
    public void deleteUserDetails(){
        Response response = RestAssured.given()
                .header("accept","application/json")
                .when()
                .delete("http://localhost:3000/posts/1");
        response.prettyPeek();
    }

    @Test
    public void CreatingComment(){

        Response response = RestAssured.given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "      \"id\": \"3\",\n" +
                        "      \"body\": \"Good\",\n" +
                        "      \"postId\": 3\n" +
                        "}")
                .when()
                .post("http://localhost:3000/comments");

        response.prettyPeek();
        response.then().statusCode(201);


    }

    @Test
    public void viewComments(){

        Response response =  RestAssured.given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .when()
                .get("http://localhost:3000/comments");

        response.prettyPeek();

    }

    @Test
    public void updateCommentsDetails(){
        Response response = RestAssured.given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
//                .pathParam("id",1)
                .when()
                .body("  {\n" +
                        "        \"id\": \"3\",\n" +
                        "        \"body\": \"Good comment\",\n" +
                        "        \"postId\": 3\n" +
                        "  }")
                .put("http://localhost:3000/comments/3");

        response.prettyPeek();
        response.then().statusCode(200);

    }

    @Test
    public void deleteCommentsDetails(){
        Response response = RestAssured.given()
                .header("accept","application/json")
                .when()
                .delete("http://localhost:3000/comments/3");
        response.prettyPeek();

    }

}
