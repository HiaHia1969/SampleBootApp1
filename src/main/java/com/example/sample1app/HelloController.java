package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		model.addAttribute("msg1", "デモメッセージです");
		return "button";
	}

	@RequestMapping("/{num}")
	public ModelAndView num(@PathVariable int num, ModelAndView mav) {
		int res = 0;
		for (int i = 0; i <= num; i++) {
			res += i;
		}

		mav.addObject("msg", num + "までの合計値を表示します。");
		mav.addObject("content", "total: " + res);
		mav.setViewName("num");
		return mav;
	}
}
