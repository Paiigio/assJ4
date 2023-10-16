package controller;

import entity.ChucVu;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import responsitory.ChucVuResponsitory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


@WebServlet(name = "ChucVuServlet", value = {
        "/chucvu/hienthi",
        "/chucvu/detail",
        "/chucvu/delete",
        "/chucvu/viewadd",
        "/chucvu/add",
        "/chucvu/update",
        "/chucvu/viewupdate",


})

public class ChucVuServlet extends HttpServlet {
    ChucVuResponsitory chucVuResponsitory = new ChucVuResponsitory();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ChucVu> listcv = new ArrayList<>();

        String uri=request.getRequestURI();
        if(uri.contains("hienthi")){

            request.setAttribute("listCV",chucVuResponsitory.getAll());
            request.getRequestDispatcher("/viewCV/ChucVu.jsp").forward(request,response);
        }
//        else if (uri.contains("detail")) {
//            String id = request.getParameter("id");
//            request.setAttribute("chucVu",chucVuResponsitory.getById(id));
//            request.getRequestDispatcher("/view/detail.jsp").forward(request,response);
//
//        }
        else if (uri.contains("delete")) {
            String id = request.getParameter("id");
            ChucVu chucVu=chucVuResponsitory.getById(id);
            chucVuResponsitory.delete(chucVu);
            response.sendRedirect("/chucvu/hienthi");

        }
        else if (uri.contains("viewadd")) {

            request.getRequestDispatcher("/viewCV/AddChucVu.jsp").forward(request,response);

        }   else if (uri.contains("viewupdate")) {
            String id = request.getParameter("id");
            ChucVu chucVu=chucVuResponsitory.getById(id);
            request.setAttribute("chucvu",chucVu);
            request.getRequestDispatcher("/viewCV/UpdateChucVu.jsp").forward(request,response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url=request.getRequestURI();

        if(url.contains("add")){
//            String tenCV=request.getParameter("tenCV");
//            String maCV=request.getParameter("maCV");
//            ChucVu chucVu=new ChucVu(null,maCV,tenCV);
//            chucVuResponsitory.add(chucVu);

            ChucVu chucVu1= new ChucVu();
            try {
                BeanUtils.populate(chucVu1,request.getParameterMap());
                chucVuResponsitory.add(chucVu1);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/chucvu/hienthi");
        } else if (url.contains("update")) {
//            String idCV=request.getParameter("id");
//            String tenCV=request.getParameter("tenCV");
//            String maCV=request.getParameter("maCV");
//            ChucVu chucVu=new ChucVu(idCV,maCV,tenCV);
//            chucVuResponsitory.update(chucVu);
            ChucVu chucVu1= new ChucVu();
            try {
                BeanUtils.populate(chucVu1,request.getParameterMap());
                chucVuResponsitory.update(chucVu1);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/chucvu/hienthi");
        }
    }

}
