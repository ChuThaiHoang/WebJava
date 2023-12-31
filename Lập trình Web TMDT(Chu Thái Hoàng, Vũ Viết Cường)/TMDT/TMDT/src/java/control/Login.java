/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dao.AccountDao;
import entity.Account;
import entity.AccountLock;
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
@WebServlet(name="Login", urlPatterns={"/Login"})
public class Login extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
        String use = request.getParameter("user");
        String pass = request.getParameter("pass");
        AccountDao dao = new AccountDao();
        Account a = dao.login(use, pass);
        if (a == null) {
            request.setAttribute("messlogin", "Sai tài khoản hoặc mật khẩu");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }else{
            HttpSession session = request.getSession();
            AccountLock accountLock = dao.LockAccountByUser(use);
        int lock = accountLock.getLock();
        if(lock == 0){
            session.setAttribute("acc", a);
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        }else{
            request.setAttribute("messlogin", "Tài khoản của bạn đã bị khoá. Liên hệ Admin để được hỗ trợ."
                    + " Email: vucuong08072003@gmail.com");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }      
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
