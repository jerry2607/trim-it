<%-- 
    Document   : morebarbers
    Created on : 12 Nov, 2019, 12:18:17 PM
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
    String upincode1 =(String) request.getSession().getAttribute("upincode");
    if(upincode1==null)
        request.getRequestDispatcher("login.jsp").forward(request, response);
    rs = stmt.executeQuery("select * from barberinfo where bpincode="+upincode1);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="home.css">
        <link rel="stylesheet" type="text/css" href="cards.css">
        <title>All Barbers here</title>
    </head>
    <body>
        <div id="d1">
            <h1 id="name">Trim-iT</h1>
        </div>
        <div id="d3">

            <div>
                <%while (rs.next()) {
                %>

                <div class="cards">
                    <div class="image">
                        <%
                    String path="./images/"+rs.getString(8);
                        %>
                        ${path}
                        <img src="<%=path%>"/>
                    </div>

                    <div class="desc">
                        <p><%=rs.getString(2)%></p>
                        <br>
                        <p>CONTACT NO: <%=rs.getString(4)%></p>
                        <button>BOOK NOW</button>   
                    </div>
                </div>
                <%}%>
            </div>
        </div>
    </body>
</html>
