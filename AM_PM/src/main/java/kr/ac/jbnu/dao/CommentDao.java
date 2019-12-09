package kr.ac.jbnu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import kr.ac.jbnu.model.Comment;

public class CommentDao {
	
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

	
	public static Comment findByCommentNo(Integer commentno) {
		Session session = getSessionFactory().openSession();
		Comment c =(Comment) session.load(Comment.class,commentno);
		session.close();
		return c;
	}
	
	public static List<Comment> readComment(){
		Session session = getSessionFactory().openSession();
		List<Comment> comments = session.createQuery("FROM Comment").list();
		session.close();
		System.out.println("[System.out] " +"Found " + comments.size() + " Comment");
		return comments;	
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
	
	public static Integer createComment(Comment c) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out]" + "test Comment create");
		return c.getCommentno();
	}
	
	public static void deleteAll() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("DELETE FROM Comment ");
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out] " +"Successfully deleted all Member_ampm.");
	}
}
