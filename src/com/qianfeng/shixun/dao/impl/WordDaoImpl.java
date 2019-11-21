package com.qianfeng.shixun.dao.impl;
import com.qianfeng.shixun.bean.Word;
import com.qianfeng.shixun.dao.DBUtil;
import com.qianfeng.shixun.dao.WordDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个WordDAO用来操作数据库中Word表的数据
 **/
public class WordDaoImpl implements WordDao {

    public WordDaoImpl(){
        connection = DBUtil.getConnection();
    }
    private Connection connection;
    //添加
    @Override
    public void add(int id, String english, String chinese, String type, String comm) throws SQLException {
        //定义一个sql的预编译语法
        String sql="insert into word(id,english,chinese,type,comm) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int index=1;
        //给预编译参数进行传值
        preparedStatement.setObject(index++,id);
        preparedStatement.setObject(index++,english);
        preparedStatement.setObject(index++,chinese);
        preparedStatement.setObject(index++,type);
        preparedStatement.setObject(index++,comm);
        //执行sql
        preparedStatement.executeUpdate();
    }

    //通过对象传值来插入数据
    @Override
    public void add(Word word) throws SQLException {
        //定义一个sql的预编译语法
        String sql="insert into word(id,english,chinese,type,comm) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int index=1;
        //给预编译参数进行传值
        preparedStatement.setObject(index++,word.getId());
        preparedStatement.setObject(index++,word.getEnglish());
        preparedStatement.setObject(index++,word.getChinese());
        preparedStatement.setObject(index++,word.getType());
        preparedStatement.setObject(index++,word.getComm());
        //执行sql
        preparedStatement.executeUpdate();
    }

    //定义一个方法，通过英文得到中文
    @Override
    public String getChineseByEng(String english){
        String sql="select chinese from word where english=?";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(sql);
            //传参
            preparedStatement.setObject(1,english);
            //得到查询结果
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                //对象转化为字符串
                return  resultSet.getObject(1).toString();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    //定义一个方法，从数据库表中拿出对象，放入到Word对象中，最后以List方式返回
    @Override
    public List<Word> getList() {
        List<Word> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from word");
            while (resultSet.next()) {
                Word word=new Word();
                word.setId(resultSet.getInt(1));
                word.setEnglish(resultSet.getString(2));
                word.setChinese(resultSet.getString(3));
                word.setType(resultSet.getString("type"));
                word.setComm(resultSet.getString("comm"));
                list.add(word);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //删除
    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from word where id=?");
            preparedStatement.setObject(1,id);
            int i=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改type
    @Override
    public void update(int id, String english, String chinese, String type, String comm){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update word set english=?,chinese=?,type=?,comm=? where id=?");
            preparedStatement.setObject(1,english);
            preparedStatement.setObject(2,chinese);
            preparedStatement.setObject(3,type);
            preparedStatement.setObject(4,comm);
            preparedStatement.setObject(5,id);
            int i=preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
