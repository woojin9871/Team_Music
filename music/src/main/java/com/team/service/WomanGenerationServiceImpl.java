package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.domain.WomanGeneration;
import com.team.mapper.WomanGenerationMapper;

@Service
public class WomanGenerationServiceImpl implements WomanGenerationService {

	@Autowired
	private WomanGenerationMapper mapper;

	@Override
	public List<WomanGeneration> list() throws Exception {

		return mapper.list();
	}
}
