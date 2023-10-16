package controller;

import entity.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import responsitory.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "CTSanPhamServlet", value = {
        "/ctsanpham/hienthi",
        "/ctsanpham/detail",
        "/ctsanpham/delete",
        "/ctsanpham/viewadd",
        "/ctsanpham/add",
        "/ctsanpham/update",
        "/ctsanpham/viewupdate",


})
@MultipartConfig
public class CTSanPhamServlet extends HttpServlet {
    CTSanPhamResponsitory ctSanPhamResponsitory = new CTSanPhamResponsitory();
    SanPhamResponsitory sanPhamResponsitory = new SanPhamResponsitory();
    NSXResponsitory nsxResponsitory = new NSXResponsitory();
    MauSacResponsitory mauSacResponsitory = new MauSacResponsitory();
    DongSPResponsitory dongSPResponsitory = new DongSPResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hienthi")) {
            request.setAttribute("listCTSP", ctSanPhamResponsitory.getAllCTSP());
            request.getRequestDispatcher("/viewCTSP/CTSanPham.jsp").forward(request, response);
        } else if (uri.contains("add")) {
            request.setAttribute("listSP", sanPhamResponsitory.getALlSP());
            request.setAttribute("listNSX", nsxResponsitory.getAllNSX());
            request.setAttribute("listMS", mauSacResponsitory.getAllMS());
            request.setAttribute("listDongSP", dongSPResponsitory.getAllDongSP());
            request.getRequestDispatcher("/viewCTSP/AddCTSanPham.jsp").forward(request, response);
        } else if (uri.contains("delete")) {
            String id=request.getParameter("id");
            CTSanPham ctSanPham= ctSanPhamResponsitory.getByID(id);
            ctSanPhamResponsitory.delete(ctSanPham);
            response.sendRedirect("/ctsanpham/hienthi");
        } else if (uri.contains("viewupdate")) {
            String id =request.getParameter("id");
            CTSanPham ctSanPham = ctSanPhamResponsitory.getByID(id);
            request.setAttribute("listSP", sanPhamResponsitory.getALlSP());
            request.setAttribute("listNSX", nsxResponsitory.getAllNSX());
            request.setAttribute("listMS", mauSacResponsitory.getAllMS());
            request.setAttribute("listDongSP", dongSPResponsitory.getAllDongSP());
            request.setAttribute("listUD",ctSanPham);
            request.getRequestDispatcher("/viewCTSP/UpdateCTSanPham.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri= request.getRequestURI();
        String idSP= request.getParameter("sanPham.id");
        String idNSX= request.getParameter("nsx.id");
        String idMS= request.getParameter("mauSac.id");
        String idDSP= request.getParameter("dongSP.id");
        if(uri.contains("add")){
            try {
                CTSanPham ctSanPham = new CTSanPham();
                SanPham sanPham = new SanPham();
                NSX nsx= new NSX();
                MauSac mauSac = new MauSac();
                DongSP dongSP = new DongSP();
                sanPham.setId(idSP);
                nsx.setId(idNSX);
                mauSac.setId(idMS);
                dongSP.setId(idDSP);
                BeanUtils.populate(ctSanPham,request.getParameterMap());
                ctSanPham.setSanPham(sanPham);
                ctSanPham.setNsx(nsx);
                ctSanPham.setMauSac(mauSac);
                ctSanPham.setDongSP(dongSP);
                ctSanPhamResponsitory.add(ctSanPham);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/ctsanpham/hienthi");
        } else if (uri.contains("update")) {
            try {
                CTSanPham ctSanPham = new CTSanPham();
                SanPham sanPham = new SanPham();
                NSX nsx= new NSX();
                MauSac mauSac = new MauSac();
                DongSP dongSP = new DongSP();
                sanPham.setId(idSP);
                nsx.setId(idNSX);
                mauSac.setId(idMS);
                dongSP.setId(idDSP);
                BeanUtils.populate(ctSanPham,request.getParameterMap());
                ctSanPham.setSanPham(sanPham);
                ctSanPham.setNsx(nsx);
                ctSanPham.setMauSac(mauSac);
                ctSanPham.setDongSP(dongSP);
                ctSanPhamResponsitory.update(ctSanPham);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/ctsanpham/hienthi");
        }
    }
}
