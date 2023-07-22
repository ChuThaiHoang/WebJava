/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dao.CategoryDao;
import entity.Category;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author eotke
 */
@WebServlet(name="AddCategory", urlPatterns={"/AddCategory"})
public class AddCategory extends HttpServlet {
   
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
        String name = request.getParameter("name");
        CategoryDao daoC = new CategoryDao();
         int check = 0;
        if (name.matches("^[a-zA-Z0-9 ]*$") == false) {
            check = 1;
            request.setAttribute("mess", "Thêm mới danh mục thất bại. Tên danh mục không hợp lệ.");
            List<Category> list = daoC.getCategory();
            request.setAttribute("category", list);
            request.getRequestDispatcher("ManagerCategory.jsp").forward(request, response);
        } 
         if (check == 0) {
            Category a = daoC.CheckCate(name);
            if (a != null) {
                request.setAttribute("mess", "Thêm mới danh mục thất bại. danh mục đã tồn tại.");
                request.getRequestDispatcher("ManagerAccount").forward(request, response);
            } else {
                daoC.AddCategory(name);
                request.setAttribute("mess", "Thêm mới tài khoản thành công.");
                List<Category> list = daoC.getCategory();
                request.setAttribute("category", list);
                request.getRequestDispatcher("ManagerCategory.jsp").forward(request, response);
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
