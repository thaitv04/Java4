package com.example.buoi1.servlet;

import com.example.buoi1.model.DanhMuc;
import com.example.buoi1.model.SanPham;
import com.example.buoi1.repository.DanhMucRepository;
import com.example.buoi1.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = {"/san-pham/hien-thi", "/san-pham/add", "/san-pham/detail", "/san-pham/delete"})
public class SanPhamServlet extends HttpServlet {

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();
    private DanhMucRepository danhMucRepository = new DanhMucRepository();
    ArrayList<SanPham> listSP = new ArrayList<>();
    ArrayList<DanhMuc> listDanhMuc = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/san-pham/hien-thi")){
        this.hienThi(request,response);
    } else if (uri.equals("/san-pham/delete")) {
            this.delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("maSP"));
        // Lấy thông tin của sản phẩm theo ID
        SanPham sanPham = sanPhamRepository.getDetail(id);
        sanPhamRepository.delete(sanPham);
        response.sendRedirect("/san-pham/hien-thi");
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSP = sanPhamRepository.getList();
        listDanhMuc = danhMucRepository.getList();
        request.setAttribute("sanPham", listSP);
        request.setAttribute("danhMuc", listDanhMuc);
        request.getRequestDispatcher("/san-pham/trang-chu.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/san-pham/add")) {
            this.add(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String danhMuc = request.getParameter("danhMuc");
        String trangThai = request.getParameter("trangThai");
        SanPham sanPham = new SanPham();
        sanPham.setMaSP(ma);
        sanPham.setTen(ten);
        sanPham.setNgayTao(new Date());
        sanPham.setNgaySua(new Date());
        sanPham.setTrangThai(trangThai);
        DanhMuc danhMuc1 = new DanhMuc();
        danhMuc1.setId(Integer.parseInt(danhMuc));
        sanPham.setDanhMuc(danhMuc1);

        sanPhamRepository.add(sanPham);
        response.sendRedirect("/san-pham/hien-thi");
    }
}
