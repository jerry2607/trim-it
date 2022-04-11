<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html >
    <head>

        <title>time for grooming</title>
        <link rel="stylesheet" type="text/css" href="home.css">
        <link rel="stylesheet" type="text/css" href="cards.css">
        <!-- <link rel="stylesheet" href="css/skeleton.css">-->
    </head>
    <body>
        <%!
             int count=0;
            ResultSet rs;
            ResultSet rs2;
            Connection con1;
        
        %>
        <%
            Class.forName("com.mysql.jdbc.Driver");
            con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sitedata2", "root", "");
            String email = (String) request.getSession().getAttribute("uemail");
            //con =(Connection)request.getSession().getAttribute("con");
            Statement stmt = con1.createStatement();
            rs = stmt.executeQuery("select offerimage,offer from offerinfo");
            
//out.println(""+rs.getString(1));

        %>
      
        <script language="javascript" >
            if ("<%=email%>"===null)
            {
                var x = confirm("do you want to login");
                if (x)
                {
                    window.location.replace("login.jsp");
                }
            }
            
            
        </script>
        
        
        <!--  <form  action="" method="post"> -->
        <div id="d1">

            <h1 id="name">Trim-iT</h1>
            <% if(request.getSession().getAttribute("uemail")!=null){
                   
            %>
               <a id="a1" class ="c1" href="logout" >logout</a>
               
            <%} else {%>
            <a id="a1" class ="c1" href="login.jsp" >login</a>
            <%}%>
            <a id ="a2" class ="c1" href="signup.jsp" >sign-up</a>

            <a id ="a3" class ="c1" href="mycart.jsp">my cart</a>
            <!--    <a id="a4" class="c1" href="explore.html">Explore</a>
            <!--  <a id="location" class="c1" href="www.google.com">Locate Me</a -->
        </div>
        <!--  <script>
           var x=confirm("do you want to search near you,it will access you location");
           if(x)
           {
      
           }
          </script>
        -->

        <div id="d3">

            <div class="offers">
                <h1>OFFERS</h1>
                <%while (count<4) {
                    count++;    
                           rs.next();
                        //     out.println(""+rs.getString(1));
                        String path = rs.getString(1);
                        String des=rs.getString(2);
                    //String path="./images/pa.jpg";
                %>

                <div class="cards">
                    <div class="image">
                        <img src="<%=path%>"/>
                    </div>

                    <div class="desc">
                        <p><%=des%></p>
                        <a href="addtocart?param1=<%=path%>" ><button >ADD TO CART</button></a>
                        <button>BUY NOW</button>   
                    </div>
                </div>
                <%
                    }%>

        <%count=0;%>


                <div class="anchor"> 
                    <a  class="more" href="moreoffers.jsp">more>></a> 
                </div>

            </div>

            <!--products start-->





            <h1>PRODUCTS</h1>
                
            <div class="products">
                <%
                   rs = stmt.executeQuery("select pimage,pname from productinfo");
                  while (count<4) {
                    count++;
                           rs.next();
                        //     out.println(""+rs.getString(1));
                        String path2 = rs.getString(1);
                        String des2=rs.getString(2);
                    //String path="./images/pa.jpg";

                %>

                <div class="cards">
                    <div class="image">
                        <img src="<%=path2%>"/>
                    </div>
                         <%
                   // String path2="./images/barbering/images(0).jpg";
                         %>
                    <div class="desc">
                        <p><%=des2%></p>
                        <a href="addtocart?param1=<%=path2%>" ><button >ADD TO CART</button></a>
                        <button>BUY NOW</button>   
                    </div>
                </div>
                <%

                    }%>

        <%count=0;%>


                <div class="anchor"> 
                    <a  class="more" href="moreproducts.jsp">more>></a> 
                </div>

            </div>



            <!--barber starts-->



            <h1>BARBERS</h1>


            <div class="barber">
                   <%
                   rs = stmt.executeQuery("select bimagepath,bname from barberinfo");
                  while (count<4) {
                    count++;
                           rs.next();
                        //     out.println(""+rs.getString(1));
                        String path3 = rs.getString(1);
                        String des3=rs.getString(2);
                    //String path="./images/pa.jpg";

                %>

                <div class="cards">
                    <div class="image">
                        <img src="./images/<%=path3%>"/>
                    </div>
                         <%
                   // String path2="./images/barbering/images(0).jpg";
                         %>
                    <div class="desc">
                        <p><%=des3%></p>
                        <a href="addtocart?param1=<%=path3%>" ><button >ADD TO CART</button></a>
                        <button>BOOK NOW</button>   
                    </div>
                </div>
                <%

                    }%>

        <%count=0;%>

                <div class="anchor"> 
                    <a  class="more" href="morebarbers.jsp">more>></a> 
                </div>

            </div>





        </div>

       <!-- </form> -->

    </body>
</html>
