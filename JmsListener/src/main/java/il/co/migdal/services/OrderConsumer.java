package il.co.migdal.services;

import org.apache.logging.log4j.CloseableThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import il.co.migdal.messages.PrintMessage;

import static  il.co.migdal.config.ActiveMQConfig.ORDER_QUEUE;

import javax.jms.Message;
import javax.jms.Session;
@Component
public class OrderConsumer {
	private static Logger log = LoggerFactory.getLogger(OrderConsumer.class);

    @JmsListener(destination = ORDER_QUEUE)
    public void receiveMessage(@Payload String order,
                               @Headers MessageHeaders headers,
                               Message message, Session session) {
    	
    	 try (final CloseableThreadContext.Instance ctc = CloseableThreadContext.put("ROUTINGKEY", "listener")) {
	    		 
	    	 
	        log.info("received <" + order + ">");
	
	        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
	        log.info("######          Message Details           #####");
	        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
	        log.info("headers: " + headers);
	        log.info("message: " + message);
	        log.info("session: " + session);
	        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
	        PrintMessage.printMessage();
	        
    	 }
    }

}
