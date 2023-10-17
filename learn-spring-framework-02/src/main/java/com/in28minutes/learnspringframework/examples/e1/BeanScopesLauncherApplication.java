package com.in28minutes.learnspringframework.examples.e1;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//No Scope defined so by default Singleton scope
@Component
class NormalClass {
	
}


@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
//Singleton class inside Prototype scope class
class PrototypeClass {}


@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
class SingletonClass {
	
}


//Prototype Bean Injection Problem


@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {
	
	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext
					(BeanScopesLauncherApplication.class)) {
			//Each time when we are calling getBean we are getting same object
			//as its singleton bean scope by default

			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			
			//Each time when we are calling getBean we are getting new object
			
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
	


		}
	}
}
