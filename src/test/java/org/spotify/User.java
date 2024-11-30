package org.spotify;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.testng.annotations.Test;

public class User {
    String token = "BQAk8Na-9fG_i-y_0AJ-KTOFYP8Qds_fjrJEjFTjr04sbQz5XYIJAVKCsxsxQfIt-WPj4saxU7z7lAXb2YsO9BSEQfcJZ4qnILml0c_uCJ_jcAPS3QCsfC7GNKlcoQTWEyyk48R_f07JgE1-DarZSjtoItuWtqzJM6itFWJvN25sd-2TvSd3W0UhtXV1fYXnG3HRAL6TnsK2WcLds9ngytqmCoetGxwqZkN3vDkECFCpJFLRz2AJsPDMSCP-2s2HOCGqLR9fke9yG1lQrO8m22dkhmbu56iWe2dIcXpL77jNpCWvQ5C9-CuemqQhGf0Znu10hBZzV5mATW6J";
//    @Test
//    public void token() {
//        Response res = RestAssured.given()
//                .queryParam("response_type", "token")
//                .queryParam("client_id", "14ede5cef2794981ab142def1ebb93dd")
//                .queryParam("scope", "user-read-private,user-read-email,user-follow-modify,user-library-modify,user-library-read,playlist-modify-public,playlist-modify-private,ugc-image-upload,playlist-read-collaborative,playlist-read-private,playlist-modify-public,playlist-modify-private,user-read-playback-position")
//                .queryParam("redirect_url", "http://localhost:3232")
//                .queryParam("state", "state")
//                .when()
//                .post("https://accounts.spotify.com/authorize");
//        res.prettyPrint();
//    }

    @Test
    public void getCurrentUser() {
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
        String id = res.path("id");
        Assert.assertEquals(id, "f7aodkj2ktcbt4uflnwgqmarj");
    }

    @Test
    public void getUsersProfile(){
        String user_id = "f7aodkj2ktcbt4uflnwgqmarj";
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/users/"+user_id);
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
        String id = res.path("id");
        Assert.assertEquals(id, "f7aodkj2ktcbt4uflnwgqmarj");
    }

    @Test
    public void followPlaylist(){
        String playlist_id = "3XueX1UlDjfMHJ5AgeF4z0";
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .put("https://api.spotify.com/v1/playlists/"+playlist_id+"/followers");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

    @Test
    public void unfollowPlaylist(){
        String playlist_id = "3XueX1UlDjfMHJ5AgeF4z0";
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("https://api.spotify.com/v1/playlists/"+ playlist_id+"/followers");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

    @Test
    public void getUsersTopItems(){
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me/top/artists");
        res.prettyPeek();
    }
}