package com.in28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass {
	//Dependency Injection using Fields.
	@Autowired
	Dependency1 dependency1;
	@Autowired
	Dependency2 dependency2;

	//Dependency Injection using Constructor.
	//@Autowired
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor Injection - YourBusinessClass ");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}//Even IF we don't mention @Autowired on constructor its auto-wired by default.
	//Spring prefers Constructor based Inject as when object is created
	//All dependencies are injected and Bean Will be ready for use.
	
	// If we use both Constructor & setter Injection then Setter injection will override
	//Constructor injection as setter will not create new instance
	
	//Dependency Injection using Setters.
	@Autowired
	public void setDependency1(Dependency1 dependency1) {
		System.out.println("Setter Injection - setDependency1 ");
		this.dependency1 = dependency1;
	}
	//Dependency Injection using Setters.
	@Autowired
	public void setDependency2(Dependency2 dependency2) {
		System.out.println("Setter Injection - setDependency2 ");
		this.dependency2 = dependency2;
	}

	public String toString() {
		return "Using " + dependency1 + " and " + dependency2;
	}

}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Configuration
@ComponentScan
//If we don't mention the basepackage then automatically current package & its subpackages are  taken
public class DepInjectionLauncherApplication {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {

		//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

			System.out.println(context.getBean(YourBusinessClass.class));

		}
	}
}
