<%--
  Created by IntelliJ IDEA.
  User: Tran Van Thai
  Date: 3/25/2024
  Time: 2:51 PM
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

<form action="/san-pham/add" method="post">
        <div class="mb-3">
            <label class="form-label">Ma san pham</label>
            <input type="text" class="form-control" name="ma">
        </div>
        <div class="mb-3">
            <label class="form-label">Ten san pham</label>
            <input type="text" class="form-control" name="ten">
        </div>
    <div class="mb-3">
        <label class="form-label">Ten danh muc</label>
        <select name="danhMuc" class="form-select">
            <c:forEach items="${danhMuc}" var="danhMuc">
                <option value="${danhMuc.id}">${danhMuc.ten}</option>
            </c:forEach>
        </select>
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
    <td>Id</td>
    <td>Ma san pham</td>
    <td>Ten san pham</td>
    <td>Trang thai</td>
    <td>Ngay tao</td>
    <td>Ngay sua</td>
    <td>Id danh muc</td>
    <td>Thao tác</td>
    </thead>
    <tbody>
    <c:forEach items="${sanPham}" var="sp" varStatus="i">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.maSP}</td>
            <td>${sp.ten}</td>
            <td>${sp.trangThai}</td>
            <td>${sp.ngayTao}</td>
            <td>${sp.ngaySua}</td>
            <td>${sp.danhMuc.ten}</td>
            <td>
                <a href="/san-pham/delete?maSP=${sp.id}" class="btn btn-danger">Delete</a>
                <a href="" class="btn btn-info">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
