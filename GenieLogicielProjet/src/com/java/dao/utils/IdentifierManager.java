package com.java.dao.utils;

import com.java.dao.jdbc.Database;

public class IdentifierManager {
 

	public static int selectLastID(Database db, String tableName) {
		try { 
			String data[][] = db.select(tableName);
			if(data.length > 0) {

				String[] lastRow = data[data.length - 1];
				int value = Integer.parseInt(lastRow[0]);
				
				return value;
			}
		} catch (Exception e) {
			
			System.out.println("Error : " + e.getMessage());
		}
		return 1;
	} 
}
