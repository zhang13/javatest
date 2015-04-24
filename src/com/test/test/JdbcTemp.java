package com.test.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcTemp {

	static Connection conn=null;
	
	
	public static  void closeSession(){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConn(){
		
		try {
			Properties prop = System.getProperties();
			//设置http访问要使用的代理服务器的地址
			prop.setProperty("http.proxyHost", "133.71.1.3");    
			//设置http访问要使用的代理服务器的端口
			prop.setProperty("http.proxyPort", "808");  
			//设置不需要通过代理服务器访问的主机，可以使用*通配符，多个地址用|分隔 
			//prop.setProperty("http.nonProxyHosts", "localhost|10.10.*"); 
			Class.forName("com.mysql.jdbc.Driver");
			//jdbc:mysql://125.76.230.71:3306/ema
			conn=DriverManager.getConnection("jdbc:mysql://125.76.230.71:3306/ema", "st", "25#219hqgyBhFyR1");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		System.out.println(getConn());
	}
}

