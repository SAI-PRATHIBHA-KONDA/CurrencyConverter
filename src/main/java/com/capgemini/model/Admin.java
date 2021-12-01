package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("admin")
@Scope(scopeName="prototype")
@Entity
@Table(name="ADMIN")
public class Admin {
	
	@Id
    @Column(name="ADMIN_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY )
	private Integer adminId;
	
	@Column
	private String password;
	
	public Admin() {
		
	}
	
	public Admin(Integer adminId, String password) {
		super();
		this.adminId = adminId;
		this.password = password;
	}
	
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", password=" + password + "]";
	}
	
	
}
