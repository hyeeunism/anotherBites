package com.web.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.web.dao.UserDAO;
import com.web.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject UserDAO dao;

	@Override
	public void register(UserVO vo) throws Exception {
		dao.register(vo);
	}
	
	// 아이디 중복 체크
		@Override
		public int idChk(UserVO vo) throws Exception {
			int result = dao.idChk(vo);
			return result;
		}
		
	// 닉네임 중복 체크
		@Override
		public int nicknameChk(UserVO vo) throws Exception {
			int result = dao.nicknameChk(vo);
			return result;
		}
		
	// 회원정보 수정
	@Override
	public void userUpdate(UserVO vo) throws Exception {
		dao.userUpdate(vo);
	}
		
	// 회원 탈퇴
	public void userDelete(UserVO vo) throws Exception {
		dao.userDelete(vo);
	}
	
	// 패스워드 체크
	@Override
	public int passChk(UserVO vo) throws Exception {
		int result = dao.passChk(vo);
		return result;
	}

	// 로그인
		@Override
		public UserVO login(UserVO vo) throws Exception {
			System.out.println("svsimpl");
			System.out.println(vo);
			return dao.login(vo);
		}

}
