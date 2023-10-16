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
<header class="container justify-content-center"><h3 class="text-center">Quản lý nhân viên </h3></header>
<main class="">
    <section>
        <a href="/TrangChu" type="button" class="btn btn-primary">Home</a>
        <a href="/nhanvien/viewadd" class="btn btn-success float-end" role="button">Add</a>
    </section>

    <section>
        <table class="table">
            <thead>

            <tr>
                <th scope="col">ID</th>
                <th scope="col">Mã</th>
                <th scope="col">Họ và tên</th>
                <th scope="col">Giới Tính</th>
                <th scope="col">Ngày Sinh</th>
                <th scope="col">Địa chi</th>
                <th scope="col">SDT</th>
                <th scope="col">MK</th>
                <th scope="col">TênCH</th>
                <th scope="col">TênCV</th>
                <th scope="col">Trạng thái</th>
                <th scope="col">Action</th>

            </tr>
            </thead>
            <tbody>

            <c:forEach items="${listNV}" var="sp">
                <tr>
                    <td> ${sp.id}</td>
                    <td> ${sp.ma}</td>
                    <td>${sp.ho} ${sp.tenDem} ${sp.ten}</td>
                    <td> ${sp.gioiTinh}</td>
                    <td> <f:formatDate value="${sp.ngaySinh}" pattern="dd/MM/yyyy"/> </td>
                    <td> ${sp.diaChi}</td>
                    <td> ${sp.sdt}</td>
                    <td> ${sp.matKhau}</td>
                    <td> ${sp.cuaHang.ten}</td>
                    <td> ${sp.chucVu.tenCV}</td>
                    <td>
                        <c:if test="${sp.trangThai== '0'}">
                            Đi làm
                        </c:if>
                        <c:if test="${sp.trangThai == '1'}">
                            Nghỉ làm
                        </c:if>
                    </td>


                    <td>
                        <a href="/nhanvien/detail?id=${sp.id}" class="btn btn-success" role="button">Detail</a> <br>
                        <a href="/nhanvien/delete?id=${sp.id}" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa?')" role="button">Delete</a><br>
                        <a href="/nhanvien/viewupdate?id=${sp.id}" class="btn btn-primary" role="button">Update</a><br>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>
</body>
</html>
