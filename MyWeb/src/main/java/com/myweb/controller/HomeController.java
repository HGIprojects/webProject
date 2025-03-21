package com.myweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myweb.service.HomeService;

import jakarta.servlet.http.HttpServletRequest;


////////////////////////////////////////////////////////////////////////////
// URL: http://localhost:8080/
////////////////////////////////////////////////////////////////////////////

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	HomeService homeServicer;
	

	@GetMapping({"","/"})
	public String homePage(HttpServletRequest request, Model model) {

		return homeServicer.homePageInitialize(request, model);
	}
}
