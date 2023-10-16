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
    <h3 class="text-center">Add nhân viên</h3>
</header>
<main class="container">
    <section>
        <main class="container">
            <form action="" method="post">
                <div class="col-12">
                    <Label>ID</Label>
                    <input type="text" disabled class="form-control" name="id" required>
                </div>
                <div class="col-12">
                    <Label>Mã</Label>
                    <input type="text" class="form-control" name="ma" required>
                </div>
                <div class="col-12">
                    <Label>Tên</Label>
                    <input type="text" class="form-control" name="ten" required>
                </div>
                <div class="col-12">
                    <Label>Tên đệm</Label>
                    <input type="text" class="form-control" name="tenDem" required>
                </div>
                <div class="col-12">
                    <Label>Họ</Label>
                    <input type="text" class="form-control" name="ho" required>
                </div>
                <div class="col-12">
                    <Label>Giới tính  :</Label>
                    <input type="radio" value="Nam" checked name="gioiTinh" required>Nam
                    <input type="radio" value="Nữ" name="gioiTinh" required>Nữ
                </div>
                <div class="col-12">
                    <Label>Ngày sinh</Label>
                    <input type="date" class="form-control" name="ngaySinh" required>
                </div>
                <div class="col-12">
                    <Label>Địa chỉ</Label>
                    <input type="text" class="form-control" name="diaChi" required>
                </div>
                <div class="col-12">
                    <Label>SDT</Label>
                    <input type="" class="form-control" name="sdt" required>
                </div>
                <div class="col-12 form-group">
                    <Label>Cửa hàng</Label>
                    <select class="form-control" name="cuaHang.id" required>
                        <c:forEach items="${listCH}" var="c">
                        <option value="${c.id}">${c.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-12 form-group">
                    <Label>Chức vụ</Label>
                    <select class="form-control"  name="chucVu.id"  required>
                        <c:forEach items="${listCV}" var="v">
                        <option value="${v.id}">${v.tenCV}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-12">
                    <Label>Mật khẩu</Label>
                    <input type="text" class="form-control" name="matKhau"required>
                </div>
                <button type="submit" class="mt-5 btn btn-primary justify-content-center" style="margin-top: 5px">ADD</button>

            </form>
        </main>
    </section>
</main>
</body>
</html>
