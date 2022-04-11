<%-- 
    Document   : more.jsp
    Created on : 11 Nov, 2019, 9:50:10 PM
    Author     : Access Denier
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    ResultSet rs;
    Connection con1;
%>
<%
    Class.forName("com.mysql.jdbc.Driver");
    con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sitedata2", "root", "");
    Statement stmt = con1.createStatement();
    rs = stmt.executeQuery("select * from offerinfo");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" type="text/css" href="home.css">
        <link rel="stylesheet" type="text/css" href="cards.css">
        <title>All Offers here</title>
    </head>
    <body>
        <div id="d1">
            <h1 id="name">Trim-iT</h1>
        </div>
         <div id="d3">

            <div>
                <%while(rs.next()) {      
                %>

                <div class="cards">
                    <div class="image">
                        <%
                    String path= rs.getString(2);
                        %>
                        <img src="<%=path %>"/>
                    </div>
                        
                    <div class="desc">
                        <p><%=rs.getString(3)%></p>
                        <br>
                        <p><%=rs.getString(4)%></p>
                        <button>BUY NOW</button>   
                    </div>
                </div>
                <%}%>
            </div>
         </div>
    </body>
</html>
