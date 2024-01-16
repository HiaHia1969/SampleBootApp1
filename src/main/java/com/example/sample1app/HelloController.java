package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@GetMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.addObject("msg", "e-mailを記入してください。");
		mav.setViewName("index");
		return mav;
	}

	@PostMapping("/")
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

	@GetMapping("/name")
	public ModelAndView name(ModelAndView mav) {
		mav.addObject("msg", "名前を書いてください");
		return mav;
	}

	@PostMapping("/name")
	public ModelAndView name(ModelAndView mav, @RequestParam("text1") String str) {
		String msg = String.format("あなたの名前は%sですね。", str);

		mav.addObject("msg", msg);
		mav.addObject("value", str);
		mav.setViewName("name");
		return mav;
	}

}
