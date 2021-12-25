package com.ysh.mvc.dbConnect;

import java.sql.*;

public class Connect {

    public static Connection getConnection() throws Exception{
        //加载数据库驱动程序
        //jdbc驱动
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/psms?&useSSL=false&serverTimezone=UTC";
        String user="root";
        String password="admin";
        Connection conn = null;
        try {
            //注册JDBC驱动程序
            Class.forName(driver);
            //建立连接
            conn = DriverManager.getConnection(url, user, password);
            if (!conn.isClosed()) {
                System.out.println("数据库连接成功");
            }
            //conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
        return conn;
    }
}
