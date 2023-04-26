package com.team.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.team.domain.MusicUserAuth;
import com.team.domain.MusicUsers;

@Mapper
public interface MusicUserMapper {

	public int join(MusicUsers user) throws Exception;
	
	public int insertAuth(MusicUserAuth userAuth) throws Exception;
	
    // 아이디 중복 확인
    public int checkUserId(String userId) throws Exception;
	
}
