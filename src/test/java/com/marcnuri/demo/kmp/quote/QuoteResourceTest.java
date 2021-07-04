package com.marcnuri.demo.kmp.quote;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.emptyOrNullString;

@QuarkusTest
class QuoteResourceTest {

    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/quotes/random")
          .then()
             .statusCode(200)
             .header("Quote-Author", not(emptyOrNullString()))
             .body(is(not(emptyOrNullString())));
    }

}