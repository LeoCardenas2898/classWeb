<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%
            //Obtener el valor de message de error de login:
            String message = (String) request.getAttribute("message");
        %>
        <table style="border-radius: 20px; border: 2px solid ; padding: 10px; " align="center" >
            <%--action tiene que ser igual al urlPatterns del Servlet--%>
            <form action="validarUsuario" method="post">
                <tr>
                    <td>User</td>
                    <td><input type="text" name="txtUser"></td> 
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="text" name="txtPass"></td> 
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Sign in"></td> 
                </tr>
                <tr>
                    <td colspan="2" align="center"><%=message!=null ? message: ""%></td>
                </tr>
            </form>
        </table>
    </body>
</html>
