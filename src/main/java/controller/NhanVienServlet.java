package controller;

import entity.ChucVu;
import entity.CuaHang;
import entity.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import responsitory.ChucVuResponsitory;
import responsitory.CuaHangResponsitory;
import responsitory.NhanVienResponsitory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhanvien/hienthi",
        "/nhanvien/detail",
        "/nhanvien/delete",
        "/nhanvien/viewadd",
        "/nhanvien/add",
        "/nhanvien/update",
        "/nhanvien/viewupdate",


})
public class NhanVienServlet extends HttpServlet {
    NhanVienResponsitory nhanVienResponsitory = new NhanVienResponsitory();
    CuaHangResponsitory cuaHangResponsitory = new CuaHangResponsitory();
    ChucVuResponsitory chucVuResponsitory = new ChucVuResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hienthi")) {
            request.setAttribute("listNV", nhanVienResponsitory.getALlNV());
            request.getRequestDispatcher("/viewNV/NhanVien.jsp").forward(request, response);
        } else if (uri.contains("viewadd")) {
            request.setAttribute("listCH", cuaHangResponsitory.getAll());
            request.setAttribute("listCV", chucVuResponsitory.getAll());
            request.getRequestDispatcher("/viewNV/AddNhanVien.jsp").forward(request, response);
        } else if (uri.contains("delete")) {
            String id = request.getParameter("id");
            NhanVien nhanVien = nhanVienResponsitory.getByID(id);
            nhanVienResponsitory.delete(nhanVien);
            response.sendRedirect("/nhanvien/hienthi");
        } else if (uri.contains("viewupdate")) {
            String id = request.getParameter("id");
            NhanVien nhanVien = nhanVienResponsitory.getByID(id);
            request.setAttribute("listCH", cuaHangResponsitory.getAll());
            request.setAttribute("listCV", chucVuResponsitory.getAll());
            request.setAttribute("listNVUD",nhanVien);
            request.getRequestDispatcher("/viewNV/UpdateNhanVien.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String idcv=request.getParameter("chucVu.id");
        String idch=request.getParameter("cuaHang.id");
        if (uri.contains("add")) {

            try {
                NhanVien nhanVien =new NhanVien();
                CuaHang cuaHang = new CuaHang();
                ChucVu chucVu = new ChucVu();
                cuaHang.setId(idch);
                chucVu.setId(idcv);
                BeanUtils.populate(nhanVien,request.getParameterMap());
                nhanVien.setCuaHang(cuaHang);
                nhanVien.setChucVu(chucVu);
                nhanVienResponsitory.add(nhanVien);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/nhanvien/hienthi");

        } else if (uri.contains("update")) {

            try {
                NhanVien nhanVien = new NhanVien();
                CuaHang cuaHang = new CuaHang();
                ChucVu chucVu = new ChucVu();
                cuaHang.setId(idch);
                chucVu.setId(idcv);
                BeanUtils.populate(nhanVien,request.getParameterMap());
                nhanVien.setCuaHang(cuaHang);
                nhanVien.setChucVu(chucVu);
                nhanVienResponsitory.update(nhanVien);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/nhanvien/hienthi");
        }
    }
}
