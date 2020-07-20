package dao;



import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {

    static String driver="";
    static String url="";
    static String username="";
    static String password;
    static{
        Properties pro=new Properties();
        InputStream in=BaseDao.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            //加载配置文件
            pro.load(in);
            //获取mysql驱动
            Class.forName("com.mysql.jdbc.Driver");
            driver=pro.getProperty("driver");
            url =pro.getProperty("url");
            username=pro.getProperty("username");
            password=pro.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //连接驱动
    public static Connection getConnection()  {
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //公共查询方法
    public static ResultSet queryStudents(Connection conn,String sql,Object[] params){
        PreparedStatement ps=null;
        ResultSet rs=null;
        if(conn!=null){
            try {
                 ps= conn.prepareStatement(sql);
                 if(params!=null) {
                     for (int i = 0; i < params.length; i++) {
                         ps.setObject(i + 1, params[i]);
                     }
                 }
                rs = ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    //公共增删改方法
    public static int updateStudents(Connection conn ,String sql,Object[] params){

        PreparedStatement ps=null;
       int count=0;
        if(conn!=null){
            try {
                ps= conn.prepareStatement(sql);
                for (int i = 0; i <params.length ; i++) {
                    ps.setObject(i+1,params[i]);
                }
                count = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }


    //关流
    public static boolean close(Connection conn,Statement stmt,ResultSet rs){

        boolean flag=false;//返回true代表关流成功
        if(rs!=null){
            try {
                rs.close();
                rs=null;//垃圾回收GC
                flag=true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt!=null){
            try {
                stmt.close();
                stmt=null;//垃圾回收GC
                flag=true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
                conn=null;//垃圾回收GC
                flag=true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
