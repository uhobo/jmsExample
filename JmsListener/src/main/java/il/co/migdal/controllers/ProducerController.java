package il.co.migdal.controllers;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import il.co.migdal.messages.PrintMessage;
import il.co.migdal.services.MessageProducer;

@RestController
public class ProducerController {
	
	@Autowired
	private MessageProducer orderSender;
	
	@GetMapping("/producer")
	public Boolean sendMessage(@RequestParam(value="message") String message) {
		   try (final CloseableThreadContext.Instance ctc = CloseableThreadContext.put("ROUTINGKEY", "producer")) {
			   PrintMessage.printMessage();
			   orderSender.send(message);
			   return true;
		   }
		
//		 jmsTemplate.send( new MessageCreator() {
//	            public Message createMessage(Session session) throws JMSException {
//	                return session.createTextMessage(message);
//	            }});   
//		 
		
	}

	public MessageProducer getOrderSender() {
		return orderSender;
	}

	public void setOrderSender(MessageProducer orderSender) {
		this.orderSender = orderSender;
	}
	
	
}
	