package org.spotify;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Markets {
    String token = "BQCWPvoMCF4vgDWtO8kvwbIeam3yiHd2OhAk_oP-y7BsRaIcO8D7Pl2Bzu43kzGiSY9F9uh6rdyPN_BxH3rJZB-a5T3Wn0VCnGtRRsUYRbH8A6g-ZPCUdw6iAshfLJYqmCPB0FRG6R0n2LkjZbhYcEyPgXDGvC4Wf2TKSqoEg73-M8d99aPs5X-sboozdsnCvMEFes6SAAsiOC6GTdZfykUHqXuGnaZt_Vh8tOmywBqN7AFZDVOATaxyMCUzmY5puBxCzbayDTFexDwzYmHi219uN-DDe7O64ULSSsHtnKQNikZtYv6dYOaIHhLCcEM18s6oShRebua4slIM";

    @Test
    public void getAvailableMarkets(){
        Response res = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/markets");
        res.prettyPrint();
    }

}
