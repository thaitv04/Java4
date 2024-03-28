<%--
  Created by IntelliJ IDEA.
  User: Tran Van Thai
  Date: 3/25/2024
  Time: 4:56 PM
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

<form action="/danh-muc/add" method="post">
    <div class="mb-3">
        <label class="form-label">Ma danh muc</label>
        <input type="text" class="form-control" name="ma">
    </div>
    <div class="mb-3">
        <label class="form-label">Ten danh muc</label>
        <input type="text" class="form-control" name="ten">
    </div>
    <div class="mb-3 row">
        <label class="form-label col">Trang thai</label>
        <div class="col">
            <input type="radio" name="trangThai" class="form-check-input" value="Active">
            <label class="form-check-label">Active</label>
        </div>
        <div class="col">
            <input type="radio" name="trangThai" class="form-check-input" value="Inactive">
            <label class="form-check-label">Inactive</label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<table class="table table-striped table-hover">
    <thead>
    <td>ID</td>
    <td>Ma danh muc</td>
    <td>Ten danh muc</td>
    <td>Trang thai</td>
    <td>Ngay tao</td>
    <td>Ngay sua</td>
    <td>Chuc nang</td>

    </thead>
    <tbody>
    <c:forEach items="${danhMuc}" var="d" varStatus="i">
        <tr>
            <td>${d.id}</td>
            <td>${d.ma}</td>
            <td>${d.ten}</td>
            <td>${d.trangThai}</td>
            <td>${d.ngayTao}</td>
            <td>${d.ngaySua}</td>
            <td>
                <a href="/danh-muc/delete?maSP=${d.ma}" class="btn btn-danger">Delete</a>
                <a href="/danh-muc/detail?maSP=${d.ma}" class="btn btn-info">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
