package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.model.Admin;


public interface AdminRepository extends JpaRepository<Admin,Integer>{

	@Query(value="Select a from Admin a where a.adminId = :adminId And a.password = :password")
	public Admin validateAdmin(@Param("adminId") Integer adminId ,@Param("password") String password);
}
