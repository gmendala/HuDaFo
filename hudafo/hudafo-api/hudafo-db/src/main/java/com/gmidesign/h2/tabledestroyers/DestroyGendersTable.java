package com.gmidesign.h2.tabledestroyers;

import com.gmidesign.h2.base.H2Executor;
import com.gmidesign.h2.base.IDestroyTable;

public class DestroyGendersTable implements IDestroyTable{

	private static final String TABLE_NAME = "genders";
	private static final String DROP_GENDERS ="DROP TABLE " + TABLE_NAME;
	
	
	public void destroyTable() {
		if(H2Executor.getInstance().verifyTableExistence(TABLE_NAME)){
			H2Executor.getInstance().executeQuery(DROP_GENDERS);			
		} else {
			System.out.println("Table " + TABLE_NAME + " you wished to drop does not exist.");
		}
	}
	
	
	
	public static void main(String[] args) {
		DestroyGendersTable dest = new DestroyGendersTable();
		dest.destroyTable();

	}


}
