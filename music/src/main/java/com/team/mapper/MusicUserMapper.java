package com.team.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.team.domain.MusicUserAuth;
import com.team.domain.MusicUsers;

@Mapper
public interface MusicUserMapper {

	public int join(MusicUsers user) throws Exception;
	
	public int insertAuth(MusicUserAuth userAuth) throws Exception;
	
	public int profile(MusicUsers profile) throws Exception;
	
    // 아이디 중복 확인
    public int checkUserId(String userId) throws Exception;
    
    // 프로필 사진
    public int getProfileById(String userId);

    // 프로필 수정
    public int updateProfile(@Param("userId") String userId, @Param("profile") int profile);
    
}
