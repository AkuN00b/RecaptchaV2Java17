package com.astratech.prg7_m2_p1_027;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private static final String SECRET = "6LeESgMlAAAAAKzkERVuPBDhuOaqiCIDsEQamKed";
    private static final String KEY = "6LeESgMlAAAAALNRGO2Q8Km9448o86cqJ16SG0Xe";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get reCAPTCHA request param

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        boolean verify = isValidCaptcha(gRecaptchaResponse);

        if (verify) {
            if(username.equals("lando") && password.equals("lando")) {

                // Jika input benar, mengatur session
                HttpSession session = request.getSession();
                session.setAttribute("username", username);

                // Mengarahkan ke halaman selamat datang
                response.sendRedirect("index2.jsp");
            } else if (username.equals("") && password.equals("")) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
                PrintWriter out = response.getWriter();

                out.println("<div style='color: red'>Input the username and password.</div>");
                rd.include(request, response);
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
                PrintWriter out = response.getWriter();

                out.println("<div style='color: red'>Incorrect the username or password.</div>");
                rd.include(request, response);
            }
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            PrintWriter out = response.getWriter();

            out.println("<div style='color: red'>You missed the Captcha.</div>");
            rd.include(request, response);
        }
    }

    private boolean isValidCaptcha(String captchaResponse) {
        if (captchaResponse != null && !captchaResponse.isEmpty()) {
            return true;
        }
        return false;
    }

}
