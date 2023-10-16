<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
          integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.28//angular-route.min.js"></script> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script type="module" src="app.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular-sanitize.js"></script>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css">

    <title>Home</title>

</head>


<body>
<button class="truck-button">
    <span class="default">Complete Order</span>
    <span class="success">
        Order Placed
        <svg viewbox="0 0 12 10">
            <polyline points="1.5 6 4.5 9 10.5 1"></polyline>
        </svg>
    </span>
    <div class="truck">
        <div class="wheel"></div>
        <div class="back"></div>
        <div class="front"></div>
        <div class="box"></div>
    </div>
</button>

<!-- dribbble - twitter -->
<a class="dribbble" href="https://dribbble.com/shots/9552163-Complete-order-button" target="_blank"><img src="https://cdn.dribbble.com/assets/dribbble-ball-mark-2bd45f09c2fb58dbbfb44766d5d1d07c5a12972d602ef8b32204d28fa3dda554.svg" alt=""></a>
<a class="twitter" target="_blank" href="https://twitter.com/aaroniker_me"><svg xmlns="http://www.w3.org/2000/svg" width="72" height="72" viewBox="0 0 72 72"><path d="M67.812 16.141a26.246 26.246 0 0 1-7.519 2.06 13.134 13.134 0 0 0 5.756-7.244 26.127 26.127 0 0 1-8.313 3.176A13.075 13.075 0 0 0 48.182 10c-7.229 0-13.092 5.861-13.092 13.093 0 1.026.118 2.021.338 2.981-10.885-.548-20.528-5.757-26.987-13.679a13.048 13.048 0 0 0-1.771 6.581c0 4.542 2.312 8.551 5.824 10.898a13.048 13.048 0 0 1-5.93-1.638c-.002.055-.002.11-.002.162 0 6.345 4.513 11.638 10.504 12.84a13.177 13.177 0 0 1-3.449.457c-.846 0-1.667-.078-2.465-.231 1.667 5.2 6.499 8.986 12.23 9.09a26.276 26.276 0 0 1-16.26 5.606A26.21 26.21 0 0 1 4 55.976a37.036 37.036 0 0 0 20.067 5.882c24.083 0 37.251-19.949 37.251-37.249 0-.566-.014-1.134-.039-1.694a26.597 26.597 0 0 0 6.533-6.774z"></path></svg></a>

<!-- nav  -->

<div class="container-fluid  ">
    <nav class="navbar navbar-expand-lg bg-primary ">
        <div class="container col-sm-8">
            <a href="#" class=" me-5 ">
                <img src="./images/logo.png" class="d-block align-text-top" alt="">
                <img src="./images/logo1.png" class="d-block align-text-bottom" alt="">
            </a>
            <!-- form -->
            <form class=" d-flex flex-grow-1 ms-5" role="search">
                <input class="form-control me-2 w-100 fs-3 collapse navbar-collapse " type="search" placeholder="Search"
                       aria-label="Search" id="timkiem" ng-model="tim">
                <button class="btn btn-outline-success fs-5   collapse navbar-collapse text-nowrap" type="submit"
                        style="background-color: #0D5CB6;" id="timkiem" ng-click="timKiem(tim)">
                    <img src="./images/search.png" class="ms-2 me-2" alt="">Tìm kiếm
                </button>
            </form>

            <button class="btn fs-6 btn-outline-dark border border-0 navbar-toggler text-white border-0"
                    data-bs-toggle="collapse" data-bs-target="#timkiem" aria-controls="timkiem" aria-expanded="false"
                    aria-label="Toggle navigation"><img src="./images/search.png" width="30px" alt=""></button>
            <!-- taikhoan mk -->

            <button class="btn btn-outline-dark border border-0 anh" data-bs-toggle="collapse"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation"
                    data-bs-target="#hehe"><img src="./images/login.png" alt=""></button>

            <div>

                <div>
                    <a href="#admin" class="fs-5 text-white collapse navbar-collapse justify-content-end text-nowrap"
                       id="navbarNavAltMarkup" style="text-decoration: none;">Đăng
                        nhập/Đăng ký</a>

                </div>
                <div class="dropdown  collapse navbar-collapse justify-content-end " id="navbarNavAltMarkup">
                    <button class="btn text-white dropdown-toggle fs-5" type="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                        Tài khoản
                    </button>
                    <ul class="dropdown-menu " style="margin-top: 250px;">
                        <li><a class="dropdown-item" href="/chucvu/hienthi">Quản lý chức vụ</a></li>
                        <li><a class="dropdown-item" href="/cuahang/hienthi">Quản lý cửa hàng</a></li>
                        <li><a class="dropdown-item" href="/mausac/hienthi">Quản lý màu sắc</a></li>
                        <li><a class="dropdown-item" href="/sanpham/hienthi">Quản lý sản phẩm </a></li>
                        <li><a class="dropdown-item" href="/nsx/hienthi">Quản lý nhà sản xuất </a></li>
                        <li><a class="dropdown-item" href="/dongsanpham/hienthi">Quản lý nhà dòng sản phẩm </a></li>
                        <li><a class="dropdown-item" href="#">Đăng ký</a></li>
                        <li><a class="dropdown-item" href="#">Tài khoản</a></li>
                    </ul>
                </div>
            </div>
            <!-- giỏ hàng -->

            <div class="ms-2 d-flex col-lg-2">
                <a href="#/giohang" type="button" class="btn btn-primary position-relative">
                    <img src="images/giohang.png" href="#/giohang" alt=""/>
                    <!-- <span class="position-absolute fs-6 top-0 start-300 translate-middle badge rounded-pill bg-warning" >
                      {{slgh}}
                    </span> -->
                </a>
                <a href="#/giohang" class="text-white collapse navbar-collapse  mt-4 text-nowrap ms-1 fs-5"
                   style="text-decoration: none;">Giỏ hàng</a>
            </div>
            <div class="collapse  justify-content-end" id="hehe">
                <div class="navbar-nav">
                    <a class="nav-link active text-white" aria-current="page" href="#pro">Đăng nhập</a>
                    <a class="nav-link text-white" href="#abo mt-2ut">Đăng ký </a>
                    <a class="nav-link text-white" href="#contac">Quên mk</a>
                </div>
            </div>
        </div>
    </nav>
    <marquee direction="right" class="fs-4 fw-bold" style="background-color: palevioletred;"><img src="" alt=""> Nguyễn
        Tùng Dương - PH29011
    </marquee>
</div>

<div col-md-8>
    <div class="container col-sm-12 col-md-8 col-md-push-2 mt-5 ">
        <h2>Nhà Sách Tiki</h2>
    </div>

    <div id="carouselExample" class="container carousel slide col-md-8 col-sm-12">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://salt.tikicdn.com/cache/w1080/ts/tikimsp/fa/51/d2/0c66f36741a6268cbeda79f92e6c7cae.png"
                     class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="https://salt.tikicdn.com/cache/w1080/ts/tikimsp/32/ea/f2/f4a5725dda017ea4c8645d01fe8f570b.png"
                     class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="https://salt.tikicdn.com/cache/w1080/ts/tikimsp/07/df/a1/2604fbab78f9ade7f31ff0a2f9626725.png"
                     class="d-block w-100" alt="...">
            </div>
        </div>
        <button class="carousel-control-prev " type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>

<!-- sách  -->
<ng-view></ng-view>

<!-- kết -->


<div class="container col-md-8 col-md-push-2  ket" style="margin-top: 300px;">
    <div class="row">
        <div class=" col-md-4 col-ms-12 col-lg-2 mx-auto my-2">
            <h3 class="fs-3">Hỗ trợ khách hàng</h3>
            <p class="fs-5">Hotline:1900-6035</p>
            <p class="fs-5">(1000 đ/phút, 8-21h kể cả T7, CN)</p>
            <p class="fs-5">Các câu hỏi thường gặp</p>
            <p class="fs-5">Gửi yêu cầu hỗ trợ</p>
            <p class="fs-5">Hướng dẫn đặt hàng</p>
            <p class="fs-5">Phương thức vận chuyển</p>
            <p class="fs-5">Chính sách đổi trả</p>
            <p class="fs-5">Hướng dẫn trả góp</p>
            <p class="fs-5">Chính sách hàng nhập khẩu</p>
            <p class="fs-5">Hỗ trợ khách hàng:hotro@tiki.vn</p>
            <p class="fs-5">Báo lỗi bảo mật:security@tiki.vn</p>
        </div>
        <div class=" col-md-4 col-ms-12 col-lg-2 mx-auto my-2">
            <h3 class="fs-3">Về Tiki</h3>
            <p class="fs-5">Giới thiệu Tiki</p>
            <p class="fs-5">Tuyển dụng</p>
            <p class="fs-5">Chính sách bảo mật thanh toán</p>
            <p class="fs-5">Chính sách bảo mật thông tin cá nhân</p>
            <p class="fs-5">Chính sách giải quyết khiếu nại</p>
            <p class="fs-5">Điều khoản sử dụng</p>
            <p class="fs-5">Giới thiệu Tiki Xu</p>
            <p class="fs-5">Tiếp thị liên kết cùng Tiki</p>
            <p class="fs-5">Bán hàng doanh nghiệp</p>
            <p class="fs-5">Điều kiện vận chuyển</p>
        </div>
        <div class=" col-md-4 col-ms-12 col-lg-2 mx-auto my-2">
            <h3 class="fs-3">Hợp tác và liên kết</h3>
            <p class="fs-5">Quy chế hoạt động Sàn GDTMĐT</p>
            <p class="fs-5"> Bán hàng cùng Tiki</p>
            <div class="mt-5">
                <h3 class="fs-4">Chứng nhận bởi</h3>
                <div>
                    <img src="images/van.png" class="w-full" alt="">
                    <img src="images/dky.png" class="w-full" alt="">
                </div>
            </div>
        </div>
        <div class=" col-md-4 col-ms-12 col-lg-2 mx-auto my-2">
            <h4 class="fs-3 text-nowrap ">Phương thức thanh toán</h4>
            <div class="">
                <img src="images/Frame.png" class="" alt="">
                <img src="images/Frame-1.png" width="17%" alt="">
                <img src="images/Frame-2.png" width="17%" alt="">
                <img src="images/Frame-3.png" width="17%" alt="">
                <img src="images/Frame-4.png" width="17%" alt="">
            </div>
            <div class="p-0">
                <img src="images/Frame-5.png" width="17%" alt="">
                <img src="images/Frame-6.png" width="17%" alt="">
                <img src="images/Frame-7.png" width="17%" alt="">
                <img src="images/Frame-8.png" width="17%" alt="">
                <img src="images/Frame-9.png" width="17%" alt="">
            </div>
            <div class="p-0">
                <img src="images/Frame-10.png" alt="">
                <img src="images/Frame-11.png" alt="">
            </div>
            <div class="mt-5">
                <h3 class="fs-4 mb-4">Dịch vụ giao hàng</h3>
                <div>
                    <img src="images/giaohang.png"  width="17%"  alt="">

                </div>
            </div>
        </div>
        <div class=" col-md-4 col-ms-12 col-lg-2 mx-auto my-2">
            <h3 class="fs-4 mb-4">r</h3>
            <div>
                <img src="images/fb.png" class="w-full" alt="">
                <img src="images/yt.png" class="w-full ms-2" alt="">
                <img src="images/zalo.png" class="w-full ms-2" alt="">
            </div>
            <div>
                <h3 class="fs-4 mb-2 mt-5 text-nowrap">Tải ứng dụng trên điện thoại</h3>
                <div class="row">
                    <div class="col-sm-4">
                        <img src="images/qr.png" alt="">
                    </div>
                    <div class="col-sm-5 ms-5">
                        <div class="row"><img src="images/as.png" alt=""></div>
                        <div class="row mt-4"><img src="images/gp.png" alt=""></div>
                    </div>
                </div>
            </div>
        </div>

    </div>

</div>

<!-- ket -->
<footer class=" container col-md-8 col-md-push-2  pt-3 " style="border-top: rgb(183, 183, 183) solid 1px;">
    <p class="fs-5">Trụ sở chính: Tòa nhà Viettel, Số 285, đường Cách Mạng Tháng 8, phường 12, quận 10, Thành phố Hồ Chí
        Minh</p>
    <p class="fs-5">Tiki nhận đặt hàng trực tuyến và giao hàng tận nơi, chưa hỗ trợ mua và nhận hàng trực tiếp tại văn
        phòng hoặc
        trung tâm xử lý đơn hàng</p>
    <p class="fs-5">Giấy chứng nhận Đăng ký Kinh doanh số 0309532909 do Sở Kế hoạch và Đầu tư Thành phố Hồ Chí Minh cấp
        lần đầu
        ngày 06/01/2010 và sửa đổi lần thứ 23 ngày 14/02/2022</p>
    <p class="fs-5">© 2022 - Bản quyền của Công ty TNHH Ti Ki</p>
</footer>

<script src="./app.js"></script>
<!-- Option 1: Bootstrap Bundle with Popper -->
<script

        src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta1/js/bootstrap.bundle.min.js"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->

<!-- https://cdnjs.com/libraries/popper.js/2.5.4 -->
<!-- <script
    src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.5.4/umd/popper.min.js"
  ></script>
  <script
    src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta1/js/bootstrap.min.js"
  ></script> -->

<!-- More: https://getbootstrap.com/docs/5.0/getting-started/introduction/ -->
<a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


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