package myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class SimpleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public void init() throws ServletException {
		
		}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
	
		response.setContentType("text/html;charset = GB2312");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>SimpleServlet</title></head>");
		out.println("<body bgcolor=\"#ffffff\">");
		out.println("<p><font size='2' color='blue'>这是一个简单的Servlet应用</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
