<%--
  Created by IntelliJ IDEA.
  User: 63406
  Date: 2019/11/20
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>单词测试页面</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
    <h2>单词测试页面</h2>
    <form action="/check" method="post" class="form-inline">
        <div class="form-group">
            <label for="exampleInputEmail1">英文</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="english">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">中文</label>
            <input type="text" class="form-control" id="exampleInputPassword1" name="chinese">
        </div>
        <button type="submit" class="btn btn-default">提交</button>
    </form>

    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
