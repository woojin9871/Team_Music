package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.domain.ManGeneration;
import com.team.mapper.ManGenerationMapper;

@Service
public class ManGenerationServiceImpl implements ManGenerationService {

	@Autowired
	private ManGenerationMapper mapper;

	@Override
	public List<ManGeneration> list() throws Exception {

		return mapper.list();
	}
}
