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
<header class="container justify-content-center">
    <h3 class="text-center">Sửa chức vụ</h3>
</header>
<main class="container">


    <section>
        <main class="container">
            <form action="" method="post">
                <div class="col-12">
                    <Label>ID</Label>
                    <input type="text" disabled class="form-control" name="idCV" value="${chucvu.id} ">
                </div>
                <div class="col-12">
                    <Label>Mã CV</Label>
                    <input type="text" class="form-control" name="maCV" value="${chucvu.maCV}">
                </div>
                <div class="col-12">
                    <Label>Tên chức vụ</Label>
                    <input type="text" class="form-control" name="tenCV" value="${chucvu.tenCV}">
                </div>
                <button type="submit" onclick="return confirm('Bạn có muốn sửa?')" class="mt-5">Update</button>

            </form>
        </main>
    </section>
</main>
</body>
</html>
