package Controler;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.NewsDao;
import Dao.NewsListDao;
import Model.News;
import Model.NewsList;
import Util.DbUtil;

public class FindNewsServlet extends HttpServlet{

	DbUtil db = new DbUtil();
	NewsDao nd = new NewsDao();
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
		String news_id = request.getParameter("new_id");
		Connection con = null;
		try {
			// NewsList newlist=new NewsList(companyname);
			con = db.getCon();
			News News = nd.getNews(con, news_id);
			if (News == null) {
				System.out.println("没有该公司的新闻");
				//request.setAttribute("newslist", Newslist);
				//request.getRequestDispatcher("NewsList.jsp").forward(request, response);
			} else {
				//System.out.println("yes");
				// HttpSession session=request.getSession();
				// session.setAttribute("currentUser",);
				request.setAttribute("news", News);
				
				request.getRequestDispatcher("NewsContent.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("point");
			e.printStackTrace();
		}

	}
}
