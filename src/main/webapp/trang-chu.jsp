<%--
  Created by IntelliJ IDEA.
  User: Tran Van Thai
  Date: 3/8/2024
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sinh viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body class="container">
<h1 class="text-center">Đây là trang chủ</h1>

<form action="/sinh-vien/add" method="post">
    <div class="mb-3">
        <label class="form-label">Mã SV</label>
        <input type="text" name="maSV" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Tên SV</label>
        <input type="text" name="tenSV" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Tuổi</label>
        <input type="number" name="tuoi" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Địa chỉ</label>
        <input type="text" name="diaChi" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Tên lớp</label>
        <select name="tenLop" class="form-select">
            <option value="" hidden="">----SD183----</option>
            <c:forEach items="${tenLop}" var="lop">
                <option value="${lop}">${lop}</option>

            </c:forEach></option>
        </select>
    </div>
    <div class="mb-3 row">
        <label class="form-label col">Giới tính</label>
       <div class="col">
           <input type="radio" name="gioiTinh" class="form-check-input" value="Nam">
           <label class="form-check-label">Nam</label>
       </div>
      <div class="col">
          <input type="radio" name="gioiTinh" class="form-check-input" value="Nu">
          <label class="form-check-label">Nu</label>
      </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<table class="table table-striped table-hover">
    <thead>
        <td>STT</td>
        <td>Mã SV</td>
        <td>Tên SV</td>
        <td>Địa chỉ</td>
        <td>Tuổi</td>
        <td>Giới tính</td>
        <td>Tên lớp</td>
        <td>Thao tác</td>
    </thead>
    <tbody>
    <c:forEach items="${listSinhVien}" var="sinhVien" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${sinhVien.maSV}</td>
            <td>${sinhVien.tenSV}</td>
            <td>${sinhVien.diaChi}</td>
            <td>${sinhVien.tuoi}</td>
            <td>${sinhVien.gioiTinh}</td>
            <td>${sinhVien.tenLop}</td>
            <td>
                <a href="/sinh-vien/delete?maSinhVien=${sinhVien.maSV}" class="btn btn-danger">Delete</a>
                <a href="/sinh-vien/detail?maSinhVien=${sinhVien.maSV}" class="btn btn-info">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
