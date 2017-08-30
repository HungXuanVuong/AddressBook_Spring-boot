package com.hung.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController implements ErrorController {

	private static final String PATH = "/error";

	@Override
	public String getErrorPath() {
		return PATH;
	}
	
	@RequestMapping("/error")
	public String error(){
		return "NO Mapping available.";
	}
}
