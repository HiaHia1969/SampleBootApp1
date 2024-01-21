package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@GetMapping("/")
	public ModelAndView index(ModelAndView mav) {

		String htmlMsg = """
				<div class="border border-danger">
					<h2>Message</h2>
					<p>This is sample message!</p>
				</div>
				""";

		mav.setViewName("index");
		mav.addObject("msg", "メッセージだよ");
		mav.addObject("msg2", htmlMsg);
		return mav;
	}
}
