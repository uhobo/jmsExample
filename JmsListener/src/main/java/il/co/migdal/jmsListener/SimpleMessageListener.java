package il.co.migdal.jmsListener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.logging.log4j.CloseableThreadContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleMessageListener implements MessageListener {

	 private static final Logger LOG = LogManager.getLogger(SimpleMessageListener.class);

	  public void onMessage(Message message) {
	      try (final CloseableThreadContext.Instance ctc = CloseableThreadContext.put("ROUTINGKEY", "special")) {
		 // try {
	       TextMessage msg = (TextMessage) message;
	       LOG.debug("Consumed message: " + msg.getText());
	       System.out.println("Consumed message: " + msg.getText());
	      } catch (JMSException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	      }
	  }
	  
	  

}
