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
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author eotke
 */
@WebServlet(name = "SettingAccount", urlPatterns = {"/SettingAccount"})
public class SettingAccount extends HttpServlet {

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
        String aid = request.getParameter("id");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        AccountDao dao = new AccountDao();
        HttpSession session = request.getSession();
        String Accid = (String) session.getAttribute("AccountID");
        if (phone.matches("^[0-9]*$") == false) {
            request.setAttribute("messAcc", "Số điện thoại không hợp lệ.");
            Account a = dao.getAccountbyID(Accid);
            request.setAttribute("settingAcc", a);
            request.getRequestDispatcher("SettingAccount.jsp").forward(request, response);
        } else if (pass.matches("^[a-zA-Z0-9]*$") == false) {
            request.setAttribute("messAcc", "Mật khẩu không hợp lệ.");
            Account a = dao.getAccountbyID(Accid);
            request.setAttribute("settingAcc", a);
            request.getRequestDispatcher("SettingAccount.jsp").forward(request, response);
        } else {
            dao.settingAccount(user, pass, name, phone, address, aid);
            Account a = dao.getAccountbyID(Accid);
            request.setAttribute("settingAcc", a);
            request.getRequestDispatcher("SettingAccount.jsp").forward(request, response);

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
