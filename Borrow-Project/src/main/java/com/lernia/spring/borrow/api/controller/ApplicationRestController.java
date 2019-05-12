package com.lernia.spring.borrow.api.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lernia.spring.borrow.api.model.Borrow;
import com.lernia.spring.borrow.api.service.BorrowService;

@RestController
public class ApplicationRestController {

	@Autowired
	private BorrowService borrowService;

	@GetMapping("/rest-get-all-borrows")
	public List<Borrow> findAllBorrows() {
		return borrowService.showAllborrows();
	}

	@GetMapping("/rest-get-all-approved")
	public List<Borrow> findAllApproved() {
		return borrowService.showAllApproved();
	}
	
	@GetMapping("/rest-get-all-pendings")
	public List<Borrow> findAllPendings() {
		return borrowService.showAllPendings();
	}

	@GetMapping("/rest-get-all-rejected")
	public List<Borrow> findAllRejected() {
		return borrowService.showAllRejected();
	}

	@GetMapping("/rest-get-one-borrow/{id}")
	public Borrow findOneBorrow(@PathVariable int id) {
		return borrowService.getBorrowByID(id);

	}

	@PostMapping("/rest-borrow-request")
	public Borrow registerBorrowRequest(@RequestBody Borrow borrow, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Samer " + borrow.toString());
		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);
		borrowService.saveMyborrowRequest(borrow);
		ModelAndView mv = new ModelAndView();
		mv.addObject("borrowRequest", borrow);
		mv.setViewName("");
		return borrow;
	}

}
