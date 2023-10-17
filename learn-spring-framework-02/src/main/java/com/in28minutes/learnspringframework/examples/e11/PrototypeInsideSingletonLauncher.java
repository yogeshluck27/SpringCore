package com.in28minutes.learnspringframework.examples.e11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeBean {
}

@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
//PrototypeBean  inside SingletonBean 
class SingletonBean {
	
	@Autowired
	private PrototypeBean prototypeBean;

	public SingletonBean() {
		System.out.println("Singleton instance created");
	}

	public PrototypeBean getPrototypeBean() {
		System.out.println("Inside getPrototypeBean");
		return prototypeBean;
	}
	
	//Below method will give a call to BeanFactory getBean which will create
	//New instance of Prototype Bean every time
	/*@Lookup
    public PrototypeBean getPrototypeBean() {
		System.out.println("Singleton instance created");
        return null;
    }*/
}

// Prototype Bean Injection Problem

@Configuration
@ComponentScan
public class PrototypeInsideSingletonLauncher {
	

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				PrototypeInsideSingletonLauncher.class)) {

			SingletonBean firstSingleton = context.getBean(SingletonBean.class);
			System.out.println("firstSingleton is " +firstSingleton);
			PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();
			System.out.println("firstPrototype " +firstPrototype);
			
			// get singleton bean instance one more time
			SingletonBean secondSingleton = context.getBean(SingletonBean.class);
			System.out.println("secondSingleton is "+ secondSingleton);

			PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();
			System.out.println("secondPrototype is "+secondPrototype);

			//System.out.println(firstPrototype.equals(secondPrototype));
		}
	}
}
