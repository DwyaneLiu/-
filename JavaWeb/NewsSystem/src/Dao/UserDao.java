package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.User;

public class UserDao {
    
    //从数据库中查询出符合的用户，用作登陆用
	public User FindUser(Connection con,User user) throws SQLException{
        User resultUser=null;
        String sqlFind="select * from user where username=? and password=?";
        PreparedStatement ps=con.prepareStatement(sqlFind);//
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            resultUser=new User();
            resultUser.setUsername(rs.getString("username"));
            resultUser.setPassword(rs.getString("password"));
        }
        return resultUser;
    }
	//
	public User FindUserByname(Connection con,User user) throws SQLException{
        User resultUser=null;
        String sqlFind="select * from user where username=? ";
        PreparedStatement ps=con.prepareStatement(sqlFind);//
        ps.setString(1, user.getUsername());
        //ps.setString(2, user.getPassword());
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            resultUser=new User();
            resultUser.setUsername(rs.getString("username"));
            //resultUser.setPassword(rs.getString("password"));
        }
        return resultUser;
    }
	//插入数据库,用作注册
	public User AddUser(Connection con,User user) throws SQLException{
	
      
	       String sqlInsert ="insert into user (username, password) value ('"+user.getUsername()+"','"+user.getPassword()+"')";
	       
	       PreparedStatement psInsert=con.prepareStatement(sqlInsert);//
	       
	       psInsert.executeUpdate(sqlInsert);
	        
	       return null;
        
		
	}
    
    
}