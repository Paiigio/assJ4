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
    <h3 class="text-center">Update chi tiết sản phẩm</h3>
</header>
<main class="container">
    <section>
        <main class="container">
            <form action="" method="post">
                <div class="col-12">
                    <Label>ID</Label>
                    <input type="text" disabled class="form-control" name="id" required>
                </div>

                <div class="col-12 form-group">
                    <Label>Tên sản phẩm</Label>
                    <select class="form-control" name="sanPham.id" required>
                        <c:forEach items="${listSP}" var="v">
                            <option value="${v.id}" <c:if test="${v.id==listUD.sanPham.id}">selected</c:if>>${v.ten}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="col-12 form-group">
                    <Label>Tên nhà sản xuất</Label>
                    <select class="form-control" name="nsx.id" required>
                        <c:forEach items="${listNSX}" var="nsx">
                            <option value="${nsx.id}"<c:if test="${nsx.id==listUD.nsx.id}">selected</c:if> >${nsx.ten}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="col-12 form-group">
                    <Label>Tên màu sắc</Label>
                    <select class="form-control" name="mauSac.id" required>
                        <c:forEach items="${listMS}" var="ms">
                            <option value="${ms.id}"    <c:if test="${ms.id==listUD.mauSac.id}">selected</c:if>  >${ms.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-12 form-group">
                    <Label>Tên dòng sản phẩm</Label>
                    <select class="form-control" name="dongSP.id" required>
                        <c:forEach items="${listDongSP}" var="dsp">
                            <option value="${dsp.id}"  <c:if test="${dsp.id==listUD.dongSP.id}">selected</c:if>>${dsp.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-12">
                    <Label>Năm bảo hành :</Label>
                    <input type="number" value="${listUD.namBH}"   class="form-control" min="1" name="namBH" required>
                </div>
                <div class="col-12">
                    <Label>Mô tả</Label>
                    <textarea class="form-control" name="moTa"  maxlength="40" required>${listUD.moTa}</textarea>
                </div>
                <div class="col-12">
                    <Label>Số lượng tồn</Label>
                    <input type="number" class="form-control" min="1" value="${listUD.soLuongTon}"  name="soLuongTon" required>
                </div>
                <div class="col-12">
                    <Label>Giá nhập</Label>
                    <input type="number" class="form-control" min="100" value="${listUD.giaNhap}"  name="giaNhap" required>
                </div>
                <div class="col-12">
                    <Label>Giá bán</Label>
                    <input type="number" class="form-control" min="100" value="${listUD.giaBan}" name="giaBan" required>
                </div>
                <div class="form-group">
                    <label>Photo:</label>
                    <input type="file" class="form-control" name="hinh" value="$" placeholder="Enter photo">
                </div>
                <button type="submit" class="mt-5 btn btn-primary justify-content-center" onclick="return confirm('Bạn có muốn sửa?')" style="margin-top: 5px">Sửa
                </button>

            </form>
        </main>
    </section>
</main>
</body>
</html>
