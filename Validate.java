package car;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/**response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("mysql:jdbc://128.66.203.247:3306/imsc7it70","imsc7it70","sumo@123");
			PreparedStatement pst=con.prepareStatement("Select * from car");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				String car_name=rs.getString(1);
				String car_model=rs.getString(2);
				String car_color=rs.getString(3);
				String car_price=rs.getString(4);
				String car_id=rs.getString(5);
				String linkUrl="Details?car_name="+car_name+"&car_model="+car_model+"&car_color="+car_color+"&car_price="+car_price+"&car_id="+car_id;
				out.println("<a href='"+linkUrl+"'>" + car_name + "</a>");	
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}**/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out =response.getWriter();
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://128.66.203.247:3306/imsc7it70","imsc7it70","sumo@123");
			PreparedStatement pst=con.prepareStatement("Select * from user where username=? and password=?");
			pst.setString(1, name);
			pst.setString(2, pwd);
			ResultSet rs=pst.executeQuery();
			
			if (rs.next())
				response.sendRedirect("index.jsp");
			else
				response.sendRedirect("error.jsp");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
