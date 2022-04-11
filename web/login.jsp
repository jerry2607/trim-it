<%@page import="java.lang.Object"%>
<html>
    <head>
        <title>Login Form Design</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        
        
        </head>
    <body>
       
         
         <%
        String valid =(String) request.getAttribute("valid");
        %>
        <script type="javascript">
            
           if ("<%=valid%>"=== "no")
            {
                alert ("invalid email id or password");
            }
              </script>
          
        <div class="loginbox">
            <img src="avtar.jpg" class="avtar">
            <h1> Login Here</h1>

            <form action="logincheck" method="post">
                <table cellpadding="30">
                    <tr>
                        <td><input id="as" type="checkbox" name="barber" value="barber" ></td>
                        <td><p>Login as a Barber</p></td>
                    </tr>
                </table>
                <p>Username</p>
                <input type="text" name="name" placeholder="Enter Username">
                <p>Password</p>
                <input type="password" name="password" placeholder="Enter Password" >
                <input type="submit"  value="Login">
                <a href="#">Forgot your Password?</a><br>
                <a href="signup.jsp">Don't have an Account?</a>
                
            </form>
        </div>
    </body>

</html>
