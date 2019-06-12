package il.co.migdal.messages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import il.co.migdal.services.MessageProducer;

public class PrintMessage {
	 private static Logger log = LoggerFactory.getLogger(MessageProducer.class);
	 
	 public static void printMessage() {
		 log.debug("Hello from printMessage");
	 }
}
