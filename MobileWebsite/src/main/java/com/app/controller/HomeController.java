package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	public HomeController() {
		System.out.println("In constructor of" + getClass().getName());
	}
	
	@RequestMapping("/")
	public String showWelcomePage() {
		System.out.println("in welcome page");
		//return "/Home/index";
		return "redirect:/Home";
	}
	@GetMapping("/logout")
	public String userLogout(HttpSession hs, Model map, HttpServletRequest request, 
			HttpServletResponse response) {
		System.out.println("in  logout");
		// get user dtls from session scope n add it under model attribute
		map.addAttribute("user_details", hs.getAttribute("user_dtls"));
		// invalidate HttpSession
		hs.invalidate();
		//set refresh header of HTTP resp
		//response.setHeader("refresh", "5;url="+request.getContextPath());
		return "redirect:/";// forward view name : /WEB-INF/view/user/logout.jsp
	}
}
