package com.redhat.example;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

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

@Epic("Calculator API Tests")
@Feature("Validate whether all the Calculator APIs are working well")

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApiTest {

    @Test
    @Order(1)
    @Story("Testing the calculator's subtract API")
    @Description("Given Calculator is asked to do addition of 5 and 3  <br />"+
            "When calculate API is being hit with that values  <br />"+
            "Then API will return 8"
    )
    @DisplayName("This test is to check if submitting addition API with two values will work as expected")
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
    @Story("Testing the calculator's subtract API ")
    @Description("Given Calculator is asked to do subtract of 5 and 3 <br />"+
            "When calculate API is being hit with that values <br />"+
            "Then API will return 2"
    )
    @DisplayName("This test is to check if submitting subtract API with two values will work as expected")
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
    @Story("Testing the calculator's multiplication API  ")
    @Description("Given Calculator is asked to do multiply of 2 and 3 <br />"+
            "When calculate API is being hit with that values <br />"+
            "Then API will return 6"
    )
    @DisplayName("This test is to check if submitting multiplication API with two values will work as expected")
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
    @Story("Testing the calculator's division API  ")
    @Description("Given Calculator is asked to do division of 4 and 2 <br />"+
            "When calculate API is being hit with that values <br />"+
            "Then API will return 2"
    )
    @DisplayName("This test is to check if submitting division API with two values will work as expected")
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
    @Story("Testing the calculator's result history API  ")
    @Description("Given Calculator API is hit 4 times <br />"+
            "When Result API is being hit <br />"+
            "Then API will return 4 transactions, with a correct detail for each API transactions"
    )
    @DisplayName("This test is to check if submitting division API with two values will work as expected")
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
