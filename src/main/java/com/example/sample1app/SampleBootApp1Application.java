package com.example.sample1app;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* -------デフォルトのアプリケーション-------------*/
@SpringBootApplication
public class SampleBootApp1Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SampleBootApp1Application.class);
		app.setBannerMode(Mode.OFF);
		app.run(args);

	}

}
