<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 10/07/2023
  Time: 11:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
<header class="container justify-content-center"><h3>Quản lý khách hàng </h3></header>
<main class="container">
    <section>
        <a href="/TrangChu" type="button" class="btn btn-primary">Home</a>
        <a href="/khachhang/viewadd" class="btn btn-success float-end" role="button">Add</a>
    </section>

    <section>
        <table class="table">
            <thead>

            <tr>
                <th scope="col">ID</th>
                <th scope="col">Mã</th>
                <th scope="col">Tên khách hàng</th>
                <th scope="col">Ngày sinh</th>
                <th scope="col">SDT</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Thành Phố</th>
                <th scope="col">Quốc gia</th>
                <th scope="col">Mật khẩu</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${listKH}" var="kh">
                <tr>
                    <td> ${kh.id}</td>
                    <td> ${kh.ma}</td>
                    <td>${kh.ho} ${kh.tenDem} ${kh.ten}</td>
                    <td> ${kh.ngaySinh}</td>
                    <td> ${kh.sdt}</td>
                    <td> ${kh.diaChi}</td>
                    <td> ${kh.thanhPho}</td>
                    <td> ${kh.quocGia}</td>
                    <td> ${kh.matKhau}</td>

                    <td>
                        <a href="/khachhang/detail?id=${kh.id}" class="btn btn-success" role="button">Detail</a><br>
                        <a href="/khachhang/delete?id=${kh.id}" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa?')" role="button">Delete</a><br>
                        <a href="/khachhang/viewupdate?id=${kh.id}" class="btn btn-primary" role="button">Update</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>
</body>
</html>
