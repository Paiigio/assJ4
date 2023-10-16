<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 25/07/2023
  Time: 8:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Paiigio-PH29011</title>
    <!-- Favicon -->
    <link href="/img/duong.jpg" rel="icon">

    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
          rel="stylesheet">

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="style.css" rel="stylesheet">

</head>

<body>
<!-- Topbar Start -->
<div class="container-fluid">
    <div class="row bg-secondary py-2 px-xl-5">
        <div class="col-lg-6 d-none d-lg-block">
            <div class="d-inline-flex align-items-center">
                <a class="text-dark" href="">FAQs</a>
                <span class="text-muted px-2">|</span>
                <a class="text-dark" href="">Help</a>
                <span class="text-muted px-2">|</span>
                <a class="text-dark" href="">Support</a>
            </div>
        </div>
        <div class="col-lg-6 text-center text-lg-right">
            <div class="d-inline-flex align-items-center">
                <a class="text-dark px-2" href="">
                    <i class="fab fa-facebook-f"></i>
                </a>
                <a class="text-dark px-2" href="">
                    <i class="fab fa-twitter"></i>
                </a>
                <a class="text-dark px-2" href="">
                    <i class="fab fa-linkedin-in"></i>
                </a>
                <a class="text-dark px-2" href="">
                    <i class="fab fa-instagram"></i>
                </a>
                <a class="text-dark pl-2" href="">
                    <i class="fab fa-youtube"></i>
                </a>
            </div>
        </div>
    </div>
    <div class=" col-lg-12 text-right text-lg-right mt-3">
        <p class="justify-content-end" name="tkDN">${tenTK} <a href="/logout" class="justify-content-end">${logOut}</a>
        </p>
    </div>
    <div class="row align-items-center py-3 px-xl-5">
        <div class="col-lg-3 d-none d-lg-block">
            <a href="/TrangChu" class="text-decoration-none">
                <h1 class="m-0 display-5 font-weight-semi-bold"><span
                        class="text-primary font-weight-bold border px-3 mr-1">P</span>Paiigio Shop</h1>
            </a>
        </div>
        <div class="col-lg-6 col-6 text-left">
            <form action="">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for products">
                    <div class="input-group-append">
                            <span class="input-group-text bg-transparent text-primary">
                                <i class="fa fa-search"></i>
                            </span>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-lg-3 col-6 text-right">
            <a href="" class="btn border">
                <i class="fas fa-heart text-primary"></i>
                <span class="badge">0</span>
            </a>
            <a href="/viewGH" class="btn border">
                <i class="fas fa-shopping-cart text-primary"></i>
                <span class="badge">${size}</span>
            </a>
        </div>
    </div>
</div>
<%--<!-- Topbar End -->--%>


<%--<!-- Navbar Start -->--%>
<div class="container-fluid">
    <div class="row border-top px-xl-5">
        <div class="col-lg-3 d-none d-lg-block">
            <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100"
               data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                <h6 class="m-0">Danh mục</h6>
                <i class="fa fa-angle-down text-dark"></i>
            </a>
            <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light"
                 id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
                <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link" data-toggle="dropdown">Sản phẩm <i
                                class="fa fa-angle-down float-right mt-1"></i></a>
                        <div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
                            <a href="/mausac/hienthi" class="dropdown-item">Quản lý màu sắc</a>
                            <a href="/nsx/hienthi" class="dropdown-item">Quản lý nhà sản xuất</a>
                            <a href="/dongsanpham/hienthi" class="dropdown-item">Quản lý dòng sản phẩm </a>
                            <a href="/sanpham/hienthi" class="dropdown-item">Quản lý sản phẩm </a>
                            <a href="/ctsanpham/hienthi" class="dropdown-item">Quản lý chi tiết sản phẩm </a>
                        </div>
                    </div>
                    <a href="/chucvu/hienthi" class="nav-item nav-link">Chức vụ</a>
                    <a href="/nhanvien/hienthi" class="nav-item nav-link">Nhân viên</a>
                    <a href="/khachhang/hienthi" class="nav-item nav-link">Khách hàng</a>
                    <a href="/cuahang/hienthi" class="nav-item nav-link">Cửa hàng</a>
                </div>
            </nav>
        </div>
        <div class="col-lg-9">
            <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                <a href="" class="text-decoration-none d-block d-lg-none">
                    <h1 class="m-0 display-5 font-weight-semi-bold"><span
                            class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                </a>
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                    <div class="navbar-nav mr-auto py-0">
                        <a href="/TrangChu" class="nav-item nav-link">Home</a>
                        <a href="/TrangChu#SanPham" class="nav-item nav-link">Shop</a>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages</a>
                            <div class="dropdown-menu rounded-0 m-0">
                                <a href="cart.html" class="dropdown-item">Shopping Cart</a>
                                <a href="checkout.html" class="dropdown-item">Checkout</a>
                            </div>
                        </div>
                        <a href="/support" class="nav-item nav-link active">Hỗ trợ</a>
                    </div>

                </div>
            </nav>
        </div>
    </div>
</div>
<%--<!-- Navbar End -->--%>


<!-- Page Header Start -->
<div class="container-fluid bg-secondary mb-5">
    <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
        <h1 class="font-weight-semi-bold text-uppercase mb-3">Shopping Cart</h1>
        <div class="d-inline-flex">
            <p class="m-0"><a href="">Home</a></p>
            <p class="m-0 px-2">-</p>
            <p class="m-0">Shopping Cart</p>
        </div>
    </div>
</div>
<%--<!-- Page Header End -->--%>


<!-- Cart Start -->
<div class="container-fluid pt-5">
    <div class="row px-xl-5">
        <div class="col-lg-8 table-responsive mb-5">
            <table class="table table-bordered text-center mb-0">
                <thead class="bg-secondary text-dark">
                <tr>
                    <th>Hình ảnh</th>
                    <th>Sản phẩm</th>
                    <th>Giá</th>
                    <th>Số lượng</th>
                    <th>Thành tiền</th>
                    <th>Xóa</th>
                </tr>
                </thead>

                <tbody class="align-middle">
                <c:forEach items="${listGH}" var="sp">
                    <form action="/updateViewGioHang" method="post">
                        <tr>
                            <input type="hidden" name="idGH" value="${sp.gioHang.id}">
                            <input type="hidden" name="idSP" value="${sp.chiTietSP.id}">
                            <td class="align-middle"><img src='/hinh/${sp.chiTietSP.hinh}' alt=""
                                                          style="width: 50px;"></td>
                            <td class="align-baseline"> ${sp.chiTietSP.sanPham.ten} ${sp.chiTietSP.mauSac.ten} ${sp.chiTietSP.nsx.ten}</td>
                            <td class="align-middle">${sp.chiTietSP.giaBan}</td>
                            <td class="align-middle">
                                <div class="input-group quantity mx-auto" style="width: 100px;">
                                    <div class="input-group-btn">
                                        <button type="submit" class="btn btn-sm btn-primary btn-minus mt-1 mr-1">
                                            <i class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                    <input type="text" name="soLuong"
                                           class="form-control form-control-sm bg-secondary text-center"
                                           value="${sp.soLuong}">
                                    <div class="input-group-btn">
                                        <button type="submit" class="btn btn-sm btn-primary btn-plus mt-1 m-sm-1">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </div>
                            </td>
                            <td class="align-middle">${sp.donGia}</td>
                            <td class="align-middle">
                                <a href="/deleteViewGioHang?idctsp=${sp.chiTietSP.id}&idgh=${sp.gioHang.id}"
                                   class="btn btn-sm btn-primary"><i class="fa fa-times"></i></a>
                            </td>

                        </tr>
                    </form>
                </c:forEach>

                </tbody>
            </table>
        </div>
        <div class="col-lg-4">
            <form class="mb-5" action="">
                <div class="input-group">
                    <input type="text" class="form-control p-4" placeholder="Coupon Code">
                    <div class="input-group-append">
                        <button class="btn btn-primary">Mã giảm giá</button>
                    </div>
                </div>
            </form>
            <form action="/thanhToanViewGioHang" method="post" class="card border-secondary mb-5">
                <div class="card-header bg-secondary border-0">
                    <h4 class="font-weight-semi-bold m-0">Thông tin </h4>
                </div>
                <div class="card-body">
                    <div class="card-footer border-secondary bg-transparent">
                        <div class="d-flex justify-content-between mt-2">
                            <h6 class="font-weight-medium">Tên người nhận</h6>
                            <input name="tenNguoiNhan" class="font-weight-medium">
                        </div>
                    </div>
                    <div class="card-footer border-secondary bg-transparent">
                        <div class="d-flex justify-content-between mt-2">
                            <h6 class="font-weight-medium">Địa chỉ</h6>
                            <input name="diaChi" class="font-weight-medium">
                        </div>
                    </div>
                    <div class="card-footer border-secondary bg-transparent">
                        <div class="d-flex justify-content-between mt-2">
                            <h6 class="font-weight-medium">SDT</h6>
                            <input name="sdt" class="font-weight-medium">
                        </div>
                    </div>
                    <div class="card-footer border-secondary bg-transparent">
                        <div class="d-flex justify-content-between mt-2">
                            <h5 class="font-weight-bold">Tổng tiền</h5>
                            <h5 class="font-weight-bold"><f:formatNumber type="currency" value="${tongtien}"/></h5>

                        </div>
                    </div>
                </div>
                <div class="card-footer border-secondary bg-transparent">
                    <div class="d-flex justify-content-between mt-2">
                        <h5 class="font-weight-bold">Total</h5>
                        <h5 class="font-weight-bold"></h5>
                    </div>
                    <button type="submit" class="btn btn-block btn-primary my-3 py-3">Thanh toán</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Cart End -->


<%--<!-- Footer Start -->--%>
<jsp:include page="Footer.jsp"></jsp:include>
<%--<!-- Footer End -->--%>

<!-- Back to Top -->
<%--<a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>--%>


<%--<!-- JavaScript Libraries -->--%>
<%--<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>--%>
<%--<script src="lib/easing/easing.min.js"></script>--%>
<%--<script src="lib/owlcarousel/owl.carousel.min.js"></script>--%>

<%--<!-- Contact Javascript File -->--%>
<%--<script src="mail/jqBootstrapValidation.min.js"></script>--%>
<%--<script src="mail/contact.js"></script>--%>

<%--<!-- Template Javascript -->--%>
<%--<script src="js/main.js"></script>--%>
</body>

</html>