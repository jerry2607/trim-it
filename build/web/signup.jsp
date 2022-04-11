<%-- 
    Document   : signup
    Created on : 2 Nov, 2019, 9:39:09 AM
    Author     : Access Denier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style2.css">
    </head>
    <body>
        <!-- script language="javascript">
            function myaction(){
                var x = document.getElementById("as").checked;
                if(x===true) 
            }
        </script -->
        <div class="loginbox">
            <img src="avtar.jpg" class="avtar">
            <h1>SignUp Here</h1>
            
            <form action="signupdata" method="post">
            <table cellpadding="30" align="center">
                <tr>
                    <td>
                        <p>Name:</p>
                        <input type="text" name="uname" placeholder="your name"/>
                     </td>
                     <td>
                        <p> Number:</p>
                        <input type="text" name="unumber" placeholder="your number"/>
                     </td>
                </tr>
                <tr>
                    <td>
                        <p> Email:</p>
                        <input type="text" name="uemail" placeholder="your mail"/>
                    </td>
                    <td>
                       <p> Password:</p>
                       <input type="password" name="upassword" placeholder="your password"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Pincode:</p>
                        <input type="text" name="upincode" placeholder="your pincode"/>
                    </td>
                    <td>
                      <p>Address:</p>
                      <input type="text" name="uaddress" placeholder="your address"/>
                    </td>
                </tr>
               <tr>
                    <td><input id="as" type="checkbox" name="barber" value="barber" ></td>
                    <td><a>Want to register as a barber?</a></td>
                </tr>
            </table>
            <input type="submit" value="submit"/>
        </form>
      </div>
    </body>
</html>
