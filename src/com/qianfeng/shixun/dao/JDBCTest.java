package com.qianfeng.shixun.dao;

import com.mysql.jdbc.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class JDBCTest {
    private Connection connection;
    private Statement statement;

    @Before
    public void before() throws ClassNotFoundException, SQLException {
        //实际注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.得到数据库连接Connection，它是java程序连接数据库的通道
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordmanager","root","");

        //打印connection，看是否连接上
        System.out.println("connection = " + connection);

        //3.得到statement对象
        statement = connection.createStatement();
    }

    @After
    public void after() throws SQLException {
        //5.关闭statement对象
        statement.close();

        //6.关闭Connection连接对象
        connection.close();
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1.注册驱动,连接数据库第一步
        //DriverManager.registerDriver(new Driver()); //不推荐

//        //实际注册驱动
//        Class.forName("com.mysql.jdbc.Driver");
//
//        //2.得到数据库连接Connection，它是java程序连接数据库的通道
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordmanager","root","");
//
//        //打印connection，看是否连接上
//        System.out.println("connection = " + connection);
//
//        //3.得到statement对象
//        Statement statement = connection.createStatement();
//        //4.执行sql语句
//        statement.executeUpdate("update word set comm='调试使用' where id=8");
//
//        //5.关闭statement对象
//        statement.close();
//
//        //6.关闭Connection连接对象
//        connection.close();
    }

    /*
    使用单元测试 测试表的插入
     */
    private void executeSql(String sql) throws SQLException {
        statement.executeUpdate(sql);
    }

    @Test
    public void testInsert() throws  SQLException {
        String sql="insert into word(id,english,chinese,type,comm) values (11,'pig','猪','n.','王')";
        //4.执行sql语句
        executeSql(sql);
    }
/*
    @Test
    public void testDelete() throws SQLException {
        //String sql="delete word where id=8";
        //4.执行sql语句
        executeSql(sql);
    }
*/
    @Test
    public void testSelect() throws SQLException {
        //通过executeQuery获得结果集ResultSet
        ResultSet resultSet = statement.executeQuery("select * from word");
        //遍历当前表中所有的值，指导遍历完成
        while (resultSet.next()){
            System.out.println("resultSet.getObject(1) = " + resultSet.getObject(1));
            System.out.println("resultSet.getObject(1) = " + resultSet.getObject(2));
            System.out.println("resultSet.getObject(1) = " + resultSet.getObject(3));
            System.out.println("resultSet.getObject(1) = " + resultSet.getObject(4));
            System.out.println("====================");
        }
    }
    //查询某个单词的翻译，如果有就返回中文释义，如果没有就返回为null
    @Test
    public void testSelectByEnglish() throws SQLException {
        String str="123";
        ResultSet resultSet = statement.executeQuery("select * from word where english='"+str+"'");
        if(resultSet.next()){
            System.out.println("查到结果为："+resultSet.getObject("chinese"));
        }else{
            System.out.println("没有查到");
        }
    }

    @Test
    public void testPrepareStatement() throws SQLException {
        String str="cat";
        //使用预编译Statement来进行查询，传参时候不用字符串拼接,使用?占位符
        PreparedStatement preparedStatement = connection.prepareStatement("select * from word where english=?");
        preparedStatement.setObject(1,str);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            System.out.println("查到结果为："+resultSet.getObject("chinese"));
        }else{
            System.out.println("没有查到");
        }
    }
}
