package com.example.sample1app;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* -------デフォルトのアプリケーション-------------*/
//@SpringBootApplication
//public class SampleBootApp1Application {
//
//	public static void main(String[] args) {
//		//SpringApplicationクラスはSpringBootアプリケーションとしての基本的機能がまとめられている。
//		//		runはアプリケーションを起動するためのメソッド
//		//		引数には実行するクラスのClassインスタンスとパラメータとして渡すデータ
//		//		いまのところ、＠SpringBootApplicationを付けたクラスをそのまま記述する。
//
//		//SpringApplicationインスタンスを生成
//		//引数として、アプリケーションとして実行するクラスを選択
//		//つまり、SpringBootApplicationアノテーションを付けたクラスのうち、実行したいクラスのClassインスタンスを引数として渡す
//		//今回はSampleBootApp1ApplicationのClassインスタンスを引数として渡す
//		SpringApplication app = new SpringApplication(SampleBootApp1Application.class);
//		//setBannerModeをオフに設定することで、SprinApplicationの起動時の処理をカスタマイズできる。
//		app.setBannerMode(Mode.OFF);
//		app.run(args);
//		//SpringApplication.run(SampleBootApp1Application.class, args);
//	}
//
//}

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

	@RequestMapping("/")
	public String index() {
		return "Hello, My Spring Boot 3!!!";
	}

	/* -------RESTControllerの実装例2-------------*/
	String[][] data = {
			{ "noname", "no email address", "0" },
			{ "taro", "taro@exam.com", "39" },
			{ "hanako", "hanako@exam.com", "28" },
			{ "jiro", "jiro@exam.com", "17" },

	};

	@GetMapping("/{num}")
	public String index(@PathVariable int num) {
		int n = num < 0 ? 0 : num >= data.length ? 0 : num;
		String[] item = data[n];
		String msg = "ID=%s, {name: %s, mail: %s, age: %s}";
		return String.format(msg, num, item[0], item[1], item[2]);

	}

}
