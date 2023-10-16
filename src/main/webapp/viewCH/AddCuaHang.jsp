<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 09/07/2023
  Time: 11:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<header class="container"><h3 class="text-center">Thêm mới cửa hàng</h3></header>
<main class="container">
    <form action="/cuahang/add" method="post">
        <div class="col-mt-4">
            <label>Mã CH :</label>
            <input type="text" class="form-control" name="maCH">
        </div>
        <div class="col-mt-4 mb-5">
            <label>Tên CH :</label>
            <input type="text" class="form-control" name="tenCH">
        </div>
        <div class="col-mt-4 mb-5">
            <label>Địa chỉ :</label>
            <input type="text" class="form-control" name="diaChi">
        </div>
        <div class="col-mt-4 mb-5">
            <label>Thành phố :</label>
            <input type="text" class="form-control" name="thanhPho">
        </div>
        <div class="col-mt-4 mb-5">
            <label>Quốc gia :</label>
            <input type="text" class="form-control" name="quocGia">
        </div>

        <button class="btn btn-success mt-1 text-center" style="margin-top: 20px">ADD</button>
    </form>

</main>
</body>
</html>
