package com.gmidesign.h2.tablefeed;

import com.gmidesign.h2.base.H2Executor;
import com.gmidesign.h2.base.IInsertData;
import com.gmidesign.h2.dao.GendersDAO;

public class FeedGenderTable implements IInsertData {

	private static final String TABLE_NAME = "genders";
	private GendersDAO dao = new GendersDAO();
	
	
	public GendersDAO getDao() {
		return dao;
	}

	public void insertPreparedDataIntoTable() {
		if(H2Executor.getInstance().verifyTableExistence(TABLE_NAME)){
			if(this.dao != null){
				if(this.dao.getName() != null && this.dao.getName() != ""){
					
				}
			}
		} else {
			System.out.println("Table " + TABLE_NAME + " does not exist.");
		}
		
	}

	public static void main(String[] args) {
		

	}

}
