package org.spotify;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Albums {
    String token = "BQDIrHj2FDaGYQZ7z-xWwe7Bi4lxZBgA59CHDBOOzXyAoVLGdr_XkhPbelL1myi9RCM-NRIJRb9_VU50fVt5_98UIMjZJsrUXoEUc4sB1mStRIqv6bgmy6Abn_myJSCTUdECsEbsaMR9sSYvVBBfCWzCRSkKoGkRHS8dqCeJapCNc1kuDMWb6WoEdk46-661dz79FLPA7LtBUmtfx1gm2rihfVsDot46bbJq1Jfs1spkn3O00cxJYoAJ8MsKCIrpoxLStQQdz94Yx2pUc9PaqObBrpuyMbl36ihEp9kYo098sR86U8o2YHZs6kGBpJxemtF76mX4aljyVBYQ";

    @Test
    public void token() {
        Response res = RestAssured.given()
                .queryParam("response_type", "token")
                .queryParam("client_id", "05c7840dac1f432aaca4ed4249c10c93")
                .queryParam("scope", "user-read-private,user-read-email,user-follow-modify,user-library-modify,user-library-read,playlist-modify-public,playlist-modify-private,ugc-image-upload,playlist-read-collaborative,playlist-read-private,playlist-modify-public,playlist-modify-private,user-read-playback-position")
                .queryParam("redirect_url", "http://localhost:3232")
                .queryParam("state", "state")
                .when()
                .post("https://accounts.spotify.com/authorize");
        res.prettyPrint();
    }

    @Test
    public void saveAlbumsForCurrentUser(){
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"1vhNGBTFoaSTLbHjPGFIlF\",\"0S4pP8MBY9p7ngFWIZQAJv\"\n" +
                        "    ]\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/me/albums");
    }

    @Test
    public void getAlbum(){
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .queryParam("ids","1vhNGBTFoaSTLbHjPGFIlF")
                .when()
                .get("https://api.spotify.com/v1/albums");
        res.prettyPrint();
    }

    @Test
    public void removeUsersSavedAlbums(){
        Response res = RestAssured.given()
         .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"0S4pP8MBY9p7ngFWIZQAJv\"\n" +
                        "    ]\n" +
                        "}")
                .when()
                .delete("https://api.spotify.com/v1/me/albums");
        res.prettyPeek();
//        res.then().assertThat().statusCode(200);
    }


}
