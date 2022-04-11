/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
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
 * @author ruhel
 */
public class signafterimage extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet signafterimage</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet signafterimage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            Class.forName("com.mysql.jdbc.Driver");
               String uemail = (String) request.getSession().getAttribute("uemail");
            String unumber = (String) request.getSession().getAttribute("unumber");
            String uname = (String) request.getSession().getAttribute("uname");
            String uaddress = (String) request.getSession().getAttribute("uaddress");
            String upincode = (String) request.getSession().getAttribute("upincode");
            String upassword = (String) request.getSession().getAttribute("upassword");
            String str=(String) request.getSession().getAttribute("str");
            
                       Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sitedata2", "root", "");
            out.println("connection has been created");
            Statement stmt=con.createStatement();
                  stmt.executeUpdate("INSERT INTO `barberinfo` (`bname`, `bemail`, `bnumber`, `bpassword`, `baddress`, `bpincode`,`bimagepath`) VALUES ('"+uname+"', '"+uemail+"', '"+unumber+"', '"+upassword+"', '"+uaddress+"', '"+upincode+"','"+str+"')");
              /* PreparedStatement prt;
                  String myQuery = "insert into userinfo values(?,?,?,?,?,?,?)";
             prt = (PreparedStatement) con.prepareStatement(myQuery);
            prt.setString(1, uname1);
            prt.setString(2, uemail1);
            prt.setString(3, unumber1);
            prt.setString(4, upassword1);
            prt.setString(5, uaddress1);
            prt.setString(6, upincode1);*/
               
                     //      out.println("done by use end/............................................");
             request.getRequestDispatcher("home.jsp").forward(request, response);
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
        } catch (SQLException ex) {
            Logger.getLogger(signafterimage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(signafterimage.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(signafterimage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(signafterimage.class.getName()).log(Level.SEVERE, null, ex);
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
