package com.example.buoi1.servlet;

import com.example.buoi1.model.MauSac;
import com.example.buoi1.repository.MauSacRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MauSacServlet", value = "/mau-sac/hien-thi")
public class MauSacServlet extends HttpServlet {

    private MauSacRepository mauSacRepository = new MauSacRepository();
    ArrayList<MauSac> listMauSac = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/mau-sac/hien-thi")){
            this.hienThi(request,response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listMauSac = mauSacRepository.getList();
        request.setAttribute("mauSac", listMauSac);
        request.getRequestDispatcher("/mau-sac/trang-chu.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
