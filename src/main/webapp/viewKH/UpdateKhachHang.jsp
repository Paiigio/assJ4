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
    <h3 class="text-center">Sửa khách hàng</h3>
</header>
<main class="container">


    <section>
        <main class="container">
            <form action="" method="post">
                <div class="col-12">
                    <Label>ID</Label>
                    <input type="text" disabled class="form-control" name="id" value="${khachhang.id} " required>
                </div>
                <div class="col-12">
                    <Label>Mã</Label>
                    <input type="text" class="form-control" name="ma" value="${khachhang.ma}" required>
                </div>
                <div class="col-12">
                    <Label>Tên</Label>
                    <input type="text" class="form-control" name="ten" value="${khachhang.ten}"required>
                </div>
                <div class="col-12">
                    <Label>Tên đệm</Label>
                    <input type="text" class="form-control" name="tenDem" value="${khachhang.tenDem}"required>
                </div>
                <div class="col-12">
                    <Label>Họ</Label>
                    <input type="text" class="form-control" name="ho" value="${khachhang.ho}"required>
                </div>
                <div class="col-12">
                    <Label>Ngày sinh</Label>
                    <input type="date" class="form-control" name="ngaySinh" value="${khachhang.ngaySinh}"required>
                </div>
                <div class="col-12">
                    <Label>SDT</Label>
                    <input type="" class="form-control" name="sdt" value="${khachhang.sdt}"required>
                </div>
                <div class="col-12">
                    <Label>Địa chỉ</Label>
                    <input type="text" class="form-control" name="diaChi" value="${khachhang.diaChi}"required>
                </div>
                <div class="col-12">
                    <Label>Thành phố</Label>
                    <input type="text" class="form-control" name="thanhPho" value="${khachhang.thanhPho}"required>
                </div>
                <div class="col-12">
                    <Label>Quốc Gia</Label>
                    <input type="text" class="form-control" name="quocGia" value="${khachhang.quocGia}"required>
                </div>
                <div class="col-12">
                    <Label>Mật khẩu</Label>
                    <input type="text" class="form-control" name="matKhau" value="${khachhang.matKhau}"required>
                </div>
                <button type="submit" class="mt-5 btn btn-primary justify-content-center" onclick="return confirm('Bạn có muốn sửa?')" style="margin-top: 5px">Update</button>

            </form>
        </main>
    </section>
</main>
</body>
</html>
