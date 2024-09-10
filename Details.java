package car;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter  out=response.getWriter();
		String car_name=request.getParameter("car_name");
		String car_model=request.getParameter("car_model");
		String car_color=request.getParameter("car_model");
		String car_price=request.getParameter("car_price");
		String car_id=request.getParameter("car_id");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Car Name:"+car_name+"<h1>");
		out.println("<h1>Car Model:"+car_model+"<h1>");
		out.println("<h1>Car Color:"+car_color+"<h1>");
		out.println("<h1>Car Price:"+car_price+"<h1>");
		out.println("<h1>Car id:"+car_id+"<h1>");
		
		String Delurl="Delete?car_id="+car_id;
		String text="Delete";
		out.println("<a href='"+Delurl+"'>"+ text +"</a>");

		String linkUrl="Display";
		out.println("<a href='"+linkUrl+"'>"+ "Home" +"</a>");
		out.println("</body>");
		out.println("</html");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
