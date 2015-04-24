package com.test.oracle;

	import java.sql.Connection;
	import java.util.Properties;
	import oracle.jdbc.driver.OracleDriver;
	/**
	 * 数据库连接对象管理类
	 * @说明
	 * @author cuisuqiang
	 * @version 1.0
	 * @since
	 */
	public class ConnectionTest {
		private static final String url = "jdbc:oracle:thin:@192.168.0.12:1521:orcl";
		private static final String username = "scott";
		private static final String userpass = "bi123";
		public static void main(String[] args) throws Exception {
			Connection conn = getConnection("1");
			if (null != conn) {
				System.out.println(conn.toString());
			} else {
				System.out.println("NO LINK");
			}
		}
		public static Connection getConnection(String tar) {
			Connection conn = null;
			try {
				OracleDriver driver = new OracleDriver();
				Properties properties = new Properties();
				properties.put("user", username);
				properties.put("password", userpass);
				conn = driver.connect(url, properties);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return conn;
		}
	}
