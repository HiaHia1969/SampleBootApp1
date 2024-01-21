package com.example.sample1app;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.samskivert.mustache.Mustache.Lambda;
import com.samskivert.mustache.Template.Fragment;

@Controller
public class HelloController {

	private boolean flag = false;

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

	@GetMapping("/condition")
	public ModelAndView condition(ModelAndView mav) {

		mav.setViewName("/condition");
		flag = !flag;
		mav.addObject("flag", flag);
		mav.addObject("msg", "メッセージを表示します");
		return mav;
	}

	@GetMapping("/repeat")
	public ModelAndView repeat(ModelAndView mav) {
		mav.setViewName("/repeat");

		MyData[] datas = new MyData[] {
				new MyData("aoi", 25),
				new MyData("hinata", 24),
				new MyData("yuna", 22),
				new MyData("kento", 16)
		};

		List<String> arrayList = new ArrayList<String>() {
			{
				add("One");
				add("Twe");
				add("Three");
				add("Four");
				add("Five");
			}
		};

		mav.addObject("data", arrayList);
		mav.addObject("data2", datas);
		mav.addObject("msg", "dataに格納されている要素を表示します");
		return mav;
	}

	@GetMapping("/lambda")
	public ModelAndView lambdaFormula(ModelAndView mav) {
		mav.setViewName("/lambda");
		mav.addObject("title", "ラムダ式のサンプル");
		mav.addObject("msg", "これはラムダ式を利用してメッセージを表示したものです。");

		Lambda fn = new Lambda() {
			@Override
			public void execute(Fragment frag, Writer out) throws IOException {
				out.write("<div class=\"alert alert-primary\">");
				frag.execute(out);
				out.write("</div>");
			}
		};
		mav.addObject("fn", fn);
		return mav;
	}

}
