package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTest {
	public static void main(String[] args) {
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			// add application code here
			String createSql = "CREATE TABLE  warehouse (\n"
	                + "	id integer PRIMARY KEY,\n"
	                + "	name text NOT NULL,\n"
	                
	                + ");";
			Statement stmt = conn.createStatement(); 
	            // create a new table
				stmt.execute("drop table warehouse");
	            stmt.execute(createSql);
	            stmt.execute("INSERT INTO warehouse values(1,'xyz')");
	            stmt.execute("INSERT INTO warehouse values(2,'dfyz')");
	            stmt.execute("INSERT INTO warehouse values(3,'1yz')");
	            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO warehouse values(?,?)");
	            pstmt.setInt(1, 25);
	            pstmt.setString(2, "YOLO");
	            pstmt.execute();
	            
	            ResultSet rs = stmt.executeQuery("select * from warehouse");
	            while (rs.next()) {
	            	int int1 = rs.getInt(1);
	            	System.out.println("-->"+int1);
	            	String v = rs.getString(2);
	            	System.out.println("int1 "+int1+" value "+v);
				}
	            
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
