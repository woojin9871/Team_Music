package com.team.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team.domain.ManGeneration;
import com.team.service.ManGenerationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ManGenerationController {

	@Autowired
	private ManGenerationService service;

	@GetMapping("/generation/manGeneration")
	public String list(Model model) throws Exception {
		
		List<ManGeneration> manGenerationList = service.list();
		
		log.info("list : " + manGenerationList);
		model.addAttribute("manGenerationList", manGenerationList);
		
		return "/generation/manGeneration";
	}

}
