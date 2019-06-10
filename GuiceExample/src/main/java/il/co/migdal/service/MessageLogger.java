package il.co.migdal.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageLogger implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println(invocation.getMethod().getDeclaringClass().getSimpleName() + "." + invocation.getMethod().getName());
		return invocation.proceed();
	}

}
