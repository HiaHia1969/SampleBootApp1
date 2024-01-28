package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	private boolean flag = false;

	@GetMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		flag = !flag;

		mav.addObject("flag", flag);
		mav.addObject("msg", "TOPページです。");
		mav.addObject("alert_msg", "アラートメッセージです。");
		mav.addObject("card_msg", "カードメッセージです。");
		return mav;
	}
}
