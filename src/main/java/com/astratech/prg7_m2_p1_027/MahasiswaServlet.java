package com.astratech.prg7_m2_p1_027;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MahasiswaServlet", value = "/MahasiswaServlet")
public class MahasiswaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("daftarMahasiswa.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String nim = request.getParameter("nim");
        String nama = request.getParameter("nama");
        String email = request.getParameter("email");
        String prodi = request.getParameter("prodi");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Mahasiswa Terdaftar</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Selamat Datang Mahasiswa Bernama " + nama + " dengan NIM " + nim + " dari Program Studi " + prodi + "</h3>");
        out.println("</body>");
        out.println("</html>");
    }
}
