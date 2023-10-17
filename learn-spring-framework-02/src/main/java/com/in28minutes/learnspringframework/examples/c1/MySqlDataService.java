package com.in28minutes.learnspringframework.examples.c1;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
//@Repository
//@Qualifier("MySqlDataService")
public class MySqlDataService implements DataService {

	@Override
	public int[] retrieveData() throws SQLException {
		 //throw new SQLException();
		return new int[] { 1, 2, 3, 4, 5 };
	}

}
