package com.example.Patika.PatikaWeek4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PatikaWeek4ApplicationTests {

	@LocalServerPort
	protected int serverPort;

	@Autowired
	protected TestRestTemplate testRestTemplate;

	@Test
	void contextLoads() {
	}

}
