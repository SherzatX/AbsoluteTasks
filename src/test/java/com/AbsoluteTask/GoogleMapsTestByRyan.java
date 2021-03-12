package com.AbsoluteTask;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

public class GoogleMapsTestByRyan {


    @BeforeAll
    public static void setUp() {
        baseURI = "https://maps.googleapis.com/maps";
        basePath = "/api";

    }

    @Test
    public void getRequest() {

        RestAssured
                .get("https://maps.googleapis.com/maps/api/distancematrix/json?origins=Seattle&destinations=San+Francisco&key=AIzaSyCNG4SYk4NC0suUb06ig7Vh5n3hhZNxyRc").
        then(). assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("destination_addresses", contains("San Francisco, CA, USA")).
                body("rows[0].elements[0].distance.value", equalTo(1299823));


    }


}
