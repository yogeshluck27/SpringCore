package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class GamingAppLauncherApplication {
	
	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext
					(GamingAppLauncherApplication.class)) {

			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run(); //If we remove @Qualifier on SuperContra
			//And also remove @Qualifier("SuperContraGameQualifier") in Constructor of 
			//GameRunner class
			//then MarioGame will be given prefrenece as @Primary is mentioned .
			//If we Also remove @Primary then we will get NoUniqueBeanDefinitionException
			//As there will be 3 game classes matching to GameRunner Type
			
			

//@Primary - A bean should be given preference when multiple candidates are qualified
//@Qualifier - A specific bean should be auto-wired (name of the bean can be used as a Qualifier)
			
			//Conclusion is @Qualifier is higher preference than @Primary
		}
	}
}
