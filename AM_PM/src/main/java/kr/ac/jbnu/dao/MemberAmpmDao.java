package kr.ac.jbnu.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import kr.ac.jbnu.model.Member_ampm;

public class MemberAmpmDao {
	
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
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
	
	public static Boolean login(String userid, String password) {
		Session session = getSessionFactory().openSession();
		// 여기 불가능한 이유 찾기
		Query query = session.createQuery("from Member_ampm where userid = :user ");
		query.setParameter("user", userid);
		List<Member_ampm> list = query.list();
		
		if(list.get(0).getPassword().equals(password)) {
			session.close();
			return true;
		}
		session.close();
		return false;
	}

	public static Member_ampm findByMember(Integer idx) {
		Session session = getSessionFactory().openSession();
		Member_ampm m =(Member_ampm) session.load(Member_ampm.class,idx);
		session.close();
		return m;
	}
	
	public static List<Member_ampm> readMember(){
		Session session = getSessionFactory().openSession();
		List<Member_ampm> members = session.createQuery("FROM Member_ampm").list();
		session.close();
		System.out.println("[System.out] " +"Found " + members.size() + " Member");
		return members;	
	}
	
	public static void updateMember(Member_ampm m) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
			
		Member_ampm me = (Member_ampm) session.load(Member_ampm.class,m.getIdx());
		me.setEmail(m.getEmail());
		me.setGrad(m.getGrad());
		me.setIs_super(m.getIs_super());
		me.setLogip(m.getLogip());
		me.setLogtime(new Timestamp(System.currentTimeMillis()));
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
	
	public static Integer createMember(Member_ampm m) {
		
		m.setLogtime(new Timestamp(System.currentTimeMillis()));
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(m);
		session.getTransaction().commit();
		session.close();
		System.out.println("[System.out]" + "test Member create");
		return m.getIdx();
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
