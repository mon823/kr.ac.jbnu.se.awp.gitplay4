package kr.ac.jbnu.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.type.DateType;

@Entity
@Table(name = "noticeboard")
public class Noticeboard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "articleno")
	private Integer articleno;

	@Column(name = "board_type")
	private String board_type;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "context",length = 65535, columnDefinition = "text")
	private String context;
	
	@Column(name = "regdate")
	private Timestamp regdate;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "no_view")
	private Integer no_view;
	
	
	public Integer getArticleno() {
		return articleno;
	}

	public void setArticleno(Integer articleno) {
		this.articleno = articleno;
	}

	public String getBoard_type() {
		return board_type;
	}

	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
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

	public Integer getNo_view() {
		return no_view;
	}

	public void setNo_view(Integer no_view) {
		this.no_view = no_view;
	}
}
