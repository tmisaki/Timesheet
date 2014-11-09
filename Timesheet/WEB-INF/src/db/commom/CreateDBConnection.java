package db.commom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CreateDBConnection {
	
	public Connection CreatConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	
		String DRIVER = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/rtm?useUnicode=true&characterEncoding=UTF8";
		String ID = "root";
		String PW = "";
		
		Connection con;
		
		//ドライバの読込
		Class.forName(DRIVER).newInstance();
		
		//DB接続
		con = DriverManager.getConnection(URL, ID, PW);
		
		return con;
	}

}
