package com.qianfeng.shixun.servlet;
import com.qianfeng.shixun.dao.WordDao;
import com.qianfeng.shixun.dao.impl.WordDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 定义第一个Servlet专门用来处理/check请求，默认的Servlet继承于HttpServlet
 */
@WebServlet("/check")
public class CheckServlet extends HttpServlet {
    /**
     * 在Servlet默认要覆写doGet和doPost方法，他们用来处理用户的get和post请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CheckServlet.doPost");
        //Request对象用来放置前端用户传来的请求，包括参数
        req.setCharacterEncoding("utf-8");  //国际编码
        String english = req.getParameter("english");
        String chinese = req.getParameter("chinese");

        /*修改了WordDAO异常处理机制*/
        WordDaoImpl wordDao = new WordDaoImpl();
        String chineseByEng = wordDao.getChineseByEng(english);

        //把用户输入的中文chinese和数据库中查询的中文chineseByEng相比，如果相同则正确
        if(chinese.equals(chineseByEng)){
            req.getRequestDispatcher("ok.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("fail.jsp").forward(req,resp);
        }

        System.out.println("chinese="+chinese);
        System.out.println("english="+english);
        resp.getWriter().println("This is Check Servlet");
    }
}
