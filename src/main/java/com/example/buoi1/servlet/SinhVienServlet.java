package com.example.buoi1.servlet;

import com.example.buoi1.model.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SinhVienServlet", value = {"/trang-chu/sinh-vien",
        "/sinh-vien/add", //POST
         "/sinh-vien/detail",
        "/sinh-vien/update",//POST
        "/sinh-vien/delete"

})
public class SinhVienServlet extends HttpServlet {

    ArrayList<SinhVien> listSinhVien;

    ArrayList<String> listTenLop;
    public SinhVienServlet(){
        listSinhVien = new ArrayList<>();
        listTenLop = new ArrayList<>();
        listTenLop.add("SD121");
        listTenLop.add("SD122");
        listTenLop.add("SD123");
        listTenLop.add("SD124");
        listTenLop.add("SD1256");
        listSinhVien.add(new SinhVien("PH1234", "Tran Van A", "HN", 19, "Nam", "SD123"));
        listSinhVien.add(new SinhVien("PH123", "Nguyen Van A", "BN", 19, "Nu", "SD124"));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/trang-chu/sinh-vien")) {
            request.setAttribute("listSinhVien", listSinhVien);
            request.setAttribute("tenLop", listTenLop);
            request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
        } else if (uri.equals("/sinh-vien/detail")) {
            request.setAttribute("tenLop", listTenLop);
            String maSV = request.getParameter("maSinhVien");
            SinhVien sinhVienDetail = new SinhVien();
            for (SinhVien sinhVien : listSinhVien){
                if(sinhVien.getMaSV().equals(maSV)){
                    sinhVienDetail = sinhVien;
                }
            }
            request.setAttribute("sinhVienDetail", sinhVienDetail);
            request.getRequestDispatcher("/chi-tiet.jsp").forward(request,response);
        } else if (uri.equals("/sinh-vien/delete")) {
            String ma = request.getParameter("maSinhVien");
            for (SinhVien sinhVien : listSinhVien){
                if (sinhVien.getMaSV().equals(ma)){
                    listSinhVien.remove(sinhVien);
                    break;
                }
            }
            response.sendRedirect("/trang-chu/sinh-vien");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String uri = request.getRequestURI();
       if(uri.equals("/sinh-vien/add")) {
           String maSV = request.getParameter("maSV");
           String tenSV = request.getParameter("tenSV");
           String diaChi = request.getParameter("diaChi");
           Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
           String gioiTinh = request.getParameter("gioiTinh");
           String tenLop = request.getParameter("tenLop");
           SinhVien sinhVien = new SinhVien(maSV, tenSV, diaChi, tuoi, tenLop, gioiTinh);
           listSinhVien.add(sinhVien);
           System.out.println(gioiTinh);
           response.sendRedirect("/trang-chu/sinh-vien");
       } else if (uri.equals("/sinh-vien/update")) {
           String maSV = request.getParameter("maSV");
           String tenSV = request.getParameter("tenSV");
           String diaChi = request.getParameter("diaChi");
           Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
           String gioiTinh = request.getParameter("gioiTinh");
           String tenLop = request.getParameter("tenLop");
           for(SinhVien sinhVien : listSinhVien){
               if(sinhVien.getMaSV().equals(maSV)){
                   sinhVien.setTuoi(tuoi);
                   sinhVien.setDiaChi(diaChi);
                   sinhVien.setTenSV(tenSV);
                   sinhVien.setGioiTinh(gioiTinh);
                   sinhVien.setTenLop(tenLop);

               }
           }
           response.sendRedirect("/trang-chu/sinh-vien");
       }

    }
}
