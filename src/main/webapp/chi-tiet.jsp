<%--
  Created by IntelliJ IDEA.
  User: Tran Van Thai
  Date: 3/15/2024
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body class="container">
    <h1 class="text-center">Đây là trang chi tiết</h1>
    <form action="/sinh-vien/update" method="post">
        <div class="mb-3">
            <label class="form-label">Mã SV</label>
            <input type="text" name="maSV" class="form-control" value="${sinhVienDetail.maSV}" readonly>
        </div>
        <div class="mb-3">
            <label class="form-label">Tên SV</label>
            <input type="text" name="tenSV" class="form-control" value="${sinhVienDetail.tenSV}">
        </div>
        <div class="mb-3">
            <label class="form-label">Tuổi</label>
            <input type="number" name="tuoi" class="form-control" value="${sinhVienDetail.tuoi}">
        </div>
        <div class="mb-3">
            <label class="form-label">Địa chỉ</label>
            <input type="text" name="diaChi" class="form-control" value="${sinhVienDetail.diaChi}">
        </div>
        <div class="mb-3">
            <label class="form-label">Tên lớp</label>
            <select name="tenLop" class="form-select">
                <option value="" hidden="">----SD183----</option>
                <c:forEach items="${tenLop}" var="lop">
                    <option value="${lop}"<c:if test="${sinhVienDetail.tenLop == lop}">selected</c:if>
                        >${lop}</option>

                </c:forEach>
        </select>
        </div>
        <div class="mb-3 row">
            <label class="form-label col">Giới tính</label>
            <div class="col">
                <input type="radio" name="gioiTinh" class="form-check-input" value="Nam"
                <c:if test="${sinhVienDetail.gioiTinh == 'Nam'}">checked</c:if>>
                <label class="form-check-label">Nam</label>
            </div>
            <div class="col">
                <input type="radio" name="gioiTinh" class="form-check-input" value="Nu"
                <c:if test="${sinhVienDetail.gioiTinh == 'Nu'}">checked</c:if>>
                <label class="form-check-label">Nu</label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</body>
</html>
