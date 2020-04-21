package com.youying.western.exportExcel;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @deprecated:连接数据库
 * @author:jhy 
 * @date:2016-5-6 下午5:32:02
 */

public class ConnectionOracle {
	//数据库驱动
	String sd = "oracle.jdbc.driver.OracleDriver";
	//连接地址
	String sc = "jdbc:oracle:thin:@10.2.235.15:1521:orcl";
	//用户名
	String userName = "CREPORT";
	//密码
	String password = "CREPORT";

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	public ConnectionOracle() {
		try {
			Class.forName(sd);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		con = DriverManager.getConnection(sc, userName, password);
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		return rs;
	}

	public void executeUpdate(String sql) throws SQLException {
		con = DriverManager.getConnection(sc, userName, password);
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
	}

	public void close() throws SQLException {
		if (rs != null){
			rs.close();
		}
		if (stmt != null){
			stmt.close();
		}	
		if (con != null){
			con.close();
		}
	}

}
