package com.cyh.sy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping("/admin/login")
	public String index(){ 
		return "login";
	}
	
}
