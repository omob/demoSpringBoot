package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.User;

@SpringBootApplication
public class DemoApplication {
 
//	private User user;
//	
//	public void setUser(User user) {	
//		this.user = user;
//	}
	
	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(DemoApplication.class, args);
		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		 // create CamelContext
//        CamelContext context = new DefaultCamelContext();
        
		 // connect to embedded ActiveMQ JMS broker
//        ConnectionFactory connectionFactory = 
//            new ActiveMQConnectionFactory("tcp://localhost:61616");
//       
//        context.addComponent("jms",
//            JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
//
//        context.addRoutes(new FtpToJMSRoute());
//		DemoApplication demoApp = (DemoApplication) context.getBean("demoBean");
//		demoApp.execute();
        
//		context.start();
//		Thread.sleep(5000);
//		context.stop();

	}
	
//	public void execute() {
//		this.user.sayHello();
//	}

}
