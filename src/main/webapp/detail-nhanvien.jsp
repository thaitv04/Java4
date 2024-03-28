<%--
  Created by IntelliJ IDEA.
  User: Tran Van Thai
  Date: 3/16/2024
  Time: 11:37 AM
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
    <h1 class="text-center">Detail nhan vien</h1>
    <form action="/nhan-vien/update" method="post">
        <div class="mb-3">
            <label class="form-label">Ma NV</label>
            <input type="text" name="maNV" class="form-control" value="${nhanVienDetail.maNV}">
        </div>
        <div class="mb-3">
            <label class="form-label">Ten NV</label>
            <input type="text" name="tenNV" class="form-control" value="${nhanVienDetail.tenNV}">
        </div>
        <div class="mb-3">
            <label class="form-label">Chức vụ</label>
            <select name="chucVu" class="form-select">
                <option value="" hidden="">---Mời chọn---</option>
                <c:forEach items="${chucVu}" var="chucVu">
                    <option value="${chucVu}" <c:if test="${nhanVienDetail.chucVu == chucVu}">selected</c:if>>${chucVu}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Tuoi</label>
            <input type="number" name="tuoi" class="form-control" value="${nhanVienDetail.tuoi}">
        </div>
        <div class="mb-3 row">
            <label class="form-label col">Gioi tinh</label>
            <div class="col">
                <input type="radio" name="gioiTinh" class="form-check-input" value="Nam" <c:if test="${nhanVienDetail.gioiTinh == 'Nam'}">checked</c:if>>
                <label class="form-check-label">Nam</label>
            </div>
            <div class="col">
                <input type="radio" name="gioiTinh" class="form-check-input" value="Nữ" <c:if test="${nhanVienDetail.gioiTinh == 'Nữ'}">checked</c:if>>
                <label class="form-check-label">Nữ</label>
            </div>
        </div>
        <button type="submit" class="btn btn-success">Cập nhật</button>
    </form>
</body>
</html>
