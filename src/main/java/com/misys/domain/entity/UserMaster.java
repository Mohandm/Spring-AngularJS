package com.misys.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER_MASTER")
@SequenceGenerator(name = "SEQ_USER_MASTER")
public class UserMaster extends AuditableEntity implements BaseEntity,Serializable {
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_USER_MASTER")
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long userId;
	
	@Column(length = 35)
	private String email;
	
	@Column(length = 60)
	private String password;
	
	@Column(length = 2)
	private String status;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
