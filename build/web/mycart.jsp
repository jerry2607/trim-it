<%-- 
    Document   : mycart
    Created on : 12 Nov, 2019, 2:55:54 PM
    Author     : ruhel
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link rel="stylesheet" type="text/css" href="cards.css">
    </head>
    <body>
        
        <%
           String uemail = (String) request.getSession().getAttribute("uemail");
            if(uemail==null)
               request.getRequestDispatcher("login.jsp").forward(request, response);
            
     ResultSet rs;
            Connection con;
                Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sitedata2", "root", "");
            
            Statement stmt=con.createStatement();
            rs=stmt.executeQuery("select `item` from kart where `uemail`='"+uemail+"'");
%>
        
        <div class="d1" >
            <h1 style="border: 2px; background-color: orange;">YOUR CART.............</h1>            
        </div>
        <%while (rs.next()) {
                 
                        //     out.println(""+rs.getString(1));
                        String path = rs.getString(1);
                    //String path="./images/pa.jpg";

                %>

                <div class="cards">
                    <div class="image">
                        <img src="<%=path%>"/>
                    </div>

                    <div class="desc">
                        <p>descripton here</p>
                        <a href="removefromcart?param=<%=path%>"><button>REMOVE FROM CART</button></a>
                        <button>BUY NOW</button>   
                    </div>
                </div>
                <%

                    }%>
    
    </body>
</html>
