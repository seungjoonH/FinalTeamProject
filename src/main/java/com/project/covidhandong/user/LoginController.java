package com.project.covidhandong.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	UserServiceImpl service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login/login";
	}

	@RequestMapping(value = "/loginok", method = RequestMethod.POST)
	public String loginCheck(HttpSession session, UserVO vo) {
		String returnURL = "";
		if (session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		UserVO loginvo = service.getUser(vo);
		if (loginvo != null) {
			System.out.println("[INFO] '" + loginvo.getUsername() + "' Logged In");
			session.setAttribute("login", loginvo);
			returnURL = "redirect:/board/list";
		} 
		else {
			System.out.println("[ERROR] Login Failed");
			returnURL = "redirect:/login/login";
		}
		return returnURL;
	}

	// 로그아웃 하는 부분 
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, UserVO vo) {
		UserVO loginvo = service.getUser(vo);
		session.invalidate();
		System.out.println("[INFO] '" + loginvo.getUsername() + "' Logged Out");
		return "redirect:/login/login";
	}
}