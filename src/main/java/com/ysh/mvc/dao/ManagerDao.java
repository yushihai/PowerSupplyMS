package com.ysh.mvc.dao;

import com.ysh.mvc.bean.Manager;
import com.ysh.mvc.dbConnect.Connect;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class ManagerDao {

    public ManagerDao() throws Exception {
    }

    public boolean loginConfirm(Manager manager) throws Exception {
        Connection conn= Connect.getConnection();
        Statement statement=conn.createStatement();
        String sql="select count(*) count from manager where name='"+manager.getName()+"' and password='"+manager.getPassword()+"'";
        ResultSet set=statement.executeQuery(sql);
        set.next();
        int size=set.getInt("count");
        set.close();
        statement.close();
        conn.close();

        if(size==0)
            return false;

        return true;
    }
}
