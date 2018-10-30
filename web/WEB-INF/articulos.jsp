<%-- 
    Document   : articulos
    Created on : 29/10/2018, 06:18:20 PM
    Author     : Alumno
--%>

<%@page import="tienda.bean.Empleado"%>
<%@page import="tienda.bean.Articulo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function confirmar(){
                if (confirm("Esta seguro de eliminar artículo?")){
                    return true
                }
                return false
            }
        </script>
    </head>
    <body>
        <%
           ArrayList <Articulo> verArt =(ArrayList<Articulo>) request.getAttribute("articulos");
        %>
        <h1 align="center">Artículos</h1>
        <%
            //Recoger variables de sesión que viene de validarUsuario:
            Empleado emp = (Empleado)request.getSession().getAttribute("empleado");
        %>  
        <h3>Usuario: <%=emp.getNombre()+" "+emp.getPaterno()%> <a href="cerrarSesion">Cerrar sesión</a></h3>
        <table style="border-radius: 20px; border: 10px solid ; padding: 10px; border-style: groove; " align="center" >
            <tr>
                <th align="center">Nombre</th>
                <td align="center">Descripción</td>
                <td align="center">Precio</td>
                <td align="center" colspan="2"><a href="nuevoArticulo">Nuevo</a></td>
            </tr>
            <%for(Articulo x: verArt){%>
            <tr>
                <th style="width: 100px;"><%=x.getNombre()%></th>
                <td style="width: 400px;" align="justify"><%=x.getDescripcion()%></td>
                <td><%=x.getPrecio()%></td>
                <td><a href="editarArticulo?id=<%=x.getIdarticulo()%>">Editar</a></td>
                <td><a href="eliminarArticulo?id=<%=x.getIdarticulo()%>" onclick="return confirmar()">Eliminar</a></td>
            </tr>
            <%}%>
            
        </table>
    </body>
</html>
