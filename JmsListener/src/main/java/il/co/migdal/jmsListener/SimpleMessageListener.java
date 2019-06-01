package il.co.migdal.jmsListener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class SimpleMessageListener implements MessageListener {

	 //private static final Logger LOG = Logger.getLogger(SimpleMessageListener.class);

	  public void onMessage(Message message) {
	      try {
	       TextMessage msg = (TextMessage) message;
	       System.out.println("Consumed message: " + msg.getText());
	      } catch (JMSException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	      }
	  }
	  
	  

}
