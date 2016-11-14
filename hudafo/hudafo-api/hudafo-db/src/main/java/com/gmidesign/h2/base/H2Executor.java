package com.gmidesign.h2.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * It is a type of Database query Executor.
 * @author grzegorz
 *
 */
public class H2Executor extends DatabaseExecutor {

	private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:../resources/HuDaFoDB;";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "21greg44";
	private static H2Executor executor;
	
	
	public H2Executor(){}
	
	public static H2Executor getInstance(){
		if (executor == null) {
			return new H2Executor();
		} else {
			return executor;
		}
	}
	
	
	public boolean verifyTableExistence(String tableName){
		Connection conn= getDBConnection();
		Statement st = null;
		ResultSet rs = null;
		String query = "SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '"+tableName.toUpperCase()+"' AND TABLE_SCHEMA = 'PUBLIC'";
		boolean result = false;
		try {
			conn.setAutoCommit(false);
			st = conn.createStatement();
			rs = st.executeQuery(query);
			if(rs != null){
				if(rs.next()){
					result = true;
				}				
			}
			
			st.close();
			rs.close();
			conn.commit();
			
		} catch (SQLException sqlex){
			
			System.out.println("Exception Message " + sqlex.getLocalizedMessage());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Exception Message " + e.getLocalizedMessage());
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	@Override
	public synchronized void executeQuery(String query) {
		Connection conn= getDBConnection();
		Statement st = null;
		try {
			conn.setAutoCommit(false);
			st = conn.createStatement();
			st.execute(query);
			st.close();
			conn.commit();
			
		} catch (SQLException sqlex){
			
			System.out.println("Exception Message " + sqlex.getLocalizedMessage());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Exception Message " + e.getLocalizedMessage());
				e.printStackTrace();
			}
		}

	}
	
    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
	
	

}
