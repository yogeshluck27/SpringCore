package com.in28minutes.learnspringframework.examples.c1;

import java.sql.SQLException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class BusinessCalculationService {
	
	private DataService dataService;
	
	//Constructor Injection By Default. No need to add @Autowired Annotation
	public BusinessCalculationService(/*@Qualifier("MySqlDataService")*/DataService dataService) {
		super();
		this.dataService = dataService;
	}
	//Expected Single matching bean but found 2.
	//This execption will occur if we dont use @Qualifier/
	//If we dont want to use @Qualifier then we can add @Primary on any one bean
	public int findMax() throws SQLException {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}

}
