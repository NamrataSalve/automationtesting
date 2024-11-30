package org.spotify;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Episodes {
    String token = "BQC65O5ou3lR4Rp97skQQQN_1DJ93ZlDa92hcrrwy2BmU1MogKiS1T3R-DLEZHoRxILoYBYDmUkM3IS5m-tPLy4bWuRcQk8ak6bWGuBa4a_j749gbev6z0DwihbpZ2y2W-RmvVZotcAVFRhNPZvYMSoN3vmt_RWHUGcbJkCgw_llzlrrMb3o4CYL1NbLfrz1IkwhdxU6GYENxQEGW_CrJuQtnk5A7vK_OI9vlBFeDTN7c5gD-PdJfcOfOO-QGzGoOQpatAN8FktIPdjRyMaVTiiaGEaDkPVLwOGy5T_jFk5alMfe71o0KSJ6ZhynVbs3oMGWo46Lz31bt6GY";
//    public void token(){
//        Response res = RestAssured.given()
//                .queryParam("response_type", "token")
//                .queryParam("client_id", "05c7840dac1f432aaca4ed4249c10c93")
//                .queryParam("scope", "user-read-private,user-read-email,user-follow-modify,user-library-modify,user-library-read,playlist-modify-public,playlist-modify-private,ugc-image-upload,playlist-read-collaborative,playlist-read-private,playlist-modify-public,playlist-modify-private,user-read-playback-position")
//                .queryParam("redirect_url", "http://localhost:3232")
//                .queryParam("state", "state")
//                .when()
//                .post("https://accounts.spotify.com/authorize");
//        res.prettyPrint();
//    }

    @Test
    public void getEpisode(){
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .queryParam("ids","6P55BDVTFFn47R1SiG8Xad")
                .when()
                .get("https://api.spotify.com/v1/episodes");
        res.prettyPrint();
    }

    @Test
    public void saveEpisodesForCurrentUser(){
        Response res= RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"1iTgwzKg2Gv9pgNwg2dHa8\",\"6P55BDVTFFn47R1SiG8Xad\"\n" +
                        "    ]\n" +
                        "}")
                .when()
                        .put("https://api.spotify.com/v1/me/episodes");
        res.prettyPrint();
//        res.then().assertThat().statusCode(200);
    }

}
