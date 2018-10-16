<%-- 
    Document   : principal
    Created on : 15/10/2018, 07:19:21 PM
    Author     : Alumno
--%>

<%@page import="tienda.bean.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
    </head>
    <body>
        <h1 align="center">Welcome!</h1>
        <%
            //Recoger variables de sesión que viene de validarUsuario:
            Empleado emp = (Empleado)request.getSession().getAttribute("empleado");
        %>  
        <h3>Usuario: <%=emp.getNombre()+" "+emp.getPaterno()%> <a href="cerrarSesion">Cerrar sesión</a></h3>
        
        <ul>
            <li><a href="verArticulos">Ver artículos</a></li>
            <li><a href="listarArticulos">Listar artículos</a></li>
        </ul>

    </body>
</html>
