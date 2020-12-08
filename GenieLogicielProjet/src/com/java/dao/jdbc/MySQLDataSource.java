package com.java.dao.jdbc;

public class MySQLDataSource extends DataSource{

	private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String MYSQL_BRIDGE =  "jdbc:mysql:";
	public MySQLDataSource() {
		
	}

    
	public MySQLDataSource(String host, String source, String user, String password) {
		super(MYSQL_DRIVER,MYSQL_BRIDGE,host, source, user, password);
		
	}

	public MySQLDataSource(String host, String source, String user) {
		super(MYSQL_DRIVER,MYSQL_BRIDGE,host, source, user, "");
		
	}

	public MySQLDataSource(String host, String source) {
		super(MYSQL_DRIVER,MYSQL_BRIDGE,host, source, "root", "");
		
	}
	
	public MySQLDataSource(String source) {
		super(MYSQL_DRIVER,MYSQL_BRIDGE,"localhost", source, "root", "");
	}
	
	public String getURL() {
	  	
		return MYSQL_BRIDGE + "//" + getHost() + "/"  +  getSource(); 
	}

	public char startDelimiter() {
		return '`';
	}

	public char endDelimiter() {
		return '`';
	}
}
