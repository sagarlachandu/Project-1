package com.ers.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ers.model.Signup;

@Entity
@Table(name = "LoginCredential")
public class LoginCredentialsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loginId;
	@Column(nullable = false)
	private String userName;
	@Column(nullable = false)
	private String passWord;
	@OneToOne(targetEntity = SignupEntity.class)
	@JoinColumn(name = "email", nullable = false, unique = true)
	private SignupEntity user;

	public LoginCredentialsEntity() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public SignupEntity getUser() {
		return user;
	}

	public void setUser(SignupEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LoginCredentialsEntity [loginId=" + loginId + ", userName=" + userName + ", passWord=" + passWord
				+ ", user=" + user + "]";
	}

	

}