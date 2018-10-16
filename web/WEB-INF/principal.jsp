<%-- 
    Document   : principal
    Created on : 15/10/2018, 07:19:21 PM
    Author     : Alumno
--%>

<%@page import="tienda.bean.Usuario"%>
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
            Usuario us = (Usuario)request.getSession().getAttribute("us");
        %>  
        <h3>Usuario: <%=us.getUsuario()%> <a href="cerrarSesion">Cerrar sesión</a></h3>
        
        <ul>
            <li><a href="verArticulos">Ver artículos</a></li>
            <li><a href="listarArticulos">Listar artículos</a></li>
        </ul>

    </body>
</html>
