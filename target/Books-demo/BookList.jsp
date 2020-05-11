<%--
  Created by IntelliJ IDEA.
  User: jishubu_wukaibo
  Date: 2020/5/11
  Time: 10:21 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>列表展示</title>
</head>
<style>
    table {
        width: 100%;
    }

    table td {
        border: 1px solid #000000;
    }
</style>
<body>
<table>
    <tr>
        <a href="">新建</a>
    </tr>
    <tr>
        <td>ID</td>
        <td>书名</td>
        <td>作者</td>
        <td>创建时间</td>
        <td>操作</td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>
            <a href="">修改</a>
            <a href="">删除</a>
        </td>
    </tr>
    <tr>
       <td colspan="5">
           <a>首页</a>
           <a>上一页</a>
           <span>当前页/总页数</span>
           <a>下一页</a>
           <a>尾页</a>
       </td>
    </tr>
</table>
</body>
</html>
