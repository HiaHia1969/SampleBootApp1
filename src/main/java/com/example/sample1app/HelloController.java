package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/{temp}")
	public String other(@PathVariable String temp) {
		switch (temp) {
		case "index":
			return "index";
		case "other":
			return "other";
		default:
			return "error";
		}
	}

}
