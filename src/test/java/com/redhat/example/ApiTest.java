package com.redhat.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * <pre>
 *     com.redhat.example.ApiTest
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 28 Mar 2023 10:07
 */
@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApiTest {

    @Test
    @Order(1)
    public void testCalculateAddition() {
        given()
                .log().all()
                .when()
                .get("/api/calculate?value1=5&value2=3&method=addition")
                .then()
                .statusCode(200).log().all()
                .body("result", equalTo(8));
    }

    @Test
    @Order(2)
    public void testCalculateSubtraction() {
        given()
                .log().all()
                .when()
                .get("/api/calculate?value1=5&value2=3&method=subtraction")
                .then()
                .statusCode(200).log().all()
                .body("result", equalTo(2));
    }

    @Test
    @Order(3)
    public void testCalculateMultiplication() {
        given()
                .log().all()
                .when()
                .get("/api/calculate?value1=2&value2=3&method=multiplication")
                .then()
                .statusCode(200).log().all()
                .body("result", equalTo(6));
    }

    @Test
    @Order(4)
    public void testCalculateDivision() {
        given()
                .log().all()
                .when()
                .get("/api/calculate?value1=4&value2=2&method=division")
                .then()
                .statusCode(200).log().all()
                .body("result", equalTo(2));
    }


    @Test
    @Order(5)
    public void testGetAll() {
        given()
                .log().all()
                .when()
                .get("/api/results")
                .then()
                .statusCode(200).log().all()
                .body("size()", equalTo(4),
                        "id[0]", equalTo(4),
                        "id[3]", equalTo(1),
                        "method[3]", equalTo("addition"),
                        "total[3]", equalTo(8)
                        );
    }

}
