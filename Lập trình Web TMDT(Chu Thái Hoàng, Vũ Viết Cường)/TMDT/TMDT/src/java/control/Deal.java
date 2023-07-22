/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.AccountDao;
import dao.CartDao;
import dao.DealDao;
import dao.ProductDAO;
import entity.Account;
import entity.Cart;
import entity.Product;
import entity.oderCart;
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
@WebServlet(name = "Deal", urlPatterns = {"/Deal"})
public class Deal extends HttpServlet {

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
        String cartid = request.getParameter("cartid");
        session.setAttribute("cartid", cartid);
        CartDao Cdao = new CartDao();
        ProductDAO pdao = new ProductDAO();       
        Cart cart = Cdao.getCartByID(cartid);             
        Product product = pdao.getProductID(String.valueOf(cart.getProductID()));       
        float tong, tong2;
        float amount, price;
        amount = cart.getAmount();
        price = (float) product.getPrice();
        tong = amount * price;
        tong2 = tong;
        Account account = (Account) session.getAttribute("acc");

        request.setAttribute("tong", tong);
        request.setAttribute("tong2", tong2);
        request.setAttribute("AccountCart", account);
        request.setAttribute("DealCart", cart);
        request.setAttribute("ProductCart", product);
        request.getRequestDispatcher("Deal.jsp").forward(request, response);

    }

    /*
    Account a = (Account) session.getAttribute("acc");
        int id = a.getId();
        List<oderCart> listoderCart = Cdao.getCartByAccountId(id);
        int Cartid[] = new int[listoderCart.size()];
        String OderCartid[] = new String[listoderCart.size()];
        int j = 0;
        for (oderCart cart : listoderCart) {
            Cartid[j] = cart.getId();
            j++;
        }
        for (int i = 0; i < listoderCart.size(); i++) {
            String Cid = request.getParameter(String.valueOf(Cartid[i]));
            OderCartid[i] = Cid;
        }

        int k = 0;
        String sql = "";
        for (oderCart oderCart : listoderCart) {
            if (OderCartid[k] != null) {
               Cart cart = Cdao.getCartByID(String.valueOf(oderCart.getId()));
                sql +="or banhangdemo.cart.AccountID = "+ id 
                        +" and banhangdemo.cart.ProductID = "+cart.getProductID();
            }
            k++;
        }
        if("".equals(sql)){
            
        }else{
            List<oderCart> list = Cdao.getCartByDeal(id,sql);
            request.setAttribute("listCart", list);
            request.getRequestDispatcher("Deal.jsp").forward(request, response);
        }
     */
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
