package myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AcceptUserInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		//将用户名密码存入 Session 内置对象中
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>Servlet 获取页面信息</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    <center> ");
		out.print("    <fron size=2> ");
		//如果用户名不存在，则显示“用户名密码不存在”
		if(username != null){
			out.println(" 用户注册信<br><br> ");
			out.println(" 用户名:" + username + "<br>");
			out.println(" 密码: "+ password +"<br>");
		}
		else{
			out.println("用户名密码不存在<br><br>");
		}
		
		out.println(" </font>");
		out.println(" </center>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.close();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
