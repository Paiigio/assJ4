<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 10/07/2023
  Time: 11:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
<header class="container justify-content-center"><h3 class="text-center">Quản lý chi tiết sản phẩm </h3></header>
<main class="">
    <section>
        <a href="/TrangChu" type="button" class="btn btn-primary">Home</a>
        <a href="/ctsanpham/viewadd" class="btn btn-success float-end" role="button">Add</a>
    </section>

    <section>
        <table class="table"enctype="multipart/form-data" >
            <thead>

            <tr>
                <th scope="col">ID</th>
                <th scope="col">Hình ảnh</th>
                <th scope="col">Tên SP</th>
                <th scope="col">Tên NSX</th>
                <th scope="col">Tên MauSac</th>
                <th scope="col">Tên Dong SP</th>
                <th scope="col">Năm BH</th>
                <th scope="col">Mô tả</th>
                <th scope="col">Số lượng tồn</th>
                <th scope="col">Giá nhập</th>
                <th scope="col">Giá bán</th>
                <th scope="col">Action</th>

            </tr>
            </thead>
            <tbody>

            <c:forEach items="${listCTSP}" var="sp">
                <tr>
                    <td> ${sp.id}</td>
                    <td><img src='/hinh/${sp.hinh}'  style="width: 200px;height: 200px" alt=""></td>
                    <td>${sp.sanPham.ten}</td>
                    <td> ${sp.nsx.ten}</td>
                    <td>${sp.mauSac.ten}</td>
                    <td> ${sp.dongSP.ten}</td>
                    <td> ${sp.namBH}</td>
                    <td> ${sp.moTa}</td>
                    <td> ${sp.soLuongTon}</td>
                    <td> ${sp.giaNhap}</td>
                    <td> ${sp.giaBan}</td>


                    <td>
                        <a href="/ctsanpham/detail?id=${sp.id}" class="btn btn-success" role="button">Detail</a> <br>
                        <a href="/ctsanpham/delete?id=${sp.id}" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa?')" role="button">Delete</a><br>
                        <a href="/ctsanpham/viewupdate?id=${sp.id}" class="btn btn-primary" role="button">Update</a><br>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>
</body>
</html>
