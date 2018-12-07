package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Item;

public class JdbUtil {
	private static final String serverDriverClass = "com.mysql.cj.jdbc.Driver";
	
	private static Connection _conn = null;
	final   static _credentials credentials = new _credentials("127.0.0.1", -1, "root", null, "dtbsql");
	
	protected static Connection getConnection() throws Exception {
		if(_conn == null) try {
			Class.forName(serverDriverClass).newInstance();
			_conn = DriverManager.getConnection(
					credentials.toString(),
					credentials.getUsername(),
					credentials.getPassword());
			if(_conn==null) throw new java.lang.Exception("Error while connecting!");
			debug("succesfully connected to " +credentials.toString());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException exp) {
			throw new NullPointerException("An internal error occurred.");
		} catch (SQLException exp) {
			throw new SQLException("A connection or internal server error occurred.");
		}
		return _conn;
	}
	
	protected static Connection close() throws SQLException {
		if(_conn != null) _conn.close();
		_conn = null;
		return _conn;
	}
	
	public static List<Item> getItems() throws Exception {
		getConnection();
		ResultSet query = _conn.prepareStatement("SELECT `number` AS `nb`, `name` AS `name` FROM `tb`;").executeQuery();
		List<Item> results = new ArrayList<Item>(0);
		while(query.next()) results.add(new Item(query.getInt(1),query.getString(2)));
		query.close();
		JdbUtil.close();
		return results;
	}
	
	private static void debug(String message) { System.out.println("JdbUtil.debug:\t" +message); }
}
