package com.lernia.spring.borrow.api.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lernia.spring.borrow.api.model.Borrow;
import com.lernia.spring.borrow.api.repository.BorrowRepository;
import com.lernia.spring.borrow.api.model.Borrow.Status;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class BorrowService {

	public BorrowService() {
		super();
	}

	@Autowired
	private BorrowRepository borrowRepository;

	public List<Borrow> showAllborrows() {
		List<Borrow> borrows = new ArrayList<Borrow>();
		borrows = borrowRepository.findAll(); 	
		return borrows;
	}
	
	public List<Borrow> showAllApproved() {
		List<Borrow> borrows = new ArrayList<Borrow>();
		borrows = borrowRepository.findAllByStatus("APPROVED"); 	
		return borrows;
	}
	
	public List<Borrow> showAllRejected() {
		List<Borrow> borrows = new ArrayList<Borrow>();
		borrows = borrowRepository.findAllByStatus("REJECTED"); 	
		return borrows;
	}
	
	public List<Borrow> showAllPendings() {
		List<Borrow> borrows = new ArrayList<Borrow>();
		borrows = borrowRepository.findAllByStatus("PENDING"); 	
		return borrows;
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();

	}

	public void saveMyborrowRequest(Borrow borrow) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		borrow.setUserName(getUserIdFromPrinciple());
		borrow.setEligible(true);
		borrow.setRequestedDate(LocalDate.now());
		borrow.setRequestedTime(Instant.now());
		borrow.setStatus(Status.PENDING.toString());
		System.out.println(borrow.toString());
		System.out.println("DTF === " + dtf);
		System.out.println("NOW === " + now);
		borrowRepository.save(borrow);
	}

	public String getUserIdFromPrinciple() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		return name;
	}

	public Borrow getBorrowByID(long id) {
		return borrowRepository.findById((int) id).orElseThrow(() -> new EntityNotFoundException("id"));

	}

}
