package dbConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Connector {
	static Connection con=null;
	static String driver="com.ibm.db2.jcc.DB2Driver";
	static String url="jdbc:db2://localhost:50000/Library";
	static String user="db2admin";
	static String pass="db2admin";
	
	public static Connection getConnection()
	{
		try{
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pass);
		}
		catch(Exception e)
		{
			
		}
		return con;
	}
	
	
}
