package il.co.migdal.jmsListener;

import org.springframework.util.ErrorHandler;

public class SampleJmsErrorHandler implements ErrorHandler{

	@Override
	public void handleError(Throwable t) {
		t.printStackTrace();
		
	}

}
