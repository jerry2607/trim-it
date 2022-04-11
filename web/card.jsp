<%-- 
    Document   : index
    Created on : 10 Nov, 2019, 7:15:20 AM
    Author     : ruhel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
String name="./abc2.jpg";
%>

<!DOCTYPE html>
<html>
    <head>
      <!--  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>-->
        <link rel="stylesheet" type="text/css" href="./cards.css"/>
    </head>
    <body>
        <div class="main">
           
     <div class="cards">
            <div class="image">
                <img src="./abc.jpg"/>
            </div>
            
            <div class="desc">
                <p>descripton here</p>
                <button>BUY NOW</button>   
            </div>
            
           
        </div>
            
              <div class="cards">
            <div class="image">
                <img src="<%=name%>"/>
            </div>
            
            <div class="desc">
                <p>descripton here</p>
                <button>BUY NOW</button>   
            </div>
            
           
        </div>
            
            
              <div class="cards">
            <div class="image">
                <img src="./abc3.jpg"/>
            </div>
            
            <div class="desc">
                <p>descripton here</p>
                <button>BUY NOW</button>   
            </div>
            
           
        </div>
            
            
            
                
              <div class="cards">
            <div class="image">
                <img src="./abc4.png"/>
            </div>
            
            <div class="desc">
                <p>descripton here</p>
                <button>BUY NOW</button>   
            </div>
            
           
        </div>
            <a  class="more" href="more.jsp">more>></a> 
        </div>
        
    </body>
</html>
