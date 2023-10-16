package controller;

import entity.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import responsitory.KhachHangResponsitory;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user=request.getParameter("user");
        String pass=request.getParameter("pass");
        KhachHangResponsitory khachHangResponsitory = new KhachHangResponsitory();
        KhachHang kh = khachHangResponsitory.login(user,pass);
        System.out.println(kh);
        if(kh==null){
            request.setAttribute("tenTK",kh.getTen());
            request.getRequestDispatcher("LoginServlet").forward(request,response);

        }else {
            request.setAttribute("tenTK",kh.getTen());
            request.getRequestDispatcher("TrangChu").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
