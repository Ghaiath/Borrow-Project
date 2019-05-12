package com.lernia.spring.borrow.api.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lernia.spring.borrow.api.model.Borrow;
import com.lernia.spring.borrow.api.repository.BorrowRepository;
import com.lernia.spring.borrow.api.service.BorrowService;

@Controller
public class ApplicationController {

	@Bean
	public BCryptPasswordEncoder encoderPWD() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	BorrowRepository borrowRepository;

	@Autowired
	BorrowService borrowService;

	@Autowired
	HttpSession session;

	@RequestMapping({ "/welcome", "/" })
	public String welcom(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	public class obteinUserSession {
		@RequestMapping(value = "/loginds", method = RequestMethod.GET)
		public String UserSession(ModelMap modelMap) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			System.out.println(auth.toString());
			String name = auth.getName();
			modelMap.addAttribute("username", name);
			return "hellos " + name;
		}
	}

	@RequestMapping(value = "/samer", method = RequestMethod.GET)
	public static HttpSession session() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		System.out.println("att  " + attr);
		return attr.getRequest().getSession(true); // true == allow create
	}

	@RequestMapping("/borrow")
	public String borrow(HttpServletRequest request, HttpServletRequest response) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "borrow";
	}

	@PostMapping("/borrow-request")
	public String registerBorrowRequest(@ModelAttribute Borrow borrow, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Samer " + borrow.toString());
		Map<String, String> messages = new HashMap<String, String>();
		if (bindingResult.hasErrors()){
			messages.put("error", "error");	
			messages.put("errorMessage", "Somthing went wrong, please try again or contact administrator");
			request.setAttribute("messages", messages);
		}
		messages.put("success", "success");
		messages.put("successMessage", "Your borrow request has been registered");
		request.setAttribute("messages", messages);
		borrowService.saveMyborrowRequest(borrow);
		ModelAndView mv = new ModelAndView();
		mv.addObject("borrowRequest", borrow);
		mv.setViewName("");
		return "redirect:my-dashboard";
	}

	@GetMapping("/show-my-borrows")
	public String getMyBorrows(@RequestParam String userName, HttpServletRequest request) {
		List<Borrow> myBorrows = borrowRepository.findAllByUserName(userName);
		request.setAttribute("borrows", myBorrows);
		return "myborrows";
	}

	@GetMapping("/my-dashboard")
	public String showDashboard(HttpServletRequest request, HttpServletResponse response) {
		return "dashboard";
	}
}