package controller;

import entity.DongSP;
import entity.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import responsitory.DongSPResponsitory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@WebServlet(name = "DongSPServlet", value = {
        "/dongsanpham/hienthi",
        "/dongsanpham/detail",
        "/dongsanpham/delete",
        "/dongsanpham/viewadd",
        "/dongsanpham/add",
        "/dongsanpham/update",
        "/dongsanpham/viewupdate",

})
public class DongSPServlet extends HttpServlet {
    DongSPResponsitory dongSPResponsitory = new DongSPResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<DongSP> listDSP = new ArrayList<>();
        String uri = request.getRequestURI();
        if (uri.contains("hienthi")) {
            request.setAttribute("listDSP", dongSPResponsitory.getAllDongSP());
            request.getRequestDispatcher("/viewDSP/DongSanPham.jsp").forward(request, response);
        } else if (uri.contains("delete")) {
            String id = request.getParameter("id");
            DongSP dongSP = dongSPResponsitory.getByID(id);
            dongSPResponsitory.delete(dongSP);
            response.sendRedirect("/dongsanpham/hienthi");
        } else if (uri.contains("viewadd")) {
            request.getRequestDispatcher("/viewDSP/AddDongSanPham.jsp").forward(request, response);
        } else if (uri.contains("viewupdate")) {
            String id = request.getParameter("id");
            DongSP dongSP = dongSPResponsitory.getByID(id);
            request.setAttribute("dongSP", dongSP);
            request.getRequestDispatcher("/viewDSP/UpdateDongSanPham.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        DongSP dongSP = new DongSP();
        if (uri.contains("add")) {
            try {
                BeanUtils.populate(dongSP, request.getParameterMap());
                dongSPResponsitory.add(dongSP);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/dongsanpham/hienthi");
        } else if (uri.contains("update")) {
            try {
                BeanUtils.populate(dongSP, request.getParameterMap());
                dongSPResponsitory.update(dongSP);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/dongsanpham/hienthi");
        }
    }
}
