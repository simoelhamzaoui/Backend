package com.java.dao.utils;

import com.java.models.Utilisateur;

public class RowMapper {

	private static int parseInteger(String string) {
		try {

			return Integer.parseInt(string);
		} catch (Exception e) {
			System.out.println("Error in parseInteger() = " + e.getMessage());
		}		
		
		return 0;
	}


	private static double parseDouble(String string) {
		try {

			return Double.parseDouble(string);
		} catch (Exception e) {
			System.out.println("Error in parseInteger() = " + e.getMessage());
		}		
		
		return 0;
	}
	private static float parseFloat(String string) {
		try {

			return Float.parseFloat(string);
		} catch (Exception e) {
			System.out.println("Error in parseInteger() = " + e.getMessage());
		}		
		
		return 0;
	}
 
	public static Utilisateur getUtilisateur(String[] row) {
		try {
			Utilisateur user = new Utilisateur(parseInteger(row[0]), row[1], row[2], row[3], row[4]);
			
			return user;
		} catch (Exception e) {
			System.out.println("Error in getUser() = " + e.getMessage());
		}
		return null;
	}

}
