package com.qianfeng.shixun.dao;

import com.qianfeng.shixun.bean.Word;

import java.sql.SQLException;
import java.util.List;

public interface WordDao {
    //添加
    void add(int id, String english, String chinese, String type, String comm) throws SQLException;

    //通过对象传值来插入数据
    void add(Word word) throws SQLException;

    //定义一个方法，通过英文得到中文
    String getChineseByEng(String english);

    //定义一个方法，从数据库表中拿出对象，放入到Word对象中，最后以List方式返回
    List<Word> getList();

    //删除
    void delete(int id);

    //修改type
    void update(int id, String english, String chinese, String type, String comm);
}
