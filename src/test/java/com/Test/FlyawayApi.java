package com.Test;

import io.restassured.config.RedirectConfig;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FlyawayApi {
	public static void main(String[] args) {
// TODO Auto-generated method stub
		String URL = "http://localhost:8080/FlyAway";
		io.restassured.RestAssured.baseURI = URL;
		String UN = "reravich@cisco.com";
		String PWD = "Test123";
		RequestSpecification given = io.restassured.RestAssured.given().config(
				io.restassured.RestAssured.config().redirect(RedirectConfig.redirectConfig().followRedirects(false)));

		Response response = given.request(Method.POST, "/loginaction?email_id=" + UN + "&pwd=" + PWD);
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());

		Response response2 = given.request(Method.GET, "/dashboard");
		System.out.println(response2.getBody().asString());
		System.out.println(response2.getStatusCode());
	}
}