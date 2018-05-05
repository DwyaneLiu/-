package Controler;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.NewsListDao;
import Dao.UserDao;
import Model.NewsList;
import Model.User;
import Util.DbUtil;

public class FindNewsListServlet extends HttpServlet {

	DbUtil db = new DbUtil();
	NewsListDao nld = new NewsListDao();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String companyname = request.getParameter("companyname");
		Connection con = null;
		try {
			// NewsList newlist=new NewsList(companyname);
			con = db.getCon();
			ArrayList<NewsList> Newslist = nld.FindNewsList(con, companyname);
			if (Newslist.isEmpty()) {
				System.out.println("没有该公司的新闻");
				request.setAttribute("newslist", Newslist);
				request.getRequestDispatcher("NewsList.jsp").forward(request, response);
			} else {
				System.out.println("yes");
				// HttpSession session=request.getSession();
				// session.setAttribute("currentUser",);
				request.setAttribute("newslist", Newslist);
				
				request.getRequestDispatcher("NewsList.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("point");
			e.printStackTrace();
		}

	}

}