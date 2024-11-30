package org.spotify;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PlayList {
    String token = "BQAk8Na-9fG_i-y_0AJ-KTOFYP8Qds_fjrJEjFTjr04sbQz5XYIJAVKCsxsxQfIt-WPj4saxU7z7lAXb2YsO9BSEQfcJZ4qnILml0c_uCJ_jcAPS3QCsfC7GNKlcoQTWEyyk48R_f07JgE1-DarZSjtoItuWtqzJM6itFWJvN25sd-2TvSd3W0UhtXV1fYXnG3HRAL6TnsK2WcLds9ngytqmCoetGxwqZkN3vDkECFCpJFLRz2AJsPDMSCP-2s2HOCGqLR9fke9yG1lQrO8m22dkhmbu56iWe2dIcXpL77jNpCWvQ5C9-CuemqQhGf0Znu10hBZzV5mATW6J";

    @Test
    public void createPlayList(){
        String user_id = "f7aodkj2ktcbt4uflnwgqmarj";

        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"name\": \"Namrata Fun music Playlist\",\n" +
                        "    \"description\": \"New playlist description\",\n" +
                        "    \"public\": false\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/users/"+user_id+"/playlists");
        res.prettyPeek();
    }


            @Test
    public void addItemToPlaylists(){
                String playlist_id = "3XueX1UlDjfMHJ5AgeF4z0";

                Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"uris\": [\"spotify:track:4iV5W9uYEdYUVa79Axb7Rh\",\"spotify:track:1301WleyT98MSxVHPZCA6M\"],\n" +
                        "    \"position\": 0\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/playlists/"+playlist_id+"/tracks");
        res.prettyPrint();
    }

    @Test
    public void getPlaylist(){
        String playlist_id ="37i9dQZF1DX08mhnhv6g9b";
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
//                .queryParam("ids","37i9dQZF1DX08mhnhv6g9b")
                .get("https://api.spotify.com/v1/playlists/"+playlist_id);
        res.prettyPeek();
    }

    @Test
    public void getPlaylistCoverImage(){
        String playlist_id ="37i9dQZF1DX08mhnhv6g9b";
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/playlists/"+playlist_id+"/images");
        res.prettyPeek();
    }

    @Test
    public void getCategoryPlaylists(){
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/browse/categories/dinner/playlists");
        res.prettyPeek();
    }

    @Test
    public void getFeaturedPlaylists(){
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/browse/featured-playlists");
        res.prettyPeek();
    }
}
