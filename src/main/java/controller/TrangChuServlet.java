package controller;

import entity.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import responsitory.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;


@WebServlet(name = "TrangChuServlet", value = {
        "/TrangChu",
        "/search",
        "/login",
        "/support",
        "/logout",
        "/giohang",
        "/detail",
        "/mauSP",
        "/nsxSP",
        "/giaSP",
        "/danhmucSP",
        "/addSPGH",
        "/viewGH",
        "/updateViewGioHang",
        "/deleteViewGioHang",
        "/thanhToanViewGioHang",
        "/viewHoaDon",
        "/locHoaDon",
        "/viewHDCT",
        "/Trangchu/pages",

})

public class TrangChuServlet extends HttpServlet {

    CTSanPhamResponsitory ctSanPhamResponsitory = new CTSanPhamResponsitory();
    SanPhamResponsitory sanPhamResponsitory = new SanPhamResponsitory();
    KhachHangResponsitory khachHangResponsitory = new KhachHangResponsitory();
    GioHangRespon gioHangRespon = new GioHangRespon();
    GioHangChiTietRespon ghctr = new GioHangChiTietRespon();
    HoaDonResponsitory hoaDonResponsitory = new HoaDonResponsitory();
    HoaDonChiTietResponsitory hoaDonChiTietResponsitory = new HoaDonChiTietResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String uri = request.getRequestURI();

        if (uri.contains("TrangChu")) {
            ArrayList<CTSanPham> list = ctSanPhamResponsitory.getAllCTSP();
            request.setAttribute("listTrangChu", list);
            slGHTrangchu(request, response);
            cookieeeee(request);
            request.getRequestDispatcher("TrangChu.jsp").forward(request, response);
//
//            int pageNumber;
//            int pageSize = 6;
//            int sl = list.size();
//            System.out.println(sl);
//            int pageTotal = sl / 6;
//            if(sl % 6 != 0) {
//                pageTotal = (sl / 6) + 1;
//            }
//            String index = request.getParameter("index");
//            if(index == null) {
//                index = "1";
//            }
//            pageNumber = Integer.parseInt(index);
//            request.setAttribute("listTrangChu",ctSanPhamResponsitory.pagingCTSP(pageNumber,pageSize));
//            request.setAttribute("pageTotal", pageTotal);
//            slGHTrangchu(request, response);
//            cookieeeee(request);
//            request.getRequestDispatcher("TrangChu.jsp").forward(request, response);
        } else if (uri.contains("search")) {
            request.setCharacterEncoding("UTF-8");
            String txtSearch = request.getParameter("tim");
            request.setAttribute("listTrangChu", ctSanPhamResponsitory.getByName(txtSearch));
            request.setAttribute("loadTK", txtSearch);
            cookieeeee(request);
            slGHTrangchu(request, response);
            request.getRequestDispatcher("TrangChu.jsp").forward(request, response);
        } else if (uri.contains("login")) {
            slGHTrangchu(request, response);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else if (uri.contains("support")) {
            cookieeeee(request);
            slGHTrangchu(request, response);
            request.getRequestDispatcher("Support.jsp").forward(request, response);
        } else if (uri.contains("logout")) {
            response.setContentType("text/html");
            Cookie ck = new Cookie("Username", "");
            Cookie ck1 = new Cookie("Ten", "");
            Cookie ck2 = new Cookie("idKH", "");
            ck.setMaxAge(0);
            ck1.setMaxAge(0);
            ck2.setMaxAge(0);
            response.addCookie(ck);
            response.addCookie(ck1);
            response.addCookie(ck2);
            request.setAttribute("setLogin", "Login");
            ArrayList<CTSanPham> list = ctSanPhamResponsitory.getAllCTSP();
            request.setAttribute("listTrangChu", list);
            request.getRequestDispatcher("TrangChu.jsp").include(request, response);
        } else if (uri.contains("detail")) {
            String id = request.getParameter("id");
            request.setAttribute("detail", ctSanPhamResponsitory.getByID(id));
            ArrayList<CTSanPham> list = ctSanPhamResponsitory.getAllCTSP();
            cookieeeee(request);
            slGHTrangchu(request, response);
            request.setAttribute("listTrangChu", list);
            request.getRequestDispatcher("Detail.jsp").forward(request, response);
        } else if (uri.contains("mauSP")) {
            String tenMS = request.getParameter("ms");
            request.setAttribute("listTrangChu", ctSanPhamResponsitory.getByMau(tenMS));
            cookieeeee(request);
            slGHTrangchu(request, response);
            request.getRequestDispatcher("TrangChu.jsp").forward(request, response);
        } else if (uri.contains("nsxSP")) {
            String nsx = request.getParameter("nsx");
            request.setAttribute("listTrangChu", ctSanPhamResponsitory.getByNSX(nsx));
            cookieeeee(request);
            slGHTrangchu(request, response);
            request.getRequestDispatcher("TrangChu.jsp").forward(request, response);
        } else if (uri.contains("giaSP")) {
            String bd = request.getParameter("start");
            String kt = request.getParameter("end");
            request.setAttribute("listTrangChu", ctSanPhamResponsitory.getByPrice(bd, kt));
            cookieeeee(request);
            slGHTrangchu(request, response);
            request.getRequestDispatcher("TrangChu.jsp").forward(request, response);
        } else if (uri.contains("danhmucSP")) {
//            request.setAttribute("listDM",ctSanPhamResponsitory.getAllCTSP());
//            request.setAttribute("listTrangChu", ctSanPhamResponsitory.getAllCTSP());
//            cookieeeee(request);
//            request.getRequestDispatcher("TrangChu.jsp").forward(request, response);
        } else if (uri.contains("viewGH")) {
            String value = "";
            Cookie ck[] = request.getCookies();
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("idKH")) {
                        value = cookie.getValue();
                    }
                }
            }

            if(value.isEmpty()){
               request.getRequestDispatcher("Login.jsp").forward(request,response);
            }else {
                cookieeeee(request);
                slGHTrangchu(request, response);
                request.getRequestDispatcher("gioHang.jsp").forward(request, response);
            }

        } else if (uri.contains("deleteViewGioHang")) {
            String idgh = request.getParameter("idgh");
            String idctsp = request.getParameter("idctsp");
            GioHangChiTiet gioHangChiTiet = ghctr.capNhatSLSPtrung(idgh, idctsp);
            ghctr.delete(gioHangChiTiet);
            slGHTrangchu(request, response);
            cookieeeee(request);
            request.getRequestDispatcher("gioHang.jsp").forward(request, response);
        } else if (uri.contains("viewHoaDon")) {
            String value = "";
            Cookie ck[] = request.getCookies();
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("idKH")) {
                        value = cookie.getValue();
                    }
                }
            }
            request.setAttribute("listHDbyKH",hoaDonResponsitory.getHDbyKhachHang(value));
            slGHTrangchu(request, response);
            cookieeeee(request);
            request.getRequestDispatcher("HoaDon.jsp").forward(request, response);

        } else if (uri.contains("viewHDCT")) {
            String id = request.getParameter("idhd");
            ArrayList<HoaDonChiTiet> listHDCT = hoaDonChiTietResponsitory.getHDCTbyID(id);
            request.setAttribute("listHDCT", listHDCT);
            slGHTrangchu(request, response);
            cookieeeee(request);
            request.getRequestDispatcher("HDCT.jsp").forward(request, response);
        } else if (uri.contains("locHoaDon")) {
            String value = "";
            Cookie ck[] = request.getCookies();
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("idKH")) {
                        value = cookie.getValue();
                    }
                }
            }
            String ngayBD=request.getParameter( "ngayBD");
            String ngaykt=request.getParameter( "ngayKT");

            if(ngayBD.isEmpty()){
                ngayBD="1997-08-25";
            } else if(ngaykt.isEmpty()){
                ngaykt="2044-08-25";
            }
            System.out.println(ngaykt);
            request.setAttribute("listHDbyKH",hoaDonResponsitory.getHDbyKhachHangByTime(value,ngayBD,ngaykt));
            slGHTrangchu(request, response);
            cookieeeee(request);
            request.getRequestDispatcher("HoaDon.jsp").forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        response.setContentType("text/html;charset=UTF-8");
        if (uri.contains("login")) {
            String usernam = request.getParameter("user");
            String passw = request.getParameter("pass");
            KhachHangResponsitory khachHangResponsitory = new KhachHangResponsitory();
            KhachHang kh = khachHangResponsitory.login(usernam, passw);
            kh.getTen();
            if (usernam.equalsIgnoreCase(kh.getMa()) && passw.equals(kh.getMatKhau())) {
                request.setAttribute("tenTK", "Xin chào" + ":  " + catMa(kh.getTen()));
                request.setAttribute("logOut", "Đăng xuất");
                Cookie idKH = new Cookie("idKH", kh.getId());
                Cookie ten = new Cookie("Ten", catMa(kh.getTen()));
                idKH.setMaxAge(10 * 60 * 60);
                ten.setMaxAge(10 * 60 * 60);
                response.addCookie(ten);

                response.addCookie(idKH);
                slGHTrangchu(request, response);

                ArrayList<CTSanPham> list = ctSanPhamResponsitory.getAllCTSP();
                request.setAttribute("listTrangChu", list);
                request.getRequestDispatcher("TrangChu.jsp").include(request, response);
            } else {
                String mk = "Nhập sai mật khẩu hoặc user";
                request.setAttribute("errTK", mk);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } else if (uri.contains("addSPGH")) {
            String value = "";
            Cookie ck[] = request.getCookies();
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("idKH")) {
                        value = cookie.getValue();
                    }
                }
            }
            if(value.isEmpty()){
                request.getRequestDispatcher("Login.jsp").forward(request,response);
            }else {
                GioHang gioHang = new GioHang();
                GioHang gh = gioHangRespon.getGHbyID(value);
                int sl = Integer.parseInt(request.getParameter("soLuong"));
                if (gh == null) {
                    gioHang.setKhachHang(khachHangResponsitory.findID(value));
                    gioHang.setMa("GH" + (gioHangRespon.getALlGH().size() + 1));
                    gioHang.setNgayTao(new Date());
                    gioHang.setTinhTrang(0);
                    gioHangRespon.add(gioHang);
                    cookieeeee(request);
                    request.setAttribute("listTrangChu", ctSanPhamResponsitory.getAllCTSP());
                    request.getRequestDispatcher("TrangChu.jsp").include(request, response);
                } else {
                    String idSp = request.getParameter("idSP");
                    String idgh = gh.getId();
                    if (!locGH(idgh, idSp)) {
                        CTSanPham ct = ctSanPhamResponsitory.getByID(idSp);
                        double gia = sl * ct.getGiaBan().doubleValue();
                        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
                        gioHangChiTiet.setGioHang(gh);
                        gioHangChiTiet.setChiTietSP(ct);
                        gioHangChiTiet.setSoLuong(sl);
                        gioHangChiTiet.setDonGia(BigDecimal.valueOf(gia));
                        ghctr.add(gioHangChiTiet);

                    } else {
                        CTSanPham ct = ctSanPhamResponsitory.getByID(idSp);
                        GioHangChiTiet gioHangChiTiet = ghctr.capNhatSLSPtrung(idgh, idSp);
                        int slgh = gioHangChiTiet.getSoLuong();
                        double giaSau = slgh * ct.getGiaBan().doubleValue();
                        ghctr.update(sl, giaSau, idgh, idSp);
                    }
                    cookieeeee(request);
                    slGHTrangchu(request, response);
                    request.setAttribute("listTrangChu", ctSanPhamResponsitory.getAllCTSP());
                    request.getRequestDispatcher("TrangChu.jsp").include(request, response);
                }

            }
        } else if (uri.contains("updateViewGioHang")) {
            String idSp = request.getParameter("idSP");
            int sl = Integer.parseInt(request.getParameter("soLuong"));
            if (sl > 0) {
                CTSanPham ct = ctSanPhamResponsitory.getByID(idSp);
                String idgh = request.getParameter("idGH");
                GioHangChiTiet gioHangChiTiet = ghctr.capNhatSLSPtrung(idgh, idSp);
                double giaSau = sl * ct.getGiaBan().doubleValue();
                gioHangChiTiet.setSoLuong(sl);
                gioHangChiTiet.setDonGia(BigDecimal.valueOf(giaSau));
                ghctr.updateGH(gioHangChiTiet);
                cookieeeee(request);
                request.setAttribute("listGH", ghctr.getGHCTbyID(idgh));
                slGHTrangchu(request, response);
                request.getRequestDispatcher("gioHang.jsp").forward(request, response);
            } else {
                CTSanPham ct = ctSanPhamResponsitory.getByID(idSp);
                String idgh = request.getParameter("idGH");
                GioHangChiTiet gioHangChiTiet = ghctr.capNhatSLSPtrung(idgh, idSp);
                double giaSau = sl * ct.getGiaBan().doubleValue();
                gioHangChiTiet.setSoLuong(sl);
                gioHangChiTiet.setDonGia(BigDecimal.valueOf(giaSau));
                ghctr.delete(gioHangChiTiet);
                cookieeeee(request);
                request.setAttribute("listGH", ghctr.getGHCTbyID(idgh));
                slGHTrangchu(request, response);
                request.getRequestDispatcher("gioHang.jsp").forward(request, response);
            }
        } else if (uri.contains("thanhToanViewGioHang")) {
            String ten = request.getParameter("tenNguoiNhan");
            String diachi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String value = "";
            Cookie ck[] = request.getCookies();
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("idKH")) {
                        value = cookie.getValue();
                    }
                }
            }
            if (gioHangRespon.getGHbyID(value) != null) {
                GioHang gioHang = gioHangRespon.getGHbyID(value);
                HoaDon hoaDon = new HoaDon();
                String idgh = gioHang.getId();
                // lấy ra arrrlisst ghct từ id gh, duyet mang ,tao ra 1 hoa don chi tiet moi
                hoaDon.setMa("HD" + (hoaDonResponsitory.getALlHD().size() + 1));
                KhachHang khachHang = khachHangResponsitory.findID(value);
                hoaDon.setKhachHang(khachHang);
                hoaDon.setNgayTao(new Date());
                hoaDon.setNgayThanhToan(new Date());
                hoaDon.setTinhTrang(1);
                hoaDon.setTenNguoiNhan(ten);
                hoaDon.setDiaChi(diachi);
                hoaDon.setSdt(sdt);
                hoaDonResponsitory.add(hoaDon);
                String idHD = hoaDon.getId();
                ArrayList<GioHangChiTiet> listGHCT = ghctr.getGHCTbyID(idgh);
                for (GioHangChiTiet x : listGHCT) {
                    HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                    HoaDon hd = hoaDonResponsitory.getbyID(idHD);
                    System.out.println(hd.toString());
                    hoaDonChiTiet.setHoaDon(hd);
                    hoaDonChiTiet.setChiTietSP(x.getChiTietSP());
                    hoaDonChiTiet.setSoLuong(x.getSoLuong());
                    hoaDonChiTiet.setDonGia(x.getDonGia());
                    hoaDonChiTietResponsitory.add(hoaDonChiTiet);
                }
                Date date = new Date();
                gioHang.setNgayThanhToan(date);
                gioHang.setSdt(sdt);
                gioHang.setDiaChi(diachi);
                gioHang.setTenNguoiNhan(ten);
                gioHang.setTinhTrang(1);
                gioHangRespon.Update(gioHang);
                cookieeeee(request);
                slGHTrangchu(request, response);
                request.setAttribute("listTrangChu", ctSanPhamResponsitory.getAllCTSP());
                request.getRequestDispatcher("TrangChu.jsp").include(request, response);
            }
        }
    }

    private String catMa(String ma) {
        int index = ma.indexOf(" ");
        if (index < 0) {
            String chuSo = ma.substring(0);
        }
        String chuSo = ma.substring(index + 1);
        return chuSo;
    }

    public void cookieeeee(HttpServletRequest request) {
        Cookie ck[] = request.getCookies();
        if (ck != null) {
            for (Cookie cookie : ck) {
                if (cookie.getName().equals("Ten")) {
                    String value = cookie.getValue();
                    request.setAttribute("tenTK", "Xin chào" + ":  " + value);
                    request.setAttribute("logOut", "Đăng xuất");
                }
            }
        } else if (ck == null) {
            request.setAttribute("setLogin", "Login");
        }
    }

    public boolean locGH(String id, String ids) {
        ArrayList<GioHangChiTiet> list = ghctr.getGHCTbyID(id);
        for (GioHangChiTiet x : list) {
            if (x.getChiTietSP().getId().equalsIgnoreCase(ids)) {
                return true;
            }
        }
        return false;
    }

    public void slGHTrangchu(HttpServletRequest request, HttpServletResponse response) {
        String value = "";
        Cookie ck[] = request.getCookies();
        if (ck != null) {
            for (Cookie cookie : ck) {
                if (cookie.getName().equals("idKH")) {
                    value = cookie.getValue();
                }
            }
        }
        GioHang gh = gioHangRespon.getGHbyID(value);
        if (gh != null) {
            String idgh = gh.getId();
            double tong = 0;
            ArrayList<GioHangChiTiet> list = ghctr.getGHCTbyID(idgh);
            for (GioHangChiTiet x : list) {
                tong += x.getDonGia().doubleValue();
            }
            request.setAttribute("tongtien", tong);
            request.setAttribute("listGH", ghctr.getGHCTbyID(idgh));
            request.setAttribute("size", ghctr.getGHCTbyID(idgh).size());
        }

    }
}
