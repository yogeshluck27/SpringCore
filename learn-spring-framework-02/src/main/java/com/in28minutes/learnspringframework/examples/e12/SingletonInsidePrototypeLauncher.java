package com.in28minutes.learnspringframework.examples.e12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
class SingletonBean {}


@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
// Singleton class inside Prototype scope class
class PrototypeBean {
	@Autowired
	private SingletonBean singletonBean;

	public PrototypeBean() {
		System.out.println("PrototypeBean instance created");
	}

/*	public SingletonBean getSingletonBean() {
		System.out.println("Inside getSingletonBean");
		return singletonBean;
	}*/
	
	//Below method will give a call to BeanFactory getBean which will create
	//As scope is singleton still only one bean is created for SingletonBean class
	//Control will not go to getSingletonBean method
	  @Lookup
	  public SingletonBean getSingletonBean() {
		System.out.println("Inside getSingletonBean");
        return null;
    }

}



// Prototype Bean Injection Problem

@Configuration
@ComponentScan
public class SingletonInsidePrototypeLauncher {
	

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SingletonInsidePrototypeLauncher.class)) {

			PrototypeBean firstPrototypeBean = context.getBean(PrototypeBean.class);
			System.out.println("firstPrototypeBean is " +firstPrototypeBean);
			SingletonBean firstSingletonBean = firstPrototypeBean.getSingletonBean();
			System.out.println("firstSingletonBean " +firstSingletonBean);
			
			// get prototype bean instance one more time
			PrototypeBean secondPrototypeBean = context.getBean(PrototypeBean.class);
			System.out.println("secondPrototypeBean is " +secondPrototypeBean);
			SingletonBean secondSingletonBean = secondPrototypeBean.getSingletonBean();
			System.out.println("secondSingletonBean " +secondSingletonBean);

			//System.out.println(firstPrototype.equals(secondPrototype));
		}
	}
}
