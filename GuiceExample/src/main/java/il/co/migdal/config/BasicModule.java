package il.co.migdal.config;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

import il.co.migdal.service.MessageLogger;
import il.co.migdal.service.MessageSentLoggable;

public class BasicModule extends AbstractModule {

	@Override
	protected void configure() {
		bindInterceptor(
	            Matchers.any(),
	            Matchers.annotatedWith(MessageSentLoggable.class),
	            new MessageLogger()
	        );
		super.configure();
	}

}
