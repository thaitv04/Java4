<%--
  Created by IntelliJ IDEA.
  User: Tran Van Thai
  Date: 3/26/2024
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body class="container">
<table class="table table-striped table-hover">
    <thead>
    <td>Id</td>
    <td>Ma size</td>
    <td>Ten size</td>
    <td>Trang thai</td>
    <td>Ngay tao</td>
    <td>Ngay sua</td>
    <td>Thao tác</td>
    </thead>
    <tbody>
    <c:forEach items="${size}" var="size">
        <tr>
            <td>${size.id}</td>
            <td>${size.ma}</td>
            <td>${size.ten}</td>
            <td>${size.trangThai}</td>
            <td>${size.ngaySua}</td>
            <td>${size.ngayTao}</td>
            <td>
                <button href="" class="btn btn-info">Detail</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
