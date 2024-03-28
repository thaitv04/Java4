<%--
  Created by IntelliJ IDEA.
  User: Tran Van Thai
  Date: 3/16/2024
  Time: 11:22 AM
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
    <h1>Trang chu nhan vien</h1>
    <form action="/nhan-vien/add" method="post">
      <div class="mb-3">
        <label class="form-label">Ma NV</label>
        <input type="text" name="maNV" class="form-control">
      </div>
      <div class="mb-3">
        <label class="form-label">Ten NV</label>
        <input type="text" name="tenNV" class="form-control">
      </div>
      <div class="mb-3">
        <label class="form-label">Chức vụ</label>
        <select name="chucVu" class="form-select">
          <option value="" hidden="">---Mời chọn---</option>
         <c:forEach items="${chucVu}" var="chucVu">
           <option value="${chucVu}">${chucVu}</option>
         </c:forEach>
        </select>
      </div>
      <div class="mb-3">
        <label class="form-label">Tuoi</label>
        <input type="number" name="tuoi" class="form-control">
      </div>
      <div class="mb-3 row">
        <label class="form-label col">Gioi tinh</label>
        <div class="col">
          <input type="radio" name="gioiTinh" class="form-check-input" value="Nam">
          <label class="form-check-label">Nam</label>
        </div>
        <div class="col">
          <input type="radio" name="gioiTinh" class="form-check-input" value="Nữ">
          <label class="form-check-label">Nữ</label>
        </div>
      </div>
      <button type="submit" class="btn btn-success">Thêm mới</button>
    </form>
    <table class="table table-striped table-hover">
      <thead>
        <td>STT</td>
        <td>Ma NV</td>
        <td>Ten NV</td>
        <td>Chuc vu</td>
        <td>Tuoi</td>
        <td>Gioi tinh</td>
        <td>Chuc nang</td>
      </thead>
      <tbody>
        <c:forEach items="${listNhanVien}" var="nhanVien" varStatus="i">
          <tr>
            <td>${i.index}</td>
            <td>${nhanVien.maNV}</td>
            <td>${nhanVien.tenNV}</td>
            <td>${nhanVien.chucVu}</td>
            <td>${nhanVien.tuoi}</td>
            <td>${nhanVien.gioiTinh}</td>
            <td>
              <a href="/nhan-vien/detail?idNV=${nhanVien.maNV}" class="btn btn-info">Detail</a>
              <a href="/nhan-vien/delete?idNV=${nhanVien.maNV}" class="btn btn-danger">Delete</a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
</body>
</html>
