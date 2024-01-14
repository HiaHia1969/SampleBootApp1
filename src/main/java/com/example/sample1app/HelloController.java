package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.addObject("msg", "e-mailを記入してください。");
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView form(@RequestParam("text1") String str, ModelAndView mav) {
		mav.addObject("msg", "あなたのメールアドレスは「" + str + "」ですね。");
		mav.addObject("value", str);
		mav.setViewName("index");
		return mav;
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
