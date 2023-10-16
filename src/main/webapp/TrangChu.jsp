<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">
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

<body class="container-fluid">

<jsp:include page="Menu.jsp"></jsp:include>
<!-- Products Start -->
<div class="container">
    <div class="text-center mb-4" id="SanPham">
        <h2 class="section-title px-5"><span class="px-2">Danh sách sản phẩm</span></h2>
    </div>
</div>
<div class="container-fluid pt-5">
    <div class="row px-xl-5">
        <!-- Shop Sidebar Start -->
        <div class="col-lg-3 col-md-12">
            <!-- Price Start -->
            <div class="border-bottom mb-4 pb-4">
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link font-weight-semi-bold  mb-4 text-dark " data-toggle="dropdown">Giá sản
                        phẩm <i class="fa fa-angle-down float-right mt-1"></i></a>
                    <div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href="/TrangChu">All</a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href="/giaSP?start=0&end=100000">0 - 100.000VND</a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href="/giaSP?start=100000&end=200000">100.000VND - 200.000VND</a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href="/giaSP?start=200000&end=400000">200.000VND - 400.000VND</a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href="/giaSP?start=400000&end=1000000">400.000VND++</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Price End -->

            <!-- Color Start -->
            <div class="border-bottom mb-4 pb-4">
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link font-weight-semi-bold  mb-4 text-dark " data-toggle="dropdown">Màu Sắc
                        <i class="fa fa-angle-down float-right mt-1"></i></a>
                    <div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href="/TrangChu">All</a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href="/mauSP?ms=Đỏ">Đỏ</a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href="/mauSP?ms=Vàng">Vàng</a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href="/mauSP?ms=Đen">Đen</a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href="/mauSP?ms=Xanh nước biển">Xanh nước biển</a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href="/mauSP?ms=Hồng">Hồng</a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href="/mauSP?ms=Trắng">Trắng</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Color End -->

            <div class="border-bottom mb-4 pb-4">
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link font-weight-semi-bold  mb-4 text-dark " data-toggle="dropdown">Thương
                        hiệu <i class="fa fa-angle-down float-right mt-1"></i></a>
                    <div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href="/TrangChu">All</a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href="/nsxSP?nsx=Addidas">Addidas</a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href="/nsxSP?nsx=Nike">Nike</a>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <a href="/nsxSP?nsx=LouisVuitton">LouisVuitton</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <div class="col-lg-9 row float-right">
            <c:forEach items="${listTrangChu}" var="sp">

                <form action="/addSPGH" method="post" class="col-lg-4 col-md-4 col-sm-12 pb-1 ">
                    <div class="card product-item border-0 mb-4">
                        <input type="hidden" name="idSP" VALUE="${sp.id}">
                        <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                            <img class="img-fluid w-100" style="height:350px " src='/hinh/${sp.hinh}' alt="">
                        </div>
                        <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                            <h6 class="text-truncate mb-3">${sp.sanPham.ten} ${sp.mauSac.ten}</h6>
                            <h6 class="text-truncate mb-3">${sp.nsx.ten}</h6>
                            <div class="d-flex justify-content-center">
                                <h6><f:formatNumber type="currency" value="${sp.giaBan}"/></h6>
                                <h6 class="text-muted ml-2">
                                    <del>${sp.giaNhap}</del>
                                </h6>
                            </div>
                        </div>
                        <input type="hidden" name="soLuong" value="1">
                        <div class="card-footer d-flex justify-content-between bg-light border">
                            <a href="/detail?id=${sp.id}" class="btn btn-sm text-dark p-0"><i
                                    class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                            <button type="submit" class="btn btn-sm text-dark p-0"><i
                                    class="fas fa-shopping-cart text-primary mr-1"></i>Mua Ngay
                            </button>
                        </div>
                    </div>
                </form>

            </c:forEach>
        </div>



        <div class="col-12 pb-1">
            <nav aria-label="Page navigation">
                <c:forEach begin="1" end="${pageTotal}" var="i">
                <ul class="pagination justify-content-center mb-3">

                    <li class="page-item active"><a class="page-link" href="/TrangChu?index=${i}">${i}</a></li>

                </ul>
                    </c:forEach>
            </nav>
        </div>



    </div>
</div>

    <jsp:include page="Footer.jsp"></jsp:include>
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
        🌸️
    </div>
    <div class="snowflake">
        🌸️
    </div>
    <div class="snowflake">
        🌸️
    </div>
    <div class="snowflake">

    </div>
    <div class="snowflake">
        🌸
    </div>
    <div class="snowflake">
        🌸 ️
    </div>
</div>
</body>

</html>