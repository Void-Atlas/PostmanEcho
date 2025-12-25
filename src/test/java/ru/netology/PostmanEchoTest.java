package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    void shouldEchoPostedData() {
        String sentData = "Привет! Как дела? :р";

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body(sentData)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Data"));
    }
}