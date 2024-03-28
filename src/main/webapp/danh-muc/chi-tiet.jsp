<%--
  Created by IntelliJ IDEA.
  User: Tran Van Thai
  Date: 3/28/2024
  Time: 1:40 PM
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

<form action="/danh-muc/detail" method="post">
    <div class="mb-3">
        <label class="form-label">ID</label>
        <input type="text" class="form-control" name="id" value="${danhMucDetail.id}">
    </div>
    <div class="mb-3">
        <label class="form-label">Ma danh muc</label>
        <input type="text" class="form-control" name="ma" value="${danhMucDetail.ma}">
    </div>
    <div class="mb-3">
        <label class="form-label">Ten danh muc</label>
        <input type="text" class="form-control" name="ten" value="${danhMucDetail.ten}">
    </div>
    <div class="mb-3">
        <label class="form-label">Ngay tao</label>
        <input type="text" name="ngayTao" class="form-control" value="${danhMucDetail.ngayTao}">
    </div>
    <div class="mb-3">
        <label class="form-label">Ngay sua</label>
        <input type="text" name="ngayTao" class="form-control" value="${danhMucDetail.ngaySua}">
    </div>
    <div class="mb-3 row">
        <label class="form-label col">Trang thai</label>
        <div class="col">
            <input type="radio" name="trangThai" class="form-check-input" value="Active" <c:if test="${danhMucDetail.trangThai == 'Active'}">checked</c:if>>
            <label class="form-check-label">Active</label>
        </div>
        <div class="col">
            <input type="radio" name="trangThai" class="form-check-input" value="Inactive" <c:if test="${danhMucDetail.trangThai == 'Inactive'}">checked</c:if>>
            <label class="form-check-label">Inactive</label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Câp nhật</button>
</form>
<c:if test=""></c:if>
