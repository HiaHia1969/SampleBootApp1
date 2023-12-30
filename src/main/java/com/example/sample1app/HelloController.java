package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping("/{num}")
	public String num(@PathVariable int num, Model model) {
		int res = 0;
		//		for (int i = 1; i <= num; i++) {
		//			res += i;
		//		}
		while (res < num) {
			res++;
		}

		model.addAttribute("msg",
				"total: " + res);
		return "num";
	}
}
