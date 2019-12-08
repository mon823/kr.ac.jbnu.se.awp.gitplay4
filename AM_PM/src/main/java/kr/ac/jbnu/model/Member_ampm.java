package kr.ac.jbnu.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.type.DateType;


@Entity
@Table(name = "member_ampm")
public class Member_ampm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "idx")
	private Integer idx;
	
	@Column(name = "userid")
	private Integer userid;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "regtime")
	private Timestamp regtime;
	
	@Column(name = "regip")
	private String regip;
	
	@Column(name = "logtime")
	private Timestamp logtime;
	
	@Column(name = "logip")
	private String logip;
	
	@Column(name = "pass_change")
	private Timestamp pass_change;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "is_super")
	private IsSuper is_super;
	
	@Column(name = "tel")
	private String tel;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "grad")
	private Grad grad;
	
	public Integer getIdx() {
		return idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Timestamp getRegtime() {
		return regtime;
	}
	public void setRegtime(Timestamp regtime) {
		this.regtime = regtime;
	}
	public String getRegip() {
		return regip;
	}
	public void setRegip(String regip) {
		this.regip = regip;
	}
	public Timestamp getLogtime() {
		return logtime;
	}
	public void setLogtime(Timestamp logtime) {
		this.logtime = logtime;
	}
	public String getLogip() {
		return logip;
	}
	public void setLogip(String logip) {
		this.logip = logip;
	}
	public Timestamp getPass_change() {
		return pass_change;
	}
	public void setPass_change(Timestamp pass_change) {
		this.pass_change = pass_change;
	}
	public IsSuper getIs_super() {
		return is_super;
	}
	public void setIs_super(IsSuper is_super) {
		this.is_super = is_super;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	public Grad getGrad() {
		return grad;
	}
	public void setGrad(Grad grad) {
		this.grad = grad;
	}
	
}
