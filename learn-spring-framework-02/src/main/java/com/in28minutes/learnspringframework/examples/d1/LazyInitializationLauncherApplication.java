package com.in28minutes.learnspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {
	
}

@Component
@Lazy
class ClassB {
	
	@SuppressWarnings("unused")
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		
		//Logic
		System.out.println("Some Initialization logic");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Do Something");
	}
	
}


@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
	
	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext
					(LazyInitializationLauncherApplication.class)) {
			
			System.out.println("Initialization of context is completed");
			
			context.getBean(ClassB.class).doSomething();
			//Remove @Lazy annotation on ClassB and try to run the program
			//You will see Some Initialization logic is printed then
			// Initialization of context is completed is printed 
			//then  Do Something will be printed
			
			//In Case of @Lazy the order will be 
			//Initialization of context is completed -> Some Initialization logic -> Do Something

		}
	}
}
