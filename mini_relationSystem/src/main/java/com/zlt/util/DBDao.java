/**
 * @Description: java类作用描述
 * @Author: weixia
 * @CreateDate: 2019/7/24$ 20:07$
 * @UpdateUser: yc
 * @UpdateDate: 2019/7/24$ 20:07$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
package com.zlt.util;

import java.sql.*;

public class DBDao {
    private String url="jdbc:mysql://localhost:3306/webdb";
    private String name="root";
    private String password="xw132028";
    private Connection con=null;
    private ResultSet res=null;
    private PreparedStatement ps=null;
    private Statement sts=null;
    static{                                                     //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DBDao(){
        try {
            con= DriverManager.getConnection(url,name,password);        //初始化Connection对象
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(String sql){                          //向数据库插入数据方法
        try {
            sts=con.createStatement();
            return sts.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(String sql){                      //更新数据库数据的方法
        try {
            sts=con.createStatement();
            return sts.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ResultSet select(String sql){                //查询数据方法
        try {
            return con.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
