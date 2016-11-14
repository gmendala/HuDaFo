package com.gmidesign.h2.base;

/**
 * Executor for the database. This abstract class is forcing its inheriting children to have abstract method for query execution.
 * @author grzegorz
 *
 */
public abstract class DatabaseExecutor {
	
	public abstract  void executeQuery(String query);

	
	
}
