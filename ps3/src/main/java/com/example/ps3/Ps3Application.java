package com.example.ps3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootApplication
@RestController
public class Ps3Application {

	public static void main(String[] args) {
		SpringApplication.run(Ps3Application.class, args);
	}

	@GetMapping("/")
	public void getGif(HttpServletResponse response) throws IOException {
		ClassPathResource gifFile = new ClassPathResource("/static/images/love.gif");
		response.setContentType("image/gif");
		StreamUtils.copy(gifFile.getInputStream(), response.getOutputStream());
	}
}
