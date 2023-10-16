package controller;

import entity.ChucVu;
import entity.CuaHang;
import entity.MauSac;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import responsitory.MauSacResponsitory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@WebServlet(name = "MauSacServlet", value = {
        "/mausac/hienthi",
        "/mausac/detail",
        "/mausac/delete",
        "/mausac/viewadd",
        "/mausac/add",
        "/mausac/update",
        "/mausac/viewupdate",

})
public class MauSacServlet extends HttpServlet {
    MauSacResponsitory mauSacResponsitory = new MauSacResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<MauSac> listMS = new ArrayList<>();
        String uri = request.getRequestURI();
        if (uri.contains("hienthi")) {
            request.setAttribute("listMS", mauSacResponsitory.getAllMS());
            request.getRequestDispatcher("/viewMS/MauSac.jsp").forward(request, response);
        } else if (uri.contains("delete")) {
            String id = request.getParameter("id");
            System.out.println(id);
            MauSac mauSac = mauSacResponsitory.getByID(id);
            mauSacResponsitory.delete(mauSac);
            response.sendRedirect("/mausac/hienthi");
        } else if (uri.contains("viewadd")) {
            request.getRequestDispatcher("/viewMS/AddMauSac.jsp").forward(request, response);
        } else if (uri.contains("viewupdate")) {
            String id = request.getParameter("id");

            MauSac mauSac=mauSacResponsitory.getByID(id);
            request.setAttribute("mauSac",mauSac);
            request.getRequestDispatcher("/viewMS/UpdateMauSac.jsp").forward(request,response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        MauSac mauSac = new MauSac();
        if(uri.contains("add")){
            try {
                BeanUtils.populate(mauSac,request.getParameterMap());
                mauSacResponsitory.add(mauSac);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/mausac/hienthi");
        } else if (uri.contains("update")) {
            try {
                BeanUtils.populate(mauSac,request.getParameterMap());
                mauSacResponsitory.update(mauSac);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/mausac/hienthi");
        }
    }
}
