package com.astratech.prg7_m2_p1_027;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OrganisasiServlet", value = "/OrganisasiServlet")
public class OrganisasiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("daftarOrganisasi.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String organisasiValues[] = request.getParameterValues("daftarOrganisasi");
        StringBuffer myResponse = new StringBuffer();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Organisasi</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Berikut organisasi yang kamu ikuti: </h1>");
        for (int i = 0; i < organisasiValues.length; i++)
        {
            myResponse.append("<br/><li>");
            myResponse.append(organisasiValues[i]);
        }

        myResponse.append("</body>");
        myResponse.append("</html>");
        out.println(myResponse.toString());
    }
}
