package com.gatling;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class ProductSimulation extends Simulation {

    // Define the HTTP protocol configuration
    HttpProtocolBuilder httpProtocol = http
        .baseUrl("http://localhost:8080") // Set the base URL
        .acceptHeader("application/json")
        .contentTypeHeader("application/json");

    // Scenario: Define user actions
    ScenarioBuilder scn = scenario("Product Performance Test")
        // GET request to retrieve all products
        .exec(http("Get All Products")
            .get("/product")
            .check(status().is(200)))
        .pause(1) // Wait 1 second between requests
        // POST request to create a new product
        .exec(http("Create Product")
            .post("/product/create")
            .body(StringBody("{\"name\": \"Test Product\", \"price\": 25.0}")).asJson()
            .check(status().is(200)))
        .pause(1);

    // Load simulation setup
    {
        setUp(
            scn.injectOpen(
                atOnceUsers(10), // Start with 10 users immediately
                rampUsers(50).during(Duration.ofSeconds(30)) // Ramp up to 50 users over 30 seconds
            )
        ).protocols(httpProtocol);
    }
}

