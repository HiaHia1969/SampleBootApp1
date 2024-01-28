package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	private boolean flag = false;
	String data[] = { "Windows", "macOS", "Linux", "ChromeOS" };
	String data2[] = { "Android", "iPhone", "Xiaomi" };

	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {
		flag = !flag;
		mav.setViewName("index");
		mav.addObject("title", "Groovy templates");
		mav.addObject("msg", "レイアウト機能を使ったサンプルです。");
		mav.addObject("flag", flag);
		mav.addObject("data", data);
		mav.addObject("data2", data2);
		return mav;
	}

}
