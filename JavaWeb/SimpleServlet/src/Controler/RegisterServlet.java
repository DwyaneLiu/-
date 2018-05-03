package Controler;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import Model.User;
import Util.DbUtil;

public class RegisterServlet extends HttpServlet{

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
            User currentUser=userDao.FindUserByname(con, user);
            if(currentUser == null){
                //System.out.println("no");
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                userDao.AddUser(con, user);
                response.sendRedirect("Login.jsp");
            }else{
                //System.out.println("yes");
                //HttpSession session=request.getSession();
                //session.setAttribute("currentUser",currentUser);
            	request.setAttribute("error2", "用户名重复请重新注册");
            	request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	System.out.println("RegisterServlet文件出现问题");
            e.printStackTrace();
        }
        
    }
    
    
}