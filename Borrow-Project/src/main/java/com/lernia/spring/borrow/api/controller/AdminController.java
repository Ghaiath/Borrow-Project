package com.lernia.spring.borrow.api.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lernia.spring.borrow.api.model.Borrow;
import com.lernia.spring.borrow.api.model.Borrow.Status;
import com.lernia.spring.borrow.api.repository.BorrowRepository;
import com.lernia.spring.borrow.api.service.BorrowService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	HttpSession session;

	@Autowired
	private BorrowRepository borrowRepository2;

	@Autowired
	BorrowService borrowService;

	@GetMapping("/show-all-borrows")
	public String showAllBorrows(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Borrow> allBorrows = borrowService.showAllborrows();
		request.setAttribute("borrows", allBorrows);
		return "/allborrows";
	}

	@GetMapping("/approve-borrow")
	public String approveBorrow(int id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Borrow borrow = borrowRepository2.getOne(id);
		borrow.setStatus(Status.APPROVED.toString());
		borrowRepository2.save(borrow);
		return "redirect:show-all-borrows";
	}

	@GetMapping("/reject-borrow")
	public String rejecteBorrow(int id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Borrow borrow = borrowRepository2.getOne(id);
		borrow.setStatus(Status.REJECTED.toString());
		borrowRepository2.save(borrow);
		return "redirect:show-all-borrows";
	}
	
	@GetMapping("/show-all-approved")
	public String getAllApproved(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Borrow> allBorrows = borrowService.showAllApproved();
		request.setAttribute("borrows", allBorrows);
		return "/allborrows";
	}
	
	@GetMapping("/show-all-rejected")
	public String getAllRejected(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Borrow> allBorrows = borrowService.showAllRejected();
		request.setAttribute("borrows", allBorrows);
		return "/allborrows";
	}
	
	@GetMapping("/show-all-pendings")
	public String getAllPendings(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Borrow> allBorrows = borrowService.showAllPendings();
		request.setAttribute("borrows", allBorrows);
		return "/allborrows";
	}

	@GetMapping("/admin-dashboard")
	public String showDashboard(HttpServletRequest request, HttpServletResponse response) {
		return "admindashboard";

	}

}
