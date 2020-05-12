<%--
  Created by IntelliJ IDEA.
  User: jishubu_wukaibo
  Date: 2020/5/12
  Time: 10:54 上午
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<form action="/Books_demo_war/book/insertOrUpdate.do">
    <input type="hidden" name="id" value="${book.id}"/>
    <table>
        <tr>
            <td>书名:</td>
            <td>
                <input type="text" name="bookTitle" value="${book.title}"/>
            </td>
        </tr>
        <tr>
            <td>作者:</td>
            <td>
                <input type="text" name="name" value="${book.name}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
