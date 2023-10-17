package com.in28minutes.learnspringframework.examples.c1;

import java.sql.SQLException;

public interface DataService {
	int[] retrieveData() throws SQLException;
}
