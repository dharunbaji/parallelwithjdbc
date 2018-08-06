package com.cg.db;



import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.exception.WalletException;

public class DBUtil {
	public static Connection getConnection() throws WalletException{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url,"system","root");
		}catch(ClassNotFoundException e){
			throw new WalletException(e.getMessage());
		}catch(SQLException e1){
			throw new WalletException(e1.getMessage());
		}
		
		
	}
}
