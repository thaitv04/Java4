package com.example.buoi1.servlet;

import com.example.buoi1.model.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NhanVienServlet", value = {"/trang-chu/nhan-vien", "/nhan-vien/add", "/nhan-vien/detail", "/nhan-vien/update",
    "/nhan-vien/delete"})
public class NhanVienServlet extends HttpServlet {

    ArrayList<NhanVien> listNhanVien;
    ArrayList<String> listChucVu;

    public NhanVienServlet(){
        listChucVu.add("Trưởng phòng");
        listChucVu.add("Nhân viên");
        listChucVu.add("Kỹ sư");
        listNhanVien = new ArrayList<>();
        listNhanVien.add(new NhanVien("NV001", "Tran Van Thai", "Trưởng phòng", 19, "Nam"));
        listNhanVien.add(new NhanVien("NV002", "Nguyen Van A", "Nhân viên", 21, "Nam"));
        listNhanVien.add(new NhanVien("NV003", "Dinh Thi C", "Kỹ sư", 10, "Nữ"));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String uri = request.getRequestURI();
            if (uri.equals("/trang-chu/nhan-vien")) {
                request.setAttribute("listNhanVien", listNhanVien);
                request.setAttribute("chucVu", listChucVu);
                request.getRequestDispatcher("/nhan-vien.jsp").forward(request, response);

            } else if (uri.equals("/nhan-vien/detail")) {
                String ma = request.getParameter("idNV");
                NhanVien nhanVienDetail = new NhanVien();
                for (NhanVien nhanVien : listNhanVien){
                    if (nhanVien.getMaNV().equals(ma)){
                        nhanVienDetail = nhanVien;
                    }
                }
                request.setAttribute("nhanVienDetail", nhanVienDetail);
                request.getRequestDispatcher("/detail-nhanvien.jsp").forward(request, response);
            } else if (uri.equals("/nhan-vien/delete")) {
                String ma = request.getParameter("idNV");
                for (NhanVien nhanVien : listNhanVien){
                    if (nhanVien.getMaNV().equals(ma)){
                        listNhanVien.remove(nhanVien);
                        break;
                    }
                }
                response.sendRedirect("/trang-chu");
            }

    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String uri = request.getRequestURI();
            if (uri.equals("/nhan-vien/add")) {
                String maNV = request.getParameter("maNV");
                String tenNV = request.getParameter("tenNV");
                String chucVu = request.getParameter("chucVu");
                Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
                String gioiTinh = request.getParameter("gioiTinh");
                NhanVien nhanVien = new NhanVien(maNV, tenNV, chucVu, tuoi, gioiTinh);
                listNhanVien.add(nhanVien);

                response.sendRedirect("/trang-chu");
            } else if (uri.equals("/nhan-vien/update")) {
                String maNV = request.getParameter("maNV");
                String tenNV = request.getParameter("tenNV");
                String chucVu = request.getParameter("chucVu");
                Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
                String gioiTinh = request.getParameter("gioiTinh");
                for (NhanVien nv : listNhanVien){
                    if (nv.getMaNV().equals(maNV)){
                        nv.setTenNV(tenNV);
                        nv.setChucVu(chucVu);
                        nv.setTuoi(tuoi);
                        nv.setGioiTinh(gioiTinh);
                    }
                }
                response.sendRedirect("/trang-chu");
            }
        }
        }
