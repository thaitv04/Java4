<%--
  Created by IntelliJ IDEA.
  User: Tran Van Thai
  Date: 3/26/2024
  Time: 1:54 PM
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
        <h1 class="text-center">Hien thi color</h1>
        <table class="table table-striped table-hover">
            <thead>
                <td>ID</td>
                <td>Ma mau</td>
                <td>Ten mau</td>
                <td>Trang thai</td>
                <td>Ngay sua</td>
                <td>Ngay tao</td>
                <td>Chuc nang</td>
            </thead>
            <tbody>
                <c:forEach items="${mauSac}" var="mauSac">
                    <tr>
                        <td>${mauSac.id}</td>
                        <td>${mauSac.maMau}</td>
                        <td>${mauSac.tenMau}</td>
                        <td>${mauSac.trangThai}</td>
                        <td>${mauSac.ngaySua}</td>
                        <td>${mauSac.ngayTao}</td>
                        <td>
                            <button class="btn btn-info">Detail</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>
