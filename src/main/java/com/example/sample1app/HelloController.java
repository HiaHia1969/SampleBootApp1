package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("msg",
				"これはコントローラーに用意したメッセージです");
		return "index";
	}

	@RequestMapping("/button")
	public String button(Model model) {
		model.addAttribute("msg",
				"buttonのページです");
		return "button";
	}
}
