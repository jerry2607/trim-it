/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Access Denier
 */
public class logincheck extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String loginas = request.getParameter("barber");
            String tablename = "userinfo";
            if ("barber".equals(loginas)) {
                tablename = "barberinfo";
            }
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sitedata2", "root", "");
            out.println("connection has been created............");
            Statement stmt = con.createStatement();
            String myQuery = "select `upincode`,`uemail`,`upassword` from `" + tablename + "` where `uemail`='" + name + "' and `upassword`='" + password+"'";
            
            if ("barber".equals(loginas)) {
                myQuery = "select `bpincode`,`bemail`,`bpassword` from `" + tablename + "` where `bemail`='" + name + "' and `bpassword`='" + password+"'";
            }
            ResultSet rs = stmt.executeQuery(myQuery);
                     out.println("connection has been created............");
            if (rs.next()) {
                String upincode=rs.getString(1);
           request.getSession().setAttribute("uemail", name);
           request.getSession().setAttribute("upincode", upincode);
                request.setAttribute("valid", "yes");
                request.getRequestDispatcher("home.jsp").forward(request, response);
              
                //response.sendRedirect("home.jsp");

            } else {
                request.setAttribute("valid", "no");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        
            /* else
         {
             response.sendRedirect("login.jsp");
         }*/
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(logincheck.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(logincheck.class.getName()).log(Level.SEVERE, null, ex);
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
