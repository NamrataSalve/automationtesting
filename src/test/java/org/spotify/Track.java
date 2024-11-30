package org.spotify;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Track {
    String token = "BQBePm0IqiuUtU9hxiCLXkHoUB4SdRHLqFf7LJUqMYFOAQdHNes3IgSVJ7jpbIrIf0JMq9qJrYvyyyMWWukM-bjC2tple1ev933i4shvp1b0MgW-QfqAGG1i1fFknHajwQtCS2Y7zmizit9pFzKVmsxREufruPFzTP9jiyNbFU32uDXeSRo-yYt5QJuU8gYrMAfoyVr3KG-0kudWcQFV6FOwB5RbFbeeQir3bPBtDtCK5g48R9QvIqglgiPR_ap7QfwhLeyhmtVUkD78e-5IBOiWmQ3pJ9kq3re96pO_KlMCUXa0Zihxq6g3zGBwawFZJqIbpstY8gocCCLo";

    @Test
    public void token() {
        Response res = RestAssured.given()
                .queryParam("response_type", "token")
                .queryParam("client_id", "14ede5cef2794981ab142def1ebb93dd")
                .queryParam("scope", "user-read-private,user-read-email,user-follow-modify,user-library-modify,user-library-read,playlist-modify-public,playlist-modify-private,ugc-image-upload,playlist-read-collaborative,playlist-read-private,playlist-modify-public,playlist-modify-private,user-read-playback-position")
                .queryParam("redirect_url", "http://localhost:3232")
                .queryParam("state", "state")
                .when()
                .post("https://accounts.spotify.com/authorize");
        res.prettyPrint();
    }

    @Test
    public void getTrack(){
        String track_id = "4iV5W9uYEdYUVa79Axb7Rh";
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/tracks/"+track_id);
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

    @Test
    public void getSeveralTracks(){
        String id1 = "4iV5W9uYEdYUVa79Axb7Rh";
        String id2 = "0kIAhDvnqaAZT018aQ36Px";
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", String.join(",", id1, id2))
                .when()
                .get("https://api.spotify.com/v1/tracks");
        res.prettyPrint();
    }

    @Test
    public void removeUsersSavedTracks(){
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"35waCk66eT7WkNYZ4sAoBT\",\"2UqjDAXnDxejEyE0CzfUrZ\"\n" +
                        "    ]\n" +
                        "}")
                .when()
                .delete("https://api.spotify.com/v1/me/tracks");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
}
