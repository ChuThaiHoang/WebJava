/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.CategoryDao;
import dao.ProductDAO;
import entity.Account;
import entity.Category;
import entity.Product;
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
@WebServlet(name = "LockProduct", urlPatterns = {"/LockProduct"})
public class LockProduct extends HttpServlet {

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
        HttpSession session = request.getSession();
        String pid = (String) session.getAttribute("PidLock");
        ProductDAO Pdao = new ProductDAO();
        CategoryDao Cdao = new CategoryDao();
        Product product = Pdao.getProductID(pid);
        Account a = (Account) session.getAttribute("acc");
        int id = a.getId();
        int Checklock = product.getLock();
        if (Checklock == 0) {
            Pdao.LockP(1, pid);
            List<Product> listp = Pdao.getProductSellID(id);
            List<Category> listc = Cdao.getCategory();
            request.setAttribute("listC", listc);
            request.setAttribute("listProduct", listp);
            request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
        } else {
            Pdao.LockP(0, pid);
            List<Product> listp = Pdao.getProductSellID(id);
            List<Category> listc = Cdao.getCategory();
            request.setAttribute("listC", listc);
            request.setAttribute("listProduct", listp);
            request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);

        }
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
