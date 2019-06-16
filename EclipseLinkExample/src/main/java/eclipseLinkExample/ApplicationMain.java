package eclipseLinkExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import eclipseLinkExample.beans.Person;

public class ApplicationMain {
	 private static final Logger logger = LogManager.getLogger(ApplicationMain.class);
	 
	public static void main(String[] args) {
		logger.debug("Starting..");
		HikariConfig config = new HikariConfig("C:\\roni\\workspaces\\springboot\\EclipseLinkExample\\src\\main\\resources\\hikari.properties");
		HikariDataSource ds = new HikariDataSource(config);
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("javax.persistence.jtaDataSource", ds);
		EntityManagerFactory efact = Persistence.createEntityManagerFactory("test",properties);
		
        EntityManager eman = efact.createEntityManager();
		try {
	       // eman.getTransaction().begin();
	        Query query = eman.createQuery("Select e FROM Person e");
	        List<Person> result = query.getResultList();
	        for(Person rcd : result) {
	        	System.out.println(rcd + "\n");
	        }
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
