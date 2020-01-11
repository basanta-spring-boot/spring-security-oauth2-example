package com.javatechie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class SpringLoginApplication {

    Logger logger = LoggerFactory.getLogger(SpringLoginApplication.class);

    @GetMapping("/")
    public String welcome(Principal principal) {
        Map<String, Object> details = (Map<String, Object>) ((OAuth2Authentication) principal).getUserAuthentication().getDetails();
        logger.info("Map data {}", details);
        return "Hi " + details.get("name") + " Logged in successfully , now can access our application !!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringLoginApplication.class, args);
    }

}
