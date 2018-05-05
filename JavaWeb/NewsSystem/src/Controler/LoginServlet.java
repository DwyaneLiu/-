package Controler;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Model.User;
import Util.DbUtil;

public class LoginServlet extends HttpServlet{

    DbUtil db=new DbUtil();
    UserDao userDao=new UserDao();
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Connection con=null;
        try {
            User user=new User(username,password);
            con=db.getCon();
            User currentUser=userDao.FindUser(con, user);
            if(currentUser==null){
                //System.out.println("no");
                request.setAttribute("error", "用户名或密码错误");
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }else{
                //System.out.println("yes");
                HttpSession session=request.getSession();
                session.setAttribute("currentUser",currentUser);
                response.sendRedirect("SearchNews.jsp");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	System.out.println("point");
            e.printStackTrace();
        }
        
    }
    
    
}