package com.gnt.qxgl.common.dict.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.common.dict.DictServlet;

public class QxglUtils {
	/**
	 * 获取QXXT的数据库连接对象
	 * 
	 * @return
	 * @throws SQLException
	 */
	static public Connection getQxxtConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(
				DictServlet.url,
				DictServlet.uid, 
				DictServlet.pwd);
		return conn;
	}
	
	static public Connection getQxxtConnection(String name) throws SQLException {
		String url = SystemConfig.getJdbcConfig(name + ".url");
		String uid = SystemConfig.getJdbcConfig(name + ".user");
		String pwd = SystemConfig.getJdbcConfig(name + ".password");
		/*try {
			Class.forName(SystemConfig.getJdbcConfig("qxgl.jdbc.driverClass"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Connection conn = DriverManager.getConnection(
				url,
				uid, 
				pwd);
		return conn;
	}
}
