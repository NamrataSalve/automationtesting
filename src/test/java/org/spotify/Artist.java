package org.spotify;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Artist {
    String token = "BQC65O5ou3lR4Rp97skQQQN_1DJ93ZlDa92hcrrwy2BmU1MogKiS1T3R-DLEZHoRxILoYBYDmUkM3IS5m-tPLy4bWuRcQk8ak6bWGuBa4a_j749gbev6z0DwihbpZ2y2W-RmvVZotcAVFRhNPZvYMSoN3vmt_RWHUGcbJkCgw_llzlrrMb3o4CYL1NbLfrz1IkwhdxU6GYENxQEGW_CrJuQtnk5A7vK_OI9vlBFeDTN7c5gD-PdJfcOfOO-QGzGoOQpatAN8FktIPdjRyMaVTiiaGEaDkPVLwOGy5T_jFk5alMfe71o0KSJ6ZhynVbs3oMGWo46Lz31bt6GY";
    @Test
    public void token(){
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
    public void getArtist(){
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .queryParam("ids","3JsHnjpbhX4SnySpvpa9DK")
                .when()
                .get("https://api.spotify.com/v1/artists");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

    @Test
    public void getSeveralArtists(){
        String id1 = "0b1sIQumIAsNbqAoIClSpy";
        String id2 = "3JsHnjpbhX4SnySpvpa9DK";
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .queryParam("ids",String.join(",",id1,id2))
                .when()
                .get("https://api.spotify.com/v1/artists");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);

    }



}
