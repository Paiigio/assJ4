<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 25/07/2023
  Time: 8:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
  <meta charset="utf-8">

  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="Free HTML Templates" name="keywords">
  <meta content="Free HTML Templates" name="description">

  <!-- Favicon -->
  <title>Paiigio-PH29011</title>
  <!-- Favicon -->
  <link href="/img/duong.jpg" rel="icon">


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
  <style>
    /* customizable snowflake styling */
    .snowflake {
      color: #fff;
      font-size: 1em;
      font-family: Arial, sans-serif;
      text-shadow: 0 0 5px #000;
    }

    @-webkit-keyframes snowflakes-fall{0%{top:-10%}100%{top:100%}}@-webkit-keyframes snowflakes-shake{0%,100%{-webkit-transform:translateX(0);transform:translateX(0)}50%{-webkit-transform:translateX(80px);transform:translateX(80px)}}@keyframes snowflakes-fall{0%{top:-10%}100%{top:100%}}@keyframes snowflakes-shake{0%,100%{transform:translateX(0)}50%{transform:translateX(80px)}}.snowflake{position:fixed;top:-10%;z-index:9999;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;cursor:default;-webkit-animation-name:snowflakes-fall,snowflakes-shake;-webkit-animation-duration:10s,3s;-webkit-animation-timing-function:linear,ease-in-out;-webkit-animation-iteration-count:infinite,infinite;-webkit-animation-play-state:running,running;animation-name:snowflakes-fall,snowflakes-shake;animation-duration:10s,3s;animation-timing-function:linear,ease-in-out;animation-iteration-count:infinite,infinite;animation-play-state:running,running}.snowflake:nth-of-type(0){left:1%;-webkit-animation-delay:0s,0s;animation-delay:0s,0s}.snowflake:nth-of-type(1){left:10%;-webkit-animation-delay:1s,1s;animation-delay:1s,1s}.snowflake:nth-of-type(2){left:20%;-webkit-animation-delay:6s,.5s;animation-delay:6s,.5s}.snowflake:nth-of-type(3){left:30%;-webkit-animation-delay:4s,2s;animation-delay:4s,2s}.snowflake:nth-of-type(4){left:40%;-webkit-animation-delay:2s,2s;animation-delay:2s,2s}.snowflake:nth-of-type(5){left:50%;-webkit-animation-delay:8s,3s;animation-delay:8s,3s}.snowflake:nth-of-type(6){left:60%;-webkit-animation-delay:6s,2s;animation-delay:6s,2s}.snowflake:nth-of-type(7){left:70%;-webkit-animation-delay:2.5s,1s;animation-delay:2.5s,1s}.snowflake:nth-of-type(8){left:80%;-webkit-animation-delay:1s,0s;animation-delay:1s,0s}.snowflake:nth-of-type(9){left:90%;-webkit-animation-delay:3s,1.5s;animation-delay:3s,1.5s}.snowflake:nth-of-type(10){left:25%;-webkit-animation-delay:2s,0s;animation-delay:2s,0s}.snowflake:nth-of-type(11){left:65%;-webkit-animation-delay:4s,2.5s;animation-delay:4s,2.5s}
  </style>
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
                  class="text-primary font-weight-bold border px-3 mr-1">P</span>Paiigio Shop</h1>
        </a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
          <div class="navbar-nav mr-auto py-0">
            <a href="/TrangChu" class="nav-item nav-link">Home</a>
            <a href="/TrangChu#SanPham" class="nav-item nav-link">Shop</a>
            <div class="nav-item ">
              <a href="#" class="nav-link" >Hóa đơn</a>
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
    <h1 class="font-weight-semi-bold text-uppercase mb-3"> Hóa đơn chi tiết</h1>
    <div class="d-inline-flex">
      <p class="m-0"><a href="/TrangChu">Home</a></p>
      <p class="m-0 px-2">-</p>
      <p class="m-0">Hóa đơn</p>
    </div>
  </div>
</div>
<!-- Page Header End -->
<div class="container col-md-10">

  <table class="table table-bordered table-striped">
    <thead class="thead-dark">
    <tr>
      <th scope="col">ID Hóa đơn</th>
      <th scope="col">Hình ảnh</th>
      <th scope="col">Sản phẩm</th>
      <th scope="col">Số lượng</th>
      <th scope="col">Đơn giá </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listHDCT}" var="c">
      <tr>
        <td>${c.hoaDon.id}</td>
        <td><img class="img-fluid w-100" style="height:100px " src='/hinh/${c.chiTietSP.hinh}' alt=""></td>
        <td>${c.chiTietSP.sanPham.ten} ${c.chiTietSP.mauSac.ten} ${c.chiTietSP.nsx.ten} </td>
        <td>${c.soLuong}</td>
        <td>${c.donGia}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

</div>


<%--<!-- Footer Start -->--%>
<jsp:include page="Footer.jsp"></jsp:include>
<%--<!-- Footer End -->--%>
<div class="snowflakes" aria-hidden="true">
  <div class="snowflake">
    ❅
  </div>
  <div class="snowflake">
    ❆
  </div>
  <div class="snowflake">
    ❅
  </div>
  <div class="snowflake">
    ❆
  </div>
  <div class="snowflake">
    ❅
  </div>
  <div class="snowflake">
    ❆
  </div>
  <div class="snowflake">
    ❅
  </div>
  <div class="snowflake">
    ❆
  </div>
  <div class="snowflake">
    ❅
  </div>
  <div class="snowflake">
    ❆
  </div>
  <div class="snowflake">
    ❅
  </div>
  <div class="snowflake">
    ❆
  </div>
</div>

  <!-- Back to Top -->
  <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


  <!-- JavaScript Libraries -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
  <script src="lib/easing/easing.min.js"></script>
  <script src="lib/owlcarousel/owl.carousel.min.js"></script>

  <!-- Contact Javascript File -->
  <script src="mail/jqBootstrapValidation.min.js"></script>
  <script src="mail/contact.js"></script>

  <!-- Template Javascript -->
  <script src="js/main.js"></script>
</body>

</html>