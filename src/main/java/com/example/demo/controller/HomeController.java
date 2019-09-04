package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {		
		return "HELLO!!!";
	}
		
	@RequestMapping("login")
	public ModelAndView homePage(
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			ModelAndView modelAndView) {
		
				System.out.println("Hello");
				
				modelAndView.setViewName("home");
				modelAndView.addObject("username", name);
				modelAndView.addObject("age", age);
				
				return modelAndView;
			}
	
	@RequestMapping("about")
	public String aboutPage(HttpServletRequest req, HttpServletResponse res) {
	
		return "about";
	}
	
	
	
}
