package com.example.buoi1.servlet;

import com.example.buoi1.model.Size;
import com.example.buoi1.repository.SizeRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SizeServlet", value = "/size/hien-thi")
public class SizeServlet extends HttpServlet {

    private SizeRepository sizeRepository = new SizeRepository();
    ArrayList<Size> listSize = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/size/hien-thi")){
            this.loadWeb(request,response);
        }
    }

    private void loadWeb(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSize = sizeRepository.getList();
        request.setAttribute("size", listSize);
        request.getRequestDispatcher("/size/trang-chu.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
