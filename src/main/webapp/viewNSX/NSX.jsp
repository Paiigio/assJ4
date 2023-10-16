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
<header class="container justify-content-center"><h3>Quản lý nhà sản xuất </h3></header>
<main class="container">
    <section>
        <a href="/TrangChu" type="button" class="btn btn-primary">Home</a>
        <a href="/nsx/viewadd" class="btn btn-success float-end" role="button">Add</a>
    </section>

    <section>
        <table class="table">
            <thead>

            <tr>
                <th scope="col">ID</th>
                <th scope="col">Mã NSX</th>
                <th scope="col">Tên NSX</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${listNSX}" var="nsx">
                <tr>
                    <td> ${nsx.id}</td>
                    <td> ${nsx.ma}</td>
                    <td> ${nsx.ten}</td>

                    <td>
                        <a href="/nsx/detail?id=${nsx.id}" class="btn btn-success" role="button">Detail</a>
                        <a href="/nsx/delete?id=${nsx.id}" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa?')" role="button">Delete</a>
                        <a href="/nsx/viewupdate?id=${nsx.id}" class="btn btn-primary" role="button">Update</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>
</body>
</html>
