/*In this servlet
 *password and id matched after user logs in
 *user details displayed
 */

package Controller;

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
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class S_login
 */
@WebServlet("/S_login1")
public class S_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String driver="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/City";	
		String user="db2admin";
		String pass="db2admin";
		response.setContentType("Text/HTML");
		PrintWriter out=response.getWriter();
		
		try{
			
			Class.forName(driver);
			Connection cn=DriverManager.getConnection(url,user,pass);
			
			//getting the user id and password from the login page
			String x=request.getParameter("user");
			String y=request.getParameter("pass");
						
			PreparedStatement psq=cn.prepareStatement("select * from login");
			ResultSet rs=psq.executeQuery();
			
			int i=0;
 			while(rs.next())
			{
				String a=rs.getString("user_id");
				String b=rs.getString("password");
				if((x.equals(a))&&(y.equals(b)))
				{
					i=1;
								
					HttpSession session=request.getSession();
					response.sendRedirect("home.jsp");
					
				}
			}
			if(i==0)
			{
				
				
				out.print("Invalid user-id and password");
				//HttpSession session=request.getSession();
				//response.sendRedirect("login.jsp");
						
			}
			//out.print("<form action=login.html><button type=submit value=Click>Click here</button></form>");
			
		}
			catch(Exception e)
			{
				//e.printStackTrace();
				out.print(e);
			}
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
