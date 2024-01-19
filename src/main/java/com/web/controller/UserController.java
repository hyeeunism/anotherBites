package com.web.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.service.UserService;
import com.web.vo.UserVO;

@Controller
@RequestMapping("/user/*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	UserService service;
	
	@Inject
	BCryptPasswordEncoder pwdEncoder;
	
	
	// 회원가입폼으로 이동 GET | 회원가입 버튼 눌렀을 때 POST

	// 회원가입 Get
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getRegister() throws Exception {
		logger.info("get register");
	}
	
	// 회원가입 Post
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(UserVO vo) throws Exception {
		logger.info("post register");
	int result = service.idChk(vo);
		try {
			if(result == 1) {
				return "/user/register";
			} else if (result == 0) {
				String inputPass = vo.getUserPass();
				String pwd = pwdEncoder.encode(inputPass);
				vo.setUserPass(pwd);
				service.register(vo);
				
			}
			// 존재 -> 다시 회원가입 페이지 / 존재 X -> register
		} catch (DuplicateKeyException e) { // 유일성 제약 조건 위배 시 예외 처리
	        throw new RuntimeException("이미 존재하는 아이디입니다.");
	    }
	    return "redirect:/";
	}
	
	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		logger.info("post login");
		
		HttpSession session = req.getSession();
		UserVO member = service.login(vo);
		
		boolean pwdMatch;
		if(member != null) {
		pwdMatch = pwdEncoder.matches(vo.getUserPass(), member.getUserPass());
		} else {
		pwdMatch = false;
		}

		if(member != null && pwdMatch == true) {
		session.setAttribute("member", member);
		} else {
		session.setAttribute("member", null);
		rttr.addFlashAttribute("msg", false);
		}
		return "redirect:/";
		
	}
	
	
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/";
	}


	// 아이디 중복 체크(회원가입시)
	@ResponseBody
	@RequestMapping(value="/idChk", method=RequestMethod.POST)
	public int idChk(UserVO vo) throws Exception {
		int result = service.idChk(vo);
		return result;
	}
	
	// 닉네임 중복 체크(회원가입시)
	@ResponseBody
	@RequestMapping(value="/nicknameChk", method=RequestMethod.POST)
	public int nicknameChk(UserVO vo) throws Exception {
		int result = service.nicknameChk(vo);
		return result;
		}
	
	// 패스워드 체크
	@ResponseBody
	@RequestMapping(value="/passChk", method = RequestMethod.POST)
	public int passChk(UserVO vo) throws Exception {
		int result = service.passChk(vo);
		return result;
	}
	
	
	// 회원 탈퇴 Get
	@RequestMapping(value="/userDeleteView", method=RequestMethod.GET)
	public String userDeleteView() throws Exception {
		return "user/userDeleteView";
	}
	
	// 회원 탈퇴 Post
	@RequestMapping(value="/userDelete", method=RequestMethod.POST)
	public String memberDelete(UserVO vo, HttpSession session, RedirectAttributes rttr) throws Exception {

		service.userDelete(vo);
		session.invalidate();

		return "redirect:/";		
	}
	
	// 마이페이지
		@RequestMapping(value = "/myPage", method = RequestMethod.GET)
		public String goMyPage(UserVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
			logger.info("post myPage");
			
			HttpSession session = req.getSession();
			
			return "user/myPage";
			
		}
		
			// 회원정보수정 페이지 호출
			@RequestMapping(value = "/goUpdateInfo", method = RequestMethod.GET)
			public String goUpdateInfo(UserVO vo, HttpServletRequest req, RedirectAttributes rttr, ModelMap map) throws Exception {
				logger.info("get goUpdateInfo");
				
				HttpSession session = req.getSession();
				UserVO member = (UserVO) session.getAttribute("member");
				map.addAttribute("member", member);
				
				return "user/updateMemInfo";
					
			}
			
			// 회원정보 수정되면 세션 끊기고 로그인화면으로 이동. 수정된 비번으로 접속하면 로그인됨
			@RequestMapping(value="/userUpdate", method = RequestMethod.POST)
			public String registerUpdate(UserVO vo, HttpSession session) throws Exception {
				service.userUpdate(vo);
				
				session.invalidate();
				
				return "redirect:/";
			}
}