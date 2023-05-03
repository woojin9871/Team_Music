package com.team.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.team.domain.WomanGeneration;
import com.team.mapper.WomanGenerationMapper;
import com.team.service.WomanGenerationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WomanGenerationController {
	
	@Autowired
	private WomanGenerationService service;
	
	@Autowired
	private WomanGenerationMapper mapper;

	@GetMapping("/generation/womanGeneration")
	public String list(Model model) throws Exception {
		
		List<WomanGeneration> womanGenerationList = service.list();
		
		log.info("list : " + womanGenerationList);
		model.addAttribute("womanGenerationList", womanGenerationList);
				
		return "/generation/womanGeneration";
	}

	@GetMapping("/generation/womanGeneration/{womanGeneration}")
	public String getMusicByGeneration(@PathVariable("womanGeneration") String womanGeneration, Model model) {
	    List<WomanGeneration> womanGenerationList = mapper.selectMusicByWomanGeneration(womanGeneration);
	    model.addAttribute("womanGenerationList", womanGenerationList);
	    return "generation/musicByWomanGeneration :: musicByWomanGenerationContainer";
	}
}
