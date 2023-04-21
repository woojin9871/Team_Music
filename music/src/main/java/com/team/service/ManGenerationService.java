package com.team.service;

import java.util.List;

import com.team.domain.ManGeneration;

public interface ManGenerationService {

	// 세대별 음악 목록
	public List<ManGeneration> list() throws Exception;
}
