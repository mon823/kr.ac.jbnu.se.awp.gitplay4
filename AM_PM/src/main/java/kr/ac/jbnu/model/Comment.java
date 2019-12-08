package kr.ac.jbnu.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "commentno")
	private Integer commentno;
	
	@Column(name = "articleno")
	private String articleno;
	
	@Column(name = "memo")
	private String memo;
	
	@Column(name = "regdate")
	private Timestamp regdate;
	
	@Column(name = "username")
	private String username;
	
	public Integer getCommentno() {
		return commentno;
	}
	public void setCommentno(Integer commentno) {
		this.commentno = commentno;
	}
	public String getArticleno() {
		return articleno;
	}
	public void setArticleno(String articleno) {
		this.articleno = articleno;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
