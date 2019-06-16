package hibernateExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Parameter;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import hibernateExample.beans.Person;
import hibernateExample.utils.HibernateUtil;

public class ApplicationMain {
	 private static final Logger logger = LogManager.getLogger(ApplicationMain.class);
	 
	public static void main(String[] args) {
		Session session = null;
	      Transaction transaction = null;
	      try {
	         session = HibernateUtil.getSessionFactory().openSession();
	         NativeQuery query = session.createSQLQuery("select * from person where id in (:inputParam)");
	         //transaction = session.beginTransaction();
	         List<Integer> inputs = new ArrayList<>();
		     inputs.add(123);
		     query.setParameter("inputParam", 123);
		     List results= query.getResultList();
		     logger.debug("result size " + results.size());
	        // transaction.begin();
//	         Person person = new Person();
//	         person.setId(222);
//	         person.setBirthDate(new Date());
//	         person.setFirstName("Mike");
//	         person.setLastName("Lewis");
//	         session.save(person);

	        // transaction.commit();
	      } catch (Exception e) {
	    	  e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      } finally {
	         if (session != null) {
	            session.close();
	         }
	      }

	      HibernateUtil.shutdown();
        
	}
	
	
}
