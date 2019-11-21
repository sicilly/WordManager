package com.qianfeng.shixun.dao;

import com.qianfeng.shixun.bean.Word;
import com.qianfeng.shixun.dao.impl.WordDaoImpl;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class WordDAOTest {

    private WordDaoImpl wordDao;

    @Before
    public void before(){
        wordDao = new WordDaoImpl();
    }
    @Test
    //测试数据库表的插入
    public void Test() throws SQLException {
        wordDao.add(12,"apple","苹果","n.","test");
    }

    @Test //通过对象传值
    public void TestAddByObject() throws SQLException {
        //创建一个Word对象，并且通过set方法赋值
        Word word=new Word();
        word.setId(13);
        word.setEnglish("fish");
        word.setChinese("鱼");
        word.setType("n.");
        word.setComm("test");

//        WordDao wordDao=new WordDao();
        wordDao.add(word);
    }

    @Test
    public void testGetChineseByEng() throws SQLException {
        String apple = wordDao.getChineseByEng("apple");
        System.out.println("apple = " + apple);
    }
    @Test //先写测试用例,再写具体的实现代码,这种模式叫做测试驱动开发(TDD)
    public void testGetList(){
        List<Word> list = wordDao.getList();
        System.out.println("list = " + list);
    }

    @Test  //演示了一个删除操作
    public void testDelete(){
        wordDao.delete(2);
    }

    @Test  //演示了一个修改英文
    public void testUpdateEng(){
        wordDao.update(4,"eat","吃","n","update");
    }


}
