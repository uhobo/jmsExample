package il.co.migdal;



import java.util.Collection;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.JndiConnectionFactoryAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerEndpointRegistry;
import org.springframework.jms.listener.MessageListenerContainer;


@SpringBootApplication
//@EnableAutoConfiguration(exclude= {JndiConnectionFactoryAutoConfiguration.class})
@ImportResource("classpath:app-config.xml")
public class JmsSpringBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context  = SpringApplication.run(JmsSpringBootApplication.class, args);
		JmsListenerEndpointRegistry reg = context.getBean(JmsListenerEndpointRegistry.class);
		
		Collection<MessageListenerContainer> contanierList = reg.getListenerContainers();
		for(MessageListenerContainer container :contanierList) {
			System.out.println(container.isRunning() + "\n");
			if(!container.isRunning()) {
				container.start();
			}
		}
		

	}

}
