package jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class Sqltest {
        
	public static void main(String[] args) {
		Connection conn = Jdbc.getConn();
		Statement stat = Jdbc.getState(conn);
		String sql = "create database `java`";
		Jdbc.createTable(conn, stat, sql);
		Jdbc.createTable(conn, stat, "create table `test1`{"
										+"int id");
	}

}
