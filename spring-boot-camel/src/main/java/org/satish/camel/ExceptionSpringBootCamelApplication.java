package org.satish.camel;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class ExceptionSpringBootCamelApplication {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-camel-exception.xml");
		ctx.start();
		System.out.println("Application context started");
		try {
			Thread.sleep(5 * 60 * 1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		ctx.stop();
		ctx.close();
	}
}
