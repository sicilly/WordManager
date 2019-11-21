package com.qianfeng.shixun.servlet;
import com.qianfeng.shixun.bean.Word;
import com.qianfeng.shixun.dao.WordDao;
import com.qianfeng.shixun.dao.impl.WordDaoImpl;
import com.qianfeng.shixun.service.WordService;
import com.qianfeng.shixun.service.WordServiceImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
定义一个ListServlet用来处理客户端/list请求，默认覆写的请求是doGet
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从后台查出所有word数据，放入list中

        //在View层，调用service层，使用接口声明，子类实现，符合MVC的调用模式
        WordService wordService=new WordServiceImpl();
        List<Word> list = wordService.getList();
        System.out.println(list);
        //把list数据传入前台
        req.setAttribute("list",list);

        //当前方法执行完跳转到list.jsp页面
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }
}
