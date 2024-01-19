package com.web.service;

import com.web.vo.UserVO;

public interface UserService {
	
	// 회원가입
	public void register(UserVO vo) throws Exception;
	
	// id중복 체크(회원가입)
	public int idChk(UserVO vo) throws Exception;
	
	// 닉네임 중복 체크(회원가입)
	public int nicknameChk(UserVO vo) throws Exception;
	
	// 로그인
	public UserVO login(UserVO vo) throws Exception;
	
	// 회원정보 수정
	public void userUpdate(UserVO vo) throws Exception;
		
	// 회원 탈퇴
	public void userDelete(UserVO vo) throws Exception;
	
	// 패스워드 체크
	public int passChk(UserVO vo) throws Exception;
		
		

}
