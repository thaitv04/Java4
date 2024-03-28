package com.example.buoi1.servlet;

import com.example.buoi1.model.DanhMuc;
import com.example.buoi1.repository.DanhMucRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "DanhMucServlet", value = {"/danh-muc/hien-thi", "/danh-muc/add",
                "/danh-muc/delete", "/danh-muc/detail", "/danh-muc/update"})
public class DanhMucServlet extends HttpServlet {

    private DanhMucRepository danhMucRepository = new DanhMucRepository();
    List<DanhMuc> listDanhMuc = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/danh-muc/hien-thi")){
            this.hienThi(request,response);
        } else if (uri.equals("/danh-muc/delete")) {
            this.delete(request,response);
        } else if (uri.contains("/detail")) {
            this.detail(request,response);
        }

    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("maSP");
        DanhMuc danhMucDetail = danhMucRepository.getDetail(ma);
        for (DanhMuc danhMuc : listDanhMuc){
            if (danhMuc.getMa().equals("ma")){
                danhMucDetail = danhMuc;
            }
        }
        request.setAttribute("danhMucDetail", danhMucDetail);
        request.getRequestDispatcher("/danh-muc/chi-tiet.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maSP");
        DanhMuc danhMuc = danhMucRepository.getDetail(ma);
        danhMucRepository.delete(danhMuc);

        response.sendRedirect("/danh-muc/hien-thi");

    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        listDanhMuc = danhMucRepository.getList();
        request.setAttribute("danhMuc", listDanhMuc);
        request.getRequestDispatcher("/danh-muc/trang-chu.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/danh-muc/add")){
            this.add(request, response);
        } else if (uri.contains("/update")){
            this.update(request,response);
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maSP");
        String ten = request.getParameter("ten");
        String trangThai = request.getParameter("trangThai");
        for (DanhMuc danhMuc : listDanhMuc){
            if (danhMuc.getMa().equals(ma)){
                    danhMuc.setTen(ten);
                    danhMuc.setTrangThai(trangThai);
                    danhMuc.setNgayTao(new Date());
                    danhMuc.setNgaySua(new Date());
            }
        }
//        danhMucRepository.update());
        response.sendRedirect("/danh-muc/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String trangThai = request.getParameter("trangThai");
        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setMa(ma);
        danhMuc.setTen(ten);
        danhMuc.setTrangThai(trangThai);
        danhMuc.setNgayTao(new Date());
        danhMuc.setNgaySua(new Date());

        danhMucRepository.add(danhMuc);
        response.sendRedirect("/danh-muc/hien-thi");


    }
}
