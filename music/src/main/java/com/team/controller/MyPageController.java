 package com.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyPageController {

	@GetMapping("/myPage/myPage")
	public String main() {
		
		return "/myPage/myPage";
	}
}
