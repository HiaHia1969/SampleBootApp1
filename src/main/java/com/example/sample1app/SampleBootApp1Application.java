package com.example.sample1app;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;

/* -------デフォルトのアプリケーション-------------*/
@SpringBootApplication
@RestController
public class SampleBootApp1Application {

	public static void main(String[] args) {
		//		SpringApplication.run(SampleBootApp1Application.class, args);

		SpringApplication app = new SpringApplication(SampleBootApp1Application.class);
		app.setBannerMode(Mode.OFF);
		app.run(args);

	}

	/* -------RESTControllerの実装例2-------------*/
	DataObject[] data = {
			new DataObject("noname", "no email address", 0),
			new DataObject("taro", "taro@exam.com", 39),
			new DataObject("hanako", "hanako@exam.com", 28),
			new DataObject("jiro", "jiro@exam.com", 17)
	};

	@RequestMapping("/")
	public String index(HttpServletRequest req, HttpServletResponse res) {

		res.setContentType(MediaType.TEXT_HTML_VALUE);
		String context = """
				<html>
					<head>
						<title>Sample App</title>
					</head>
					<body>
						<h1>Sample App</h1>
						<p>This is sample page!!!</p>
					</body>
				</html>
				""";
		return context;
	}
}

@Data
class DataObject {
	private final String name;
	private final String mail;
	private final int age;

}
