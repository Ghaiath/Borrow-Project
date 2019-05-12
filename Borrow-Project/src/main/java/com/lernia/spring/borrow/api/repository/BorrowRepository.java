package com.lernia.spring.borrow.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lernia.spring.borrow.api.model.Borrow;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Integer> {

	@Query(value = "SELECT * FROM borrow_requests WHERE borrow_id = ?1", nativeQuery = true)
	public List<Borrow> findAllByborrow_id(int id);

	public List<Borrow> findAllByUserName(String user_name);

	public List<Borrow> findAllByStatus(String string);

}
