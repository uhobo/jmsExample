package il.co.migdal;

import com.google.inject.Guice;
import com.google.inject.Injector;

import il.co.migdal.config.BasicModule;
import il.co.migdal.service.PrinterService;

public class MainApplication {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new BasicModule());
		PrinterService comms = injector.getInstance(PrinterService.class);
		
		comms.printService1();
		comms.printService2();
		

	}

}
