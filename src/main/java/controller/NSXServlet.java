package controller;

import entity.NSX;
import entity.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import responsitory.NSXResponsitory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@WebServlet(name = "NSXServlet", value = {
        "/nsx/hienthi",
        "/nsx/detail",
        "/nsx/delete",
        "/nsx/viewadd",
        "/nsx/add",
        "/nsx/update",
        "/nsx/viewupdate",

})
public class NSXServlet extends HttpServlet {
    NSXResponsitory nsxResponsitory= new NSXResponsitory();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<NSX> listNSX= new ArrayList<>();
        String uri= request.getRequestURI();
        if(uri.contains("hienthi")){
            request.setAttribute("listNSX",nsxResponsitory.getAllNSX());
            request.getRequestDispatcher("/viewNSX/NSX.jsp").forward(request,response);
        } else if (uri.contains("delete")) {
            String id = request.getParameter("id");
            NSX nsx=nsxResponsitory.getbyID(id);
            nsxResponsitory.delete(nsx);
            response.sendRedirect("/nsx/hienthi");
        }else if (uri.contains("viewadd")) {
            request.getRequestDispatcher("/viewNSX/AddNSX.jsp").forward(request, response);
        } else if (uri.contains("viewupdate")) {
            String id = request.getParameter("id");
            NSX nsx=nsxResponsitory.getbyID(id);
            request.setAttribute("nsx",nsx);
            request.getRequestDispatcher("/viewNSX/UpdateNSX.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        NSX nsx= new NSX();
        if(uri.contains("add")){
            try {
                BeanUtils.populate(nsx,request.getParameterMap());
                nsxResponsitory.add(nsx);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/nsx/hienthi");
        } else if (uri.contains("update")) {
            try {
                BeanUtils.populate(nsx,request.getParameterMap());
                nsxResponsitory.update(nsx);

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/nsx/hienthi");
        }
    }
}
