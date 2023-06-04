package db;
import java.sql.*;
import java.util.Properties;
import java.io.*;
public class ConnectDB {
	private static Connection con;
	public static String getURL() {
		String str = null;
		try(
				FileInputStream f = new FileInputStream("db.properties");
				) {
			Properties p = new Properties();
			p.load(f);
			str=p.getProperty("url")+p.getProperty("serverName")+":"+p.getProperty("portNumber")+";databaseName="+p.getProperty("databaseName")
			+";user="+p.getProperty("user")+";password="+p.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	public static Connection getDBProperty() {
		try {
			con=DriverManager.getConnection(getURL());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}

