package com.gmidesign.h2.tablecreators;

import com.gmidesign.h2.base.H2Executor;
import com.gmidesign.h2.base.ICreateTable;

/**
 * This class is used to create simple gender table.
 * @author grzegorz
 *
 */
public class CreateGendersTable implements ICreateTable{

	private static final String TABLE_NAME = "genders";
	private static final String CREATE_GENDERS = 
	"CREATE TABLE "+TABLE_NAME+"(" + 
							"gender_id INTEGER PRIMARY KEY,"+
							"gender_name VARCHAR(255)"+
	");";
	

	
	public void createTable() {
		if(!H2Executor.getInstance().verifyTableExistence(TABLE_NAME)){
			H2Executor.getInstance().executeQuery(CREATE_GENDERS);			
		} else {
			System.out.println("Table: " + TABLE_NAME + " already exist.");
		}
	}
	
	public static void main(String[] args) {
		CreateGendersTable gen = new CreateGendersTable();
		gen.createTable();
		
	}

}
