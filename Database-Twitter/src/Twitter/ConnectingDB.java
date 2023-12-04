package Twitter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectingDB {
	Connection con = null;
	   private static final String JDBC_URL = "jdbc:mysql://localhost:3306/twitter";
	    private static final String USER = "root";
	    private static final String PASSWORD = "12345";
	public ConnectingDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println(con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
	public Connection getConnection() {
        return con;
    }
	public void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
}
