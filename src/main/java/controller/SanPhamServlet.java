package controller;

import entity.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import responsitory.SanPhamResponsitory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@WebServlet(name = "SanPhamServlet", value ={
        "/sanpham/hienthi",
        "/sanpham/detail",
        "/sanpham/delete",
        "/sanpham/viewadd",
        "/sanpham/add",
        "/sanpham/update",
        "/sanpham/viewupdate",

})
public class SanPhamServlet extends HttpServlet {
    SanPhamResponsitory sanPhamResponsitory= new SanPhamResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<SanPham> listSP = new ArrayList<>();
        String uri = request.getRequestURI();
        if (uri.contains("hienthi")) {
            request.setAttribute("listSP", sanPhamResponsitory.getALlSP());
            request.getRequestDispatcher("/viewSP/SanPham.jsp").forward(request, response);
        } else if (uri.contains("delete")) {
            String id = request.getParameter("id");
            SanPham sanPham = sanPhamResponsitory.getByID(id);
            sanPhamResponsitory.delete(sanPham);
            response.sendRedirect("/sanpham/hienthi");
        } else if (uri.contains("viewadd")) {
            request.getRequestDispatcher("/viewSP/AddSanPham.jsp").forward(request, response);
        } else if (uri.contains("viewupdate")) {
            String id = request.getParameter("id");
            SanPham sanPham=sanPhamResponsitory.getByID(id);
            request.setAttribute("sanpham",sanPham);
            request.getRequestDispatcher("/viewSP/UpdateSanPham.jsp").forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        SanPham sanPham = new SanPham();
        if(uri.contains("add")){
            try {
                BeanUtils.populate(sanPham,request.getParameterMap());
                sanPhamResponsitory.add(sanPham);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/sanpham/hienthi");
        } else if (uri.contains("update")) {
            try {
                BeanUtils.populate(sanPham,request.getParameterMap());
                sanPhamResponsitory.update(sanPham);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/sanpham/hienthi");
        }
    }

}
