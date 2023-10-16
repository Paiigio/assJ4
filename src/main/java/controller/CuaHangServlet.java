package controller;

import entity.ChucVu;
import entity.CuaHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import responsitory.CuaHangResponsitory;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CuaHangServlet", value = {
        "/cuahang/hienthi",
        "/cuahang/detail",
        "/cuahang/delete",
        "/cuahang/viewadd",
        "/cuahang/add",
        "/cuahang/update",
        "/cuahang/viewupdate",


})
public class CuaHangServlet extends HttpServlet {
    CuaHangResponsitory cuaHangResponsitory= new CuaHangResponsitory();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ChucVu> listcv = new ArrayList<>();

        String uri=request.getRequestURI();
        if(uri.contains("hienthi")){
            //day du lieu lentable
            request.setAttribute("listCH",cuaHangResponsitory.getAll());
            request.getRequestDispatcher("/viewCH/CuaHang.jsp").forward(request,response);
        }
//        else if (uri.contains("detail")) {
//            String id = request.getParameter("id");
//            request.setAttribute("chucVu",chucVuResponsitory.getById(id));
//            request.getRequestDispatcher("/view/detail.jsp").forward(request,response);
//
//        }
        else if (uri.contains("delete")) {
            String id = request.getParameter("id");
            System.out.println(id);
            CuaHang cuaHang=cuaHangResponsitory.getbyID(id);
            cuaHangResponsitory.delete(cuaHang);
            response.sendRedirect("/cuahang/hienthi");

        }
        else if (uri.contains("viewadd")) {

            request.getRequestDispatcher("/viewCH/AddCuaHang.jsp").forward(request,response);

        }   else if (uri.contains("viewupdate")) {
            String id = request.getParameter("id");
            CuaHang cuaHang=cuaHangResponsitory.getbyID(id);
            request.setAttribute("cuahang",cuaHang);
            request.getRequestDispatcher("/viewCH/UpdateCuaHang.jsp").forward(request,response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url=request.getRequestURI();

        if(url.contains("add")){
            String ma=request.getParameter("maCH");
            String tenCH=request.getParameter("tenCH");
            String diaChi=request.getParameter("diaChi");
            String thanhPho=request.getParameter("thanhPho");
            String quocGia=request.getParameter("quocGia");
            CuaHang cuaHang=new CuaHang(null,ma,tenCH,diaChi,thanhPho,quocGia);
            cuaHangResponsitory.add(cuaHang);
            response.sendRedirect("/cuahang/hienthi");
        } else if (url.contains("update")) {
            String idCH=request.getParameter("id");
            String maCH=request.getParameter("maCH");
            String tenCH=request.getParameter("tenCH");
            String diaChi=request.getParameter("diaChi");
            String thanhPho=request.getParameter("thanhPho");
            String quocGia=request.getParameter("quocGia");
            CuaHang cuaHang=new CuaHang(idCH,maCH,tenCH,diaChi,thanhPho,quocGia);
            cuaHangResponsitory.update(cuaHang);
            response.sendRedirect("/cuahang/hienthi");

        }
    }
}
