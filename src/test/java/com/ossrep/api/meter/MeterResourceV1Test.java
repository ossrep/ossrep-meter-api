package com.ossrep.api.meter;

import com.ossrep.api.Role;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;
import jakarta.ws.rs.core.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class MeterResourceV1Test {

    @Test
    @TestSecurity(user = "testUser", roles = {Role.METER_READ, Role.METER_WRITE})
    public void postAndGetByTdspMeterId() {
        MeterV1 meterV1 = new MeterV1("CENTERPOINT", RandomStringUtils.secure().nextAlphanumeric(25));
        MeterV1 saved = given()
                .contentType(ContentType.JSON)
                .body(meterV1)
                .post("/api/v1/meters")
                .then()
                .statusCode(Response.Status.CREATED.getStatusCode())
                .extract().as(MeterV1.class);
        MeterV1 got = given()
                .when()
                .get("/api/v1/meters/{tdspMeterId}", saved.tdspMeterId())
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .extract().as(MeterV1.class);
        assertThat(saved).isEqualTo(got);
    }

    @Test
    @TestSecurity(user = "testUser", roles = {Role.METER_READ, Role.METER_WRITE})
    public void getByTdspMeterId() {
        MeterV1 got = given()
                .when()
                .get("/api/v1/meters/{tdspMeterId}", "test-0001234561")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .extract().as(MeterV1.class);
        assertThat(got).isNotNull().extracting("tdspMeterId").isEqualTo("test-0001234561");
        assertThat(got).extracting("tdspCode").isEqualTo("ONCOR");
    }

}
