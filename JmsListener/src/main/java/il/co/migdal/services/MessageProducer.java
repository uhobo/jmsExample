package il.co.migdal.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import static  il.co.migdal.config.ActiveMQConfig.ORDER_QUEUE;
@Service
public class MessageProducer {
	 private static Logger log = LoggerFactory.getLogger(MessageProducer.class);

	    @Autowired
	    private JmsTemplate jmsTemplate;

	    public void send(String myMessage) {
	        log.info("sending with convertAndSend() to queue <" + myMessage + ">");
	        jmsTemplate.convertAndSend(ORDER_QUEUE, myMessage);
	    }
}
