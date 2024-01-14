package com.example.sample1app;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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

	/**
	 * URLに数字を付け、数字が0以上かつdata配列の長さ以下であればそのdataのnum番目のオブジェクトを返す。
	 *
	 * @param num 取り出したい番号
	 * @return data[num] dataに格納されているDataObject型を返す
	 */
	@RequestMapping("/{num}")
	public DataObject num(@PathVariable int num) {
		int n = num < 0 ? 0 : (num >= data.length ? 0 : num);
		return data[num];
	}

	@RequestMapping("/person/{num}")
	public String person(@PathVariable int num) {
		int n = num < 0 ? 0 : (num >= data.length ? 0 : num);
		DataObject person = data[num];
		String str = """
				名前：　%s \n
				Mail　%s \n
				年齢　%d
				""";
		return String.format(str, person.getName(), person.getMail(), person.getAge());
	}
}

@Data
class DataObject {
	private final String name;
	private final String mail;
	private final int age;

}
