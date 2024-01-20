package com.example.sample1app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/button")
	public String button(Model model) {
		model.addAttribute("msg",
				"buttonのページです");
		model.addAttribute("msg1", "デモメッセージです");
		return "button";
	}

	@GetMapping("/{num}")
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

	@GetMapping("/otherform")
	public ModelAndView otherform(ModelAndView mav) {
		mav.addObject("msg", "please input each form section");
		mav.setViewName("/otherform");
		return mav;
	}

	@PostMapping("/otherform")
	public ModelAndView otherform(
			@RequestParam(value = "check1", required = false) boolean check1,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "select1", required = false) String OS,
			@RequestParam(value = "select2", required = false) String[] phones,
			ModelAndView mav) {

		String res = "";
		StringBuilder selectStr = new StringBuilder();
		List<String> arrayList = new ArrayList<String>(Arrays.asList(phones));
		arrayList.replaceAll((phone) -> phone += ", ");
		((ArrayList<String>) arrayList).trimToSize();
		//例外処理
		try {
			res = String.format("check: %b radio: %s select: %s select2: ", check1, gender, OS);
		} catch (NullPointerException e) {
		}

		//例外処理
		try {
			//			for (String phone : phones) {
			//				selectStr += String.format("%s, ", phone);
			//			}
			if (phones.length > 0) {

				arrayList.forEach(phone -> {
					selectStr.append(phone);
					//					selectStr.append(", ");
				});
				res += selectStr.toString();
			}

		} catch (Exception e) {
			res = "null";
		}

		mav.addObject("msg", res);
		mav.setViewName("/otherform");
		return mav;
	}

	@GetMapping("/other")
	public String other() {
		return "redirect:/";
	}

	@GetMapping("/home")
	public String home() {
		return "forward:/";
	}

	@GetMapping("/otherform2")
	public ModelAndView oh2(ModelAndView mav) {
		return new ModelAndView("redirect:/otherform");
	}

	@GetMapping("/otherform3")
	public ModelAndView oh3(ModelAndView mav) {
		return new ModelAndView("forward:/otherform");
	}

}
