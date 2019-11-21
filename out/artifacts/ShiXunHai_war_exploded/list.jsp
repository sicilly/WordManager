<%@ page import="java.util.List" %>
<%@ page import="com.qianfeng.shixun.bean.Word" %><%--
  Created by IntelliJ IDEA.
  User: 63406
  Date: 2019/11/20
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<h1>这个是List页面</h1>

<table class="table">
    <tr>
        <td>ID</td>
        <td>英文</td>
        <td>中文</td>
        <td>词性</td>
        <td>备注</td>
        <td>操作</td>
    </tr>
    <%
        //从后端拿到List数据，进行前端的展示
        List<Word> list = (List<Word>)request.getAttribute("list");
        for (Word word : list) {
            out.write("<tr>");
            out.write("<td>"+word.getId().toString()+"</td>");
            out.write("<td>"+word.getEnglish()+"</td>");
            out.write("<td>"+word.getChinese()+"</td>");
            out.write("<td>"+word.getType()+"</td>");
            out.write("<td>"+word.getComm()+"</td>");
            out.write("<td>"+"<a href='/delete?id="+word.getId()+"' class='btn btn-danger'>删除</a>"+"</td>");
            out.write("</tr>");

        }
    %>
</table>
<script src="js/jquery-1.11.0.js"></script>
　<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
