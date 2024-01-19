package com.web.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.web.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject SqlSession sql;
	
	// 회원가입
	@Override
	public void register(UserVO vo) throws Exception {
		sql.insert("userMapper.register", vo);
	}
	
			
	// 아이디 중복 체크
	@Override
	public int idChk(UserVO vo) throws Exception {
		int result = sql.selectOne("userMapper.idChk", vo);
			return result;
		}
	
	// 닉네임 중복 체크
	@Override
	public int nicknameChk(UserVO vo) throws Exception {
		int result = sql.selectOne("userMapper.nicknameChk", vo);
			return result;
		}
	
	// 패스워드 체크
		@Override
		public int passChk(UserVO vo) throws Exception {
			int result = sql.selectOne("userMapper.passChk", vo);
			return result;
		}
		
	// 로그인
	@Override
	public UserVO login(UserVO vo) throws Exception {	
		System.out.println("sql");
		System.out.println(vo);
		return sql.selectOne("userMapper.login", vo);
		
		}
	
	// 회원정보 수정
	@Override
	public void userUpdate(UserVO vo) throws Exception {
		sql.update("userMapper.userUpdate", vo);
		}

	// 회원 탈퇴
	@Override
	public void userDelete(UserVO vo) throws Exception {
		sql.delete("userMapper.userDelete", vo);
	}
	
}