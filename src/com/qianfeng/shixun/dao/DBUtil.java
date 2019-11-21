package com.qianfeng.shixun.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
/*
提供一个工具类,用来得到连接对象Connection,
 */
public class DBUtil {
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/wordmanager", "root", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        DBUtil.connection = connection;
    }

    public void after() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

