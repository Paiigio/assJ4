package controller;

import entity.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import responsitory.CTSanPhamResponsitory;
import responsitory.KhachHangResponsitory;

import java.io.IOException;

@WebFilter({
//        "/chucvu/hienthi","/addSPGH","/ctsanpham/hienthi","/viewGH"

})

public class AuthenFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
CTSanPhamResponsitory ctSanPhamResponsitory = new CTSanPhamResponsitory();
    KhachHangResponsitory khachHangResponsitory = new KhachHangResponsitory();
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletRequest res = (HttpServletRequest) response;
        Cookie ck[] = req.getCookies();
        String error="";
        String value="";

        for (Cookie c: ck) {
//            if(!c.getName().equals("idKH")){
//                request.setAttribute("LIST_CTSP",ctSanPhamResponsitory.getAllCTSP());
//                request.getRequestDispatcher("Login.jsp").forward(request,response);
//            }else {
//                chain.doFilter(request, response);
//            }
            for (Cookie cookie : ck) {
                if (cookie.getName().equals("idKH")) {
                    value = cookie.getValue();
                }
            }
            KhachHang khachHang= khachHangResponsitory.findID(value);
            if(khachHang==null){
                res.getRequestDispatcher("/Login.jsp").forward(request,response);
            }else {
                chain.doFilter(request, response);
           }
        }
    }


}

