/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dao.AccountDao;
import entity.Account;
import entity.AccountLock;
import entity.AccountSellID;
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
@WebServlet(name="SignUpSeller", urlPatterns={"/SignUpSeller"})
public class SignUpSeller extends HttpServlet {
   
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
        HttpSession session = request.getSession();
        AccountDao dao = new AccountDao();
        String Accid = (String) session.getAttribute("AccountID");
        AccountSellID accountSellID = dao.CheckSeller(Accid);
        int checkSell = accountSellID.getIsSell();
        if(checkSell == 0){
            dao.SigupSeller(1, Accid);
            request.setAttribute("mess", "Đăng ký là tài khoản bán hàng thành công. Vui lòng hãy đăng nhập lại.");
            session.removeAttribute("acc");
            request.getRequestDispatcher("Login.jsp").forward(request, response);  
        }else{
            request.setAttribute("messAcc", "Tài khoản này đã đăng ký là tài khoản bán hàng.");
            Account a = dao.getAccountbyID(Accid);
            request.setAttribute("settingAcc", a);
            request.getRequestDispatcher("SettingAccount.jsp").forward(request, response);       
        }
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
