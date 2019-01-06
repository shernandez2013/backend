package com.silvano.demo;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController  implements ErrorController {
	private final static String PATH = "/error";

	@RequestMapping("/")
	public String getIndexPage() {
		return "index";
	}

	@RequestMapping(PATH)
	@ResponseBody
	public String getErrorPath() {
		return "No Mapping Found";
	}
}
