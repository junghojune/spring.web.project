package com.hosu.spring.web.project.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class indexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void load_MainPage(){
        String body = this.restTemplate.getForObject("/", String.class);
        System.out.println("안녕하세요");
        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }
}