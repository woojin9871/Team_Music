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
	
	@PostMapping("/myPage/myPage")
	public String processEmotion(@RequestParam("emotion") String emotion) {
	    // 선택한 감정 값에 대한 처리 로직을 작성합니다.
	    // 예: 데이터베이스에 저장하거나 다른 작업 수행
	    
	    // 처리 완료 후 리다이렉트할 URL을 반환합니다.
	    return "redirect:/myPage/myPage";
	}
}
