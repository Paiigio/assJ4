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
    <h3 class="text-center">Update nhân viên</h3>
</header>
<main class="container">
    <section>
        <main class="container">
            <form action="" method="post">
                <div class="col-12">
                    <Label>ID</Label>
                    <input type="text" disabled class="form-control" value="${listNVUD.id}" name="id" required>
                </div>
                <div class="col-12">
                    <Label>Mã</Label>
                    <input type="text" class="form-control"value="${listNVUD.ma}"  name="ma" required>
                </div>
                <div class="col-12">
                    <Label>Tên</Label>
                    <input type="text" class="form-control"value="${listNVUD.ten}"  name="ten" required>
                </div>
                <div class="col-12">
                    <Label>Tên đệm</Label>
                    <input type="text" class="form-control" value="${listNVUD.tenDem}"  name="tenDem" required>
                </div>
                <div class="col-12">
                    <Label>Họ</Label>
                    <input type="text" class="form-control"value="${listNVUD.ho}"  name="ho" required>
                </div>

                <div class="col-12">
                    <Label>Giới tính  :</Label>
                    <input type="radio" value="Nam" <c:if test="${listNVUD.gioiTinh=='Nam'}">checked</c:if>  name="gioiTinh" required>Nam
                    <input type="radio" value="Nữ" <c:if test="${listNVUD.gioiTinh=='Nữ'}">checked</c:if>  name="gioiTinh" required>Nữ
                </div>
                <div class="col-12">
                    <Label>Ngày sinh</Label>
                    <input type="date" class="form-control"  value="${listNVUD.ngaySinh}" name="ngaySinh" required>
                </div>
                <div class="col-12">
                    <Label>Địa chỉ</Label>
                    <input type="text" class="form-control" value="${listNVUD.diaChi}" name="diaChi" required>
                </div>
                <div class="col-12">
                    <Label>SDT</Label>
                    <input type="" class="form-control" value="${listNVUD.sdt}" name="sdt" required>
                </div>

                <div class="col-12 form-group">
                    <Label>Cửa hàng</Label>
                    <select class="form-control" name="cuaHang.id" required>
                        <c:forEach items="${listCH}" var="c">
                        <option value="${c.id}" <c:if test="${c.id==listNVUD.cuaHang.id}">selected</c:if>> ${c.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-12 form-group">
                    <Label>Chức vụ</Label>
                    <select class="form-control"  name="chucVu.id"  required>
                        <c:forEach items="${listCV}" var="v">
                        <option value="${v.id}" <c:if test="${v.id==listNVUD.chucVu.id}">selected</c:if> >${v.tenCV}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-12">
                    <Label>Mật khẩu</Label>
                    <input type="text" class="form-control" value="${listNVUD.matKhau}" name="matKhau"required>
                </div>
                <div class="col-12">
                    <Label>Trạng thái  :</Label>
                    <input type="radio" value="0" <c:if test="${listNVUD.trangThai==0}">checked</c:if>  name="trangThai" required>Đi làm
                    <input type="radio" value="1" <c:if test="${listNVUD.trangThai==1}">checked</c:if>  name="trangThai" required>Nghỉ làm
                </div>
                <button type="submit" class="mt-5 btn btn-primary justify-content-center" onclick="return confirm('Bạn có muốn sửa?')" style="margin-top: 5px">Update</button>

            </form>
        </main>
    </section>
</main>
</body>
</html>
