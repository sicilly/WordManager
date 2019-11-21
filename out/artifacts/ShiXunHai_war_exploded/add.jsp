<%--
  Created by IntelliJ IDEA.
  User: 63406
  Date: 2019/11/21
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>单词添加页面</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<h2>单词添加页面</h2>
<form action="/add" method="post" class="form-inline">
    <div class="form-group">
        <label for="wordId">单词ID</label>
        <input type="text" class="form-control" id="wordId" name="id">
    </div>
    <div class="form-group">
        <label for="english">英文</label>
        <input type="text" class="form-control" id="english" name="english">
    </div>
    <div class="form-group">
        <label for="chinese">中文</label>
        <input type="text" class="form-control" id="chinese" name="chinese">
    </div>
    <div class="form-group">
        <label for="type">词性</label>
        <input type="text" class="form-control" id="type" name="type">
    </div>
    <div class="form-group">
        <label for="comm">备注</label>
        <input type="text" class="form-control" id="comm" name="comm">
    </div>
    <button type="submit" class="btn btn-default">提交</button>

</form>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
