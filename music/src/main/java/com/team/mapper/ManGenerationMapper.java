package com.team.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.domain.ManGeneration;

@Mapper
public interface ManGenerationMapper {

	// 세대별 음악 목록
	public List<ManGeneration> list() throws Exception;
	
	public List<ManGeneration> selectMusicByManGeneration(String manGeneration);
}
