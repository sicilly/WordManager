package com.qianfeng.shixun.service;

import com.qianfeng.shixun.bean.Word;
import com.qianfeng.shixun.dao.WordDao;
import com.qianfeng.shixun.dao.impl.WordDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class WordServiceImpl implements WordService {
    //    因为要在Service调动DAO的数据,所以在Service要声明一个DAO对象,然后在构造器构建即可
    private WordDao wordDao;

    public WordServiceImpl() {
        this.wordDao = new WordDaoImpl();
    }

    @Override
    public void add(Word word) throws SQLException {
        wordDao.add(word);
    }

    @Override
    public String getChineseByEng(String english) {
        return null;
    }

    @Override
    public List<Word> getList() {
        return wordDao.getList();
    }

    @Override
    public void delete(int id) {
        wordDao.delete(id);
    }
}