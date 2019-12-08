package kr.ac.jbnu.hibernate;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import kr.ac.jbnu.model.Comment;
import kr.ac.jbnu.model.Grad;
import kr.ac.jbnu.model.IsSuper;
import kr.ac.jbnu.model.Member_ampm;
import kr.ac.jbnu.model.Noticeboard;
import kr.ac.jbnu.model.Noticeboard_type;
import kr.ac.jbnu.model.Status;

public class App {
	public static void main(String[] args) {
		Member_ampm mem = new Member_ampm();
		Noticeboard_type nt = new Noticeboard_type();
		
		nt.setBoard_type("1");
		nt.setBoard_name("test");
		createNotice_type(nt);
		mem.setEmail("mon823@naver.com");
		mem.setGrad(Grad.valueOf("grade3"));
		mem.setIs_super(IsSuper.valueOf("Y"));
		mem.setTel("01028510657");
		mem.setStatus(Status.valueOf("S"));
		mem.setLogip("221159128205");
		mem.setRegip("221159128205");
		mem.setPassword("mon0607");
		mem.setUsername("¹®¼®¾Ï");
		mem.setUserid(201710565);
		mem.setLogtime(new Timestamp(2019, 12, 07, 15, 05, 30, 0));
		mem.setRegtime(new Timestamp(2019, 12, 07, 15, 05, 30, 0));
		mem.setPass_change(new Timestamp(2019, 12, 07, 15, 05, 30, 0));
		//10/13
		//createMember(mem);
		//deleteAll();
		//mem.setUsername("test");
		//updateMember(mem);
		
		//System.out.println("[System.out]" + readMember().get(1).getUsername());
		/*
		System.out.println("[System.out] " +" =======CREATE =======");
		create(em1);
		create(em2);
		create(em3);
		System.out.println("[System.out] " +" =======READ =======");
		List<Employee> ems1 = read();
		for (Employee e : ems1) {
			System.out.println(e.toString());

		}
		System.out.println("[System.out] " +" =======UPDATE =======");
		em1.setAge(44);
		em1.setName("Mary Rose");
		update(em1);
		System.out.println("[System.out] " +" =======DELETE ======= ");
		delete(em2.getId());
		*/
	}
	
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	
	public static void deleteComment(Integer commentno) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Comment c = findByCommentNo(commentno);
		session.delete(c);
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out]" + "test Comment delete");	
	}
	
	public static void deleteMember(Integer idx) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Member_ampm m = findByMember(idx);
		session.delete(m);
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out]" + "test member delete");	
	}
	
	public static void deleteNoticeboard(Integer articleno) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Noticeboard n = findByNoticeboard(articleno);
		session.delete(n);
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out]" + "test notice delete");	
	}
	
	public static void deleteNoticeboard_type(String borad_type) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Noticeboard_type t = findByNoticeboard_type(borad_type);
		session.delete(t);
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out]" + "test notice_type delete");	
	}
	
	public static Comment findByCommentNo(Integer commentno) {
		Session session = getSessionFactory().openSession();
		Comment c =(Comment) session.load(Comment.class,commentno);
		session.close();
		return c;
	}
	
	public static Member_ampm findByMember(Integer idx) {
		Session session = getSessionFactory().openSession();
		Member_ampm m =(Member_ampm) session.load(Member_ampm.class,idx);
		session.close();
		return m;
	}
	
	public static Noticeboard findByNoticeboard(Integer articleno) {
		Session session = getSessionFactory().openSession();
		Noticeboard n = (Noticeboard) session.load(Noticeboard.class, articleno);
		session.close();
		return n;
	}
	
	public static Noticeboard_type findByNoticeboard_type(String borad_type) {
		Session session = getSessionFactory().openSession();
		Noticeboard_type t = (Noticeboard_type) session.load(Noticeboard_type.class, borad_type);
		session.close();
		return t;
	}
	
	public static List<Comment> readComment(){
		Session session = getSessionFactory().openSession();
		List<Comment> comments = session.createQuery("FROM Comment").list();
		session.close();
		System.out.println("[System.out] " +"Found " + comments.size() + " Comment");
		return comments;	
	}
	
	public static List<Member_ampm> readMember(){
		Session session = getSessionFactory().openSession();
		List<Member_ampm> members = session.createQuery("FROM Member_ampm").list();
		session.close();
		System.out.println("[System.out] " +"Found " + members.size() + " Member");
		return members;	
	}
	
	public static List<Noticeboard> readNotice(){
		Session session = getSessionFactory().openSession();
		List<Noticeboard> noticeboards = session.createQuery("FROM Noticeboard").list();
		session.close();
		System.out.println("[System.out] " +"Found " + noticeboards.size() + " Member");
		return noticeboards;	
	}
	
	public static List<Noticeboard_type> readNotice_type(){
		Session session = getSessionFactory().openSession();
		List<Noticeboard_type> noticeboard_types = session.createQuery("FROM Noticeboard_type").list();
		session.close();
		System.out.println("[System.out] " +"Found " + noticeboard_types.size() + " Member");
		return noticeboard_types;	
	}
	
	public static void updateComment(Comment c) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Comment co = (Comment) session.load(Comment.class, c.getArticleno());
		co.setMemo(c.getMemo());
		co.setRegdate(c.getRegdate());
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out]" + "test Comment update");
	}

	public static void updateMember(Member_ampm m) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Member_ampm me = (Member_ampm) session.load(Member_ampm.class,m.getIdx());
		me.setEmail(m.getEmail());
		me.setGrad(m.getGrad());
		me.setIs_super(m.getIs_super());
		me.setLogip(m.getLogip());
		me.setLogtime(m.getLogtime());
		me.setPass_change(m.getPass_change());
		me.setPassword(m.getPassword());
		me.setStatus(m.getStatus());
		me.setTel(m.getTel());
		me.setUserid(m.getUserid());
		me.setUsername(m.getUsername());
		
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out]" + "test Member update");
	}
	
	public static void updateNotice_type(Noticeboard_type t) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Noticeboard_type ty = (Noticeboard_type) session.load(Noticeboard_type.class, t.getBoard_type());
		ty.setBoard_name(t.getBoard_name());
		ty.setBoard_type(t.getBoard_type());
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out]" + "test Notice_type update");
	}
	
	public static void updateNotice(Noticeboard n) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Noticeboard no = (Noticeboard) session.load(Noticeboard.class, n.getArticleno());
		no.setBoard_type(n.getBoard_type());
		no.setContext(n.getContext());
		no.setNo_view(n.getNo_view());
		no.setTitle(n.getTitle());
		no.setRegdate(n.getRegdate());
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out]" + "test Notice update");
	}

	public static Integer createComment(Comment c) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out]" + "test Comment create");
		return c.getCommentno();
	}
	
	public static Integer createMember(Member_ampm m) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(m);
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out]" + "test Member create");
		return m.getIdx();
	}
	
	public static Integer createNotice(Noticeboard n) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(n);
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out]" + "test notice create");
		return n.getArticleno();
	}
	
	public static String createNotice_type(Noticeboard_type t) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out]" + "test notice create");
		return t.getBoard_type();
	}

	
	public static void deleteAll() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("DELETE FROM Member_ampm ");
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out] " +"Successfully deleted all Member_ampm.");
	}
	

}