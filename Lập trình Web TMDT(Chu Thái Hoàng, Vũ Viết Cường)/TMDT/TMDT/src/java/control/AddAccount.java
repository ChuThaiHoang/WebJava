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
import java.util.List;

/**
 *
 * @author eotke
 */
@WebServlet(name = "AddAccount", urlPatterns = {"/AddAccount"})
public class AddAccount extends HttpServlet {

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
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("acc");
        AccountDao dao = new AccountDao();
        String use = request.getParameter("user");
        String pass = request.getParameter("pass");
        String isSell = request.getParameter("issell");
        String isAdmin = request.getParameter("isadmin");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String CheckisSell = "1", CheckisAdmin = "1";
        int check = 0;
        if (isSell == null) {
            CheckisSell = "0";
        }
        if (isAdmin == null) {
            CheckisAdmin = "0";
        } else if (use.matches("^[a-zA-Z0-9]*$") == false) {
            check = 1;
            request.setAttribute("mess", "Thêm mới tài khoản thất bại. Tên tài khoản không hợp lệ.");
            List<Account> list = dao.getAccount();
            request.setAttribute("Account", list);
            request.getRequestDispatcher("ManagerAccount.jsp").forward(request, response);
        } else if (pass.matches("^[a-zA-Z0-9]*$") == false) {
            check = 1;
            request.setAttribute("mess", "Thêm mới tài khoản thất bại. Mật khẩu không hợp lệ.");
            List<Account> list = dao.getAccount();
            request.setAttribute("Account", list);
            request.getRequestDispatcher("ManagerAccount.jsp").forward(request, response);
        } else if (phone.matches("^[0-9]*$") == false) {
            check = 1;
            request.setAttribute("mess", "Thêm mới tài khoản thất bại. Số điện thoại không hợp lệ.");
            List<Account> list = dao.getAccount();
            request.setAttribute("Account", list);
            request.getRequestDispatcher("ManagerAccount.jsp").forward(request, response);
        }
        if (check == 0) {
            Account a = dao.Checklogin(use);
            if (a != null) {
                request.setAttribute("mess", "Thêm mới tài khoản thất bại. Tài khoản đã tồn tại.");
                request.getRequestDispatcher("ManagerAccount").forward(request, response);
            } else {
                if (account.getId() == 1) {
                    dao.AddAccount(use, pass, CheckisSell, CheckisAdmin, name, phone, address);
                    request.setAttribute("mess", "Thêm mới tài khoản thành công.");
                    List<Account> list = dao.getAccount();
                    request.setAttribute("Account", list);
                }else{
                    dao.AddAccount(use, pass, CheckisSell, "0", name, phone, address);
                    request.setAttribute("mess", "Thêm mới tài khoản thành công.");
                    List<Account> list = dao.getAccount();
                    request.setAttribute("Account", list);
                }
                request.getRequestDispatcher("ManagerAccount.jsp").forward(request, response);
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
