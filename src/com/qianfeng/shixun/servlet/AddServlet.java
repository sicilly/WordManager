package com.qianfeng.shixun.servlet;

import com.qianfeng.shixun.bean.Word;
import com.qianfeng.shixun.dao.impl.WordDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CheckServlet.doPost");
        //Request对象用来放置前端用户传来的请求，包括参数
        req.setCharacterEncoding("utf-8");  //国际编码
//        private Integer id;
//        private String english;
//        private String chinese;
//        private String type;
//        private String comm;

        Word word = new Word();
        word.setId(Integer.parseInt(req.getParameter("id")));
        word.setEnglish(req.getParameter("english"));
        word.setChinese(req.getParameter("chinese"));
        word.setType(req.getParameter("type"));
        word.setComm(req.getParameter("comm"));

        /*修改了WordDAO异常处理机制*/
        WordDaoImpl wordDao = new WordDaoImpl();

        try {
            wordDao.add(word);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("添加错误");
        }

        //writer.println(id+"Delete OK");
        //演示重定向 无需刷新页面，直接打开一个新的请求
        resp.sendRedirect("/index.jsp");
    }
}
