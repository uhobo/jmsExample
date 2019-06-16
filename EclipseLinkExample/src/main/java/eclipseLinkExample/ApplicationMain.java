package eclipseLinkExample;

import java.util.ArrayList;
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

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import eclipseLinkExample.beans.Person;
/**
 * https://github.com/brettwooldridge/HikariCP#configuration-knobs-baby
 * @author user
 *
 */
public class ApplicationMain {
	 private static final Logger logger = LogManager.getLogger(ApplicationMain.class);
	 
	public static void main(String[] args) {
		logger.debug("Starting..");
		HikariConfig config = new HikariConfig("C:\\Users\\user\\git\\jmsexample\\EclipseLinkExample\\src\\main\\resources\\hikari.properties");
		HikariDataSource ds = new HikariDataSource(config);
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("dataSource", ds);
		properties.put("jdbc.driver", "com.mysql.cj.jdbc.Driver");
		properties.put("username", "testuser");
		properties.put("password", "testuser");
		properties.put("jdbcUrl", "jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
		
		EntityManagerFactory efact = Persistence.createEntityManagerFactory("test",properties);
		
        EntityManager eman = efact.createEntityManager();
		try {
	       // eman.getTransaction().begin();
	        //Query query = eman.createQuery("Select e FROM Person e");
	        Query selectQuery  = eman.createNativeQuery("select first_name from person where id = :inputParam");
//	        Set<Parameter<?>> inParams = selectQuery.getParameters();
//	        for(Parameter<?> single : inParams) {
//	        	System.out.println(single);
//	        }
	        List<Integer> inputs = new ArrayList<>();
	        inputs.add(123);
	        selectQuery.setParameter("inputParam", 123);
	        
	        List results= selectQuery.getResultList();
	    	logger.debug("result size " + results.size());
//	        List<Person> result = query.getResultList();
//	        for(Person rcd : result) {
//	        	System.out.println(rcd + "\n");
//	        }
//            Person person= new Person();
//            person.setId(1236);
//            person.setFirstName("roni");
//            person.setLastName("geller");

           // eman.persist(person);
           // eman.getTransaction().commit();
            
	       
	        
	        
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
            
            eman.close();
            efact.close();
        }
        
	}
	
	
}
