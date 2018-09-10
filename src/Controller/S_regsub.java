package Controller;
/*servlet which updates values in the table when user fills registration details
 * and clicks submit
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * Servlet implementation class S_regsub
 */
@WebServlet("/S_regsub")
public class S_regsub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_regsub() {
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
						
			String n=request.getParameter("name1");
			String id=request.getParameter("name2");
			String p=request.getParameter("name3");
			String e=request.getParameter("name4");
			
			PreparedStatement ps=cn.prepareStatement("select ref_code from login");
			ResultSet rs=ps.executeQuery();
			int i=1736;
			
			while(rs.next())
			{
				i=rs.getInt(1);
			}
			i=i+1;
			
			
			PreparedStatement psq=cn.prepareStatement("insert into login values(?,?,?,?,?)");
			psq.setString(1,id );
			psq.setString(2,n );
			psq.setString(3,p );
			psq.setString(4,e);
			psq.setInt(5,i);
			
			int f=psq.executeUpdate();
			
			HttpSession session=request.getSession();
			response.sendRedirect("home.jsp");
			
			//RequestDispatcher rd=request.getRequestDispatcher("home.html");
			//rd.forward(request,response);
					
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
