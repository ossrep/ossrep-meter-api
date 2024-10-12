package com.ossrep.meter.api.v1;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class MeterResourceV1Test {

    @Test
    public void getByMeterId() {
        MeterV1 got = given()
                .when()
                .get("/api/v1/meters/{tdspMeterId}", "TEST00000001")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .extract().as(MeterV1.class);
        assertNotNull(got);
        assertEquals(got.tdspMeterId(), "TEST00000001");
        assertEquals(got.tdsp(), "CNP");
        assertEquals(got.iso(), "ERCOT");
    }

}
