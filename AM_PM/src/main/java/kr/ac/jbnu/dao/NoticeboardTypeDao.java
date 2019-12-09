package kr.ac.jbnu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import kr.ac.jbnu.model.Noticeboard_type;

public class NoticeboardTypeDao {
	
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
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
	
	public static Noticeboard_type findByNoticeboard_type(String borad_type) {
		Session session = getSessionFactory().openSession();
		Noticeboard_type t = (Noticeboard_type) session.load(Noticeboard_type.class, borad_type);
		session.close();
		return t;
	}
	
	public static List<Noticeboard_type> readNotice_type(){
		Session session = getSessionFactory().openSession();
		List<Noticeboard_type> noticeboard_types = session.createQuery("FROM Noticeboard_type").list();
		session.close();
		System.out.println("[System.out] " +"Found " + noticeboard_types.size() + " Member");
		return noticeboard_types;	
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
		Query query = session.createQuery("DELETE FROM noticeboard_type ");
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out] " +"Successfully deleted all Member_ampm.");
	}

}
