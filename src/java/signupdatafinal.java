/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 *
 * @author Access Denier
 */
public class signupdatafinal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, FileUploadException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                   Class.forName("com.mysql.jdbc.Driver");
                   out.println("classfound................................................");
            out.println("very first statement");

            String uemail = (String) request.getSession().getAttribute("uemail");
            String unumber = (String) request.getSession().getAttribute("unumber");
            String uname = (String) request.getSession().getAttribute("uname");
            String uaddress = (String) request.getSession().getAttribute("uaddress");
            String upincode = (String) request.getSession().getAttribute("upincode");
            String upassword = (String) request.getSession().getAttribute("upassword");
            out.println("after retriving");
            //out.println(uname);

      
     // servlet code start
     
             Connection con;
           
            File file;
            String str = null;
            PreparedStatement prt;
            int maxSize = 10000*100;
            int maxFactSize = 10000*100;
            String email;
            String path = "E:/beans_projects/MyWebApp/web/images";
     
     
           email=(String)request.getSession().getAttribute("email");
           String type = request.getContentType();
           out.println("type here  ");
           if(type.indexOf("multipart/form-data")>=0){
               out.println("  multipart data  ");
               DiskFileItemFactory disFact = new DiskFileItemFactory();
               disFact.setSizeThreshold(maxFactSize);
               disFact.setRepository(new File("E:\\temp"));
               ServletFileUpload upload = new ServletFileUpload(disFact);
               upload.setSizeMax(maxSize);
               List lis = upload.parseRequest((new ServletRequestContext(request)));
               Iterator itr = lis.iterator();
               while(itr.hasNext()){
                   FileItem item = (FileItem) itr.next();
                   
                   if(!item.isFormField()){
                       str = item.getName();
                       str = uemail+(str.substring(str.indexOf(".")));
                       out.println("   str   ");
                       file = new File(path,str);
                       item.write(file);
                       request.getSession().setAttribute("str",str);
                       out.println("success---------------");
                       request.getRequestDispatcher("signafterimage").forward(request, response);
                   }
               }
           }
      //  servlet code end
/*             con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sitedata", "root", "");
            out.println("connection has been created");
            Statement stmt=con.createStatement();
                  stmt.executeUpdate("INSERT INTO `barbererinfo` (`uname`, `uemail`, `unumber`, `upassword`, `uaddress`, `upincode`,`bimagepath`) VALUES ('"+uname+"', '"+uemail+"', '"+unumber+"', '"+upassword+"', '"+uaddress+"', '"+upincode+"','"+str+"')");
              /* PreparedStatement prt;
                  String myQuery = "insert into userinfo values(?,?,?,?,?,?,?)";
             prt = (PreparedStatement) con.prepareStatement(myQuery);
            prt.setString(1, uname1);
            prt.setString(2, uemail1);
            prt.setString(3, unumber1);
            prt.setString(4, upassword1);
            prt.setString(5, uaddress1);
            prt.setString(6, upincode1);
               
                           out.println("done by use end/............................................");
  */           
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
            Logger.getLogger(signupdatafinal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(signupdatafinal.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(signupdatafinal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(signupdatafinal.class.getName()).log(Level.SEVERE, null, ex);
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
