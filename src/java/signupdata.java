/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class signupdata extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet signupdata</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet signupdata at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
              String signupas = request.getParameter("barber");
              String uname1 = request.getParameter("uname");
              String uemail1 = request.getParameter("uemail");
              String upincode1 = request.getParameter("upincode");
              String unumber1 = request.getParameter("unumber");
              String upassword1 = request.getParameter("upassword");
              String uaddress1 = request.getParameter("uaddress");
              request.getSession().setAttribute("uemail", uemail1);
              request.getSession().setAttribute("uname", uname1);
              request.getSession().setAttribute("upincode", upincode1);
              request.getSession().setAttribute("unumber", unumber1);
              request.getSession().setAttribute("upassword", upassword1);
              request.getSession().setAttribute("uaddress", uaddress1);
              if("barber".equals(signupas))
              {
                  out.println(" <html>\n" +
"    <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"style2.css\">\n" +
"    </head>\n" +
"    <body> <div class=\"loginbox\">\n" +
"            <img src=\"avtar.jpg\" class=\"avtar\">\n" +
"            <h1>SignUp Here</h1>\n" +
"            \n" +
"            <form action=\"signupdatafinal\" method=\"post\" enctype =\"multipart/form-data\">\n" +
"            <table cellpadding=\"30\" align=\"center\">\n" +
"                <tr>\n" +
"                    <td>\n" +
"                       <p> Upload Image:</p>\n" +
"                        <input type=\"file\" name=\"pic1\" accept=\"image/*\" />\n" +
"                     </td>\n" +
"                     <td>\n" +
"                          <p> Upload Video:</p>\n" +
"                        <input type=\"file\" name=\"vid1\" accept=\"video/*\"/>\n" +
"                        <input type=\"file\" name=\"vid2\" accept=\"video/*\"/>\n" +
"                        <input type=\"file\" name=\"vid3\" accept=\"video/*\"/>\n" +
"                     </td>\n" +
"                </tr>\n" +
"            </table>\n" +
"            <input type=\"submit\" value=\"submit\"/>\n" +
"        </form>\n" +
"      </div> </body>\n" +
"</html>\n" +
"\n" );
              }
              else
              { 
                  out.println("in else block....................");
                   Class.forName("com.mysql.jdbc.Driver");
                  Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sitedata2", "root", "");
                 
              Statement stmt=con.createStatement();
               out.println("connected..........................");
                stmt.executeUpdate("INSERT INTO `userinfo` (`uname`, `uemail`, `unumber`, `upassword`, `uaddress`, `upincode`) VALUES ('"+uname1+"', '"+uemail1+"', '"+unumber1+"', '"+upassword1+"', '"+uaddress1+"', '"+upincode1+"')");
              /* PreparedStatement prt;
                  String myQuery = "insert into userinfo values(?,?,?,?,?,?,?)";
             prt = (PreparedStatement) con.prepareStatement(myQuery);
            prt.setString(1, uname1);
            prt.setString(2, uemail1);
            prt.setString(3, unumber1);
            prt.setString(4, upassword1);
            prt.setString(5, uaddress1);
            prt.setString(6, upincode1);
               */
                         //  out.println("done by use end/............................................");
                           request.getRequestDispatcher("home.jsp").forward(request, response);
             }
//              out.println(tab);
              
              
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(signupdata.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(signupdata.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(signupdata.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(signupdata.class.getName()).log(Level.SEVERE, null, ex);
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
