/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.AccountDao;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author eotke
 */
@WebServlet(name = "SignUp", urlPatterns = {"/SignUp"})
public class SignUp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        int check = 0;
        String use = request.getParameter("userName");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        AccountDao dao = new AccountDao();
        if (use == null || pass == null || repass == null || name == null || phone == null) {
            check = 1;
            request.setAttribute("mess", "vui lòng nhập đủ thông tin đăng ký.");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
            
        } else if (use.matches("^[a-zA-Z0-9]*$") == false) {
            check = 1;
            request.setAttribute("messlogin", "Ðăng ký tài khoản không thành công.");
            request.setAttribute("messuser", "Tài khoản không hợp lệ.");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
            
        } else if (pass.matches("^[a-zA-Z0-9]*$") == false||repass.matches("^[a-zA-Z0-9]*$") == false) {
            check = 1;
            request.setAttribute("messlogin", "Ðăng ký tài khoản không thành công.");
            request.setAttribute("messpass", "Mật khẩu không hợp lệ.");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
            
        } else if (phone.matches("^[0-9]*$") == false) {
            check = 1;
            request.setAttribute("messlogin", "Ðăng ký tài khoản không thành công.");
            request.setAttribute("messsdt", "Số điện thoại không hợp lệ.");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else if (!pass.equals(repass)) {
            check = 1;
            request.setAttribute("messlogin", "Ðăng ký tài khoản không thành công.");
            request.setAttribute("messrepass", "Mật khẩu không hợp lệ.");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        if(check == 0){
            Account a = dao.Checklogin(use);
        if (a != null) {
            request.setAttribute("messlogin", "Ðăng ký tài khoản không thành công.");
            request.setAttribute("mess", "Tài khoản đã tồn tại.");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            dao.SignUp(use, pass, name, phone);
            request.setAttribute("messlogin", "Đăng ký tài khoản thành công.");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        }
        

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
