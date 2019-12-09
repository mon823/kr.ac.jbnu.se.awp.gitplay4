package kr.ac.jbnu.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import kr.ac.jbnu.model.Noticeboard;

public class NoticeboardDao {
	
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
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
	
	public static Noticeboard findByNoticeboard(Integer articleno) {
		Session session = getSessionFactory().openSession();
		Noticeboard n = (Noticeboard) session.load(Noticeboard.class, articleno);
		session.close();
		return n;
	}
	
	
	public static void updateNoticeboard(Noticeboard n) {
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
	
	public static Integer createNoticeboard(Noticeboard n) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(n);
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out]" + "test notice create");
		return n.getArticleno();
	}
	
	public static void deleteAll() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("DELETE FROM NOTICEBOARD ");
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out] " +"Successfully deleted all Member_ampm.");
	}
}


