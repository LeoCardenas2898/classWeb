<%-- 
    Document   : verArticulos
    Created on : 15/10/2018, 08:07:25 PM
    Author     : Alumno
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="tienda.bean.Articulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Artículos</title>
    </head>
    <body>
        <%
           ArrayList <Articulo> verArt =(ArrayList<Articulo>) request.getAttribute("verArt");
        %>
        <h1 align="center">Artículos</h1>
        <table style="border-radius: 20px; border: 5px solid ; padding: 10px; border-style: groove; " align="center" >
            <tr>
                <th align="center">Nombre</th>
                <td align="center">Descripción</td>
                <td align="center">Precio</td>
                <td align="center">Foto</td>
            </tr>
            <%for(Articulo x: verArt){%>
            <tr>
                <th style="width: 100px;"><%=x.getNombre()%></th>
                <td style="width: 400px;" align="justify"><%=x.getDescripcion()%></td>
                <td><%=x.getPrecio()%></td>
                <td><img src="img/<%=x.getFoto()%>" width="100px"></td>
            </tr>
            <%}%>
            
        </table>
            
    </body>
</html>
