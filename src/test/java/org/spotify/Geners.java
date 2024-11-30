package org.spotify;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Geners {
    String token = "BQC65O5ou3lR4Rp97skQQQN_1DJ93ZlDa92hcrrwy2BmU1MogKiS1T3R-DLEZHoRxILoYBYDmUkM3IS5m-tPLy4bWuRcQk8ak6bWGuBa4a_j749gbev6z0DwihbpZ2y2W-RmvVZotcAVFRhNPZvYMSoN3vmt_RWHUGcbJkCgw_llzlrrMb3o4CYL1NbLfrz1IkwhdxU6GYENxQEGW_CrJuQtnk5A7vK_OI9vlBFeDTN7c5gD-PdJfcOfOO-QGzGoOQpatAN8FktIPdjRyMaVTiiaGEaDkPVLwOGy5T_jFk5alMfe71o0KSJ6ZhynVbs3oMGWo46Lz31bt6GY";

    @Test
    public void searchForItem(){
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
        res.prettyPrint();
        res.then().assertThat().statusCode(404);
    }
}
