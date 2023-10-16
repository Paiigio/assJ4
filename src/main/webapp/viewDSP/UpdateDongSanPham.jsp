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
    <h3 class="text-center">Sửa dòng sản phẩm</h3>
</header>
<main class="container">


    <section>
        <main class="container">
            <form action="" method="post">
                <div class="col-12">
                    <Label>ID</Label>
                    <input type="text" disabled class="form-control" name="id" value="${dongSP.id} ">
                </div>
                <div class="col-12">
                    <Label>Mã dòng sản phẩm</Label>
                    <input type="text" class="form-control" name="ma" value="${dongSP.ma}">
                </div>
                <div class="col-12">
                    <Label>Tên dòng sản phẩm</Label>
                    <input type="text" class="form-control" name="ten" value="${dongSP.ten}">
                </div>
                <button type="submit" class="mt-5 btn btn-primary justify-content-center" onclick="return confirm('Bạn có muốn sửa?')" style="margin-top: 5px">Update</button>

            </form>
        </main>
    </section>
</main>
</body>
</html>
