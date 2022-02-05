package com.anz.account.details.blackbox;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.anz.account.details.Application;
import com.anz.account.details.ApplicationTest;
import com.anz.account.details.model.AccountTransactionRequest;

import io.restassured.RestAssured;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest(classes = { Application.class })
@Configuration
@Sql(scripts = { "/db/test_data/data_setup.sql" }, executionPhase = BEFORE_TEST_METHOD)
@Sql(scripts = { "/db/test_data/data_cleanup.sql" }, executionPhase = AFTER_TEST_METHOD)
public class AccountDetailsApiTest {

	public static final String X_CORRELATION_ID = "X_CORRELATION_ID";

	@BeforeAll
	static void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.basePath = "/account-details";
		RestAssured.port = 8090;
	}

	@Test
	void getAccountDetails_returnAllAccountDetails() {
		given().log().all().header(X_CORRELATION_ID, "Test_OK_1234").when().get("/v1/accounts/details").then()
				.log().all().statusCode(HttpStatus.SC_OK).body(containsString("347786244"));
	}

	@Test
	void getAccountTransactions_returnTransactionByAccountNo() {
		given().log().all().header(X_CORRELATION_ID, "Test_OK_1010").when()
				.get("/v1/accounts/847257972").then().log().all().statusCode(HttpStatus.SC_OK)
				.body(containsString("AUCurrent591"));
	}

	@Test
	void getAccountTransactions_returnTransactionByAccountNo_NoAccountFound() {
		given().log().all().header(X_CORRELATION_ID, "Test_OK_4321").when()
				.get("/v1/accounts/123").then().log().all()
				.statusCode(HttpStatus.SC_NO_CONTENT);
	}

}
