package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
	private static Connection Conn() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/java?serverTimezone=GMT%2B8";
		String username = "root";
		String password = "root";
		Connection conn = null;
		try {
			Class.forName(driver); //classloader,加载对应驱动
			System.out.println("驱动注册成功");
			conn = (Connection) DriverManager.getConnection(url, username, password);
			System.out.println("数据库连接成功");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static Connection getConn() {
		Connection conn = Conn();
		return conn;
	}
	
	private static Statement State(Connection conn) {
		Statement statement = null;
		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}
	public static Statement getState(Connection conn) {
		Statement statement = State(conn);
		System.out.println("创建Statement成功");
		return statement;
	}
	
	private static void taBel(Connection conn, Statement stat, String sql) {
		try {
			stat.execute(sql);
			System.out.println("创建表成功");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void createTable(Connection conn, Statement stat, String sql) {
		taBel(conn, stat, sql);
	}
    
}
