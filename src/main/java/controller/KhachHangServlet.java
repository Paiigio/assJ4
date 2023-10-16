package controller;

import entity.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import responsitory.KhachHangResponsitory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "KhachHangServlet", value =  {
        "/khachhang/hienthi",
        "/khachhang/detail",
        "/khachhang/delete",
        "/khachhang/viewadd",
        "/khachhang/add",
        "/khachhang/update",
        "/khachhang/viewupdate",


})
public class KhachHangServlet extends HttpServlet {
    KhachHangResponsitory khachHangResponsitory= new KhachHangResponsitory();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hienthi")){
            request.setAttribute("listKH",khachHangResponsitory.getAllKH());
            request.getRequestDispatcher("/viewKH/KhachHang.jsp").forward(request,response);
        } else if (uri.contains("delete")) {
            String id = request.getParameter("id");
            System.out.println(id);
            KhachHang khachHang = khachHangResponsitory.findID(id) ;
            khachHangResponsitory.delete(khachHang);
            response.sendRedirect("/khachhang/hienthi");
        } else if (uri.contains("viewupdate")) {
            String id = request.getParameter("id");
            KhachHang khachHang = khachHangResponsitory.findID(id);
            request.setAttribute("khachhang",khachHang);
            request.getRequestDispatcher("/viewKH/UpdateKhachHang.jsp").forward(request,response);
        } else if (uri.contains("viewadd")) {
            request.getRequestDispatcher("/viewKH/AddKhachHang.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            KhachHang khachHang= new KhachHang();
            try {
                BeanUtils.populate(khachHang,request.getParameterMap());
                khachHangResponsitory.add(khachHang);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/khachhang/hienthi");

        } else if (uri.contains("update")) {
            KhachHang khachHang= new KhachHang();
            try {
                BeanUtils.populate(khachHang,request.getParameterMap());
                khachHangResponsitory.update(khachHang);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/khachhang/hienthi");
        }
    }
}
