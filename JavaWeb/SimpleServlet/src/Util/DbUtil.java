package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    
    //一定要写后面那个UTF-8的字符集的编码，否则数据库查询不了中文
	private String url="jdbc:mysql://localhost:3306/bysj?useUnicode=true&characterEncoding=UTF-8";
    private String user="root";
    private String password="123456";
    private String driver="com.mysql.jdbc.Driver";
    
    public Connection getCon() throws Exception{
        Class.forName(driver);
        Connection con=DriverManager.getConnection(url, user, password);
        return con;
    }
    
    public static void getClose(Connection con) throws SQLException{
        if(con!=null){
            con.close();
        }
    }
    //测试数据库连接
    public static void main(String[] args) {
        DbUtil db=new DbUtil();
        try {
            db.getCon();
            System.out.println("测试连接数据库，连接成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("测试连接数据库，连接失败");
        }
        
    }
}