package com.qianfeng.shixun.servlet;
import com.qianfeng.shixun.service.WordService;
import com.qianfeng.shixun.service.WordServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
定义一个DeleteService用于处理删除请求
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        //先获取要删除的Id
        String id = req.getParameter("id");
        System.out.println(id);
        WordService wordService = new WordServiceImpl();
        wordService.delete(Integer.parseInt(id));
        //writer.println(id+"Delete OK");
        //演示重定向 无需刷新页面，直接打开一个新的请求
        resp.sendRedirect("/list");
    }
}
