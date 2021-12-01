package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
	

}
