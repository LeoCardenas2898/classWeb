<%-- 
    Document   : formArticulos
    Created on : 29/10/2018, 06:26:26 PM
    Author     : Alumno
--%>

<%@page import="tienda.bean.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registrar artículo</h1>
        <% ArrayList<Categoria> cd = (ArrayList<Categoria>)request.getAttribute("cat"); %>
        <form method="POST" action="grabarArticulo" enctype="multipart/form-data">
            <table style="border-radius: 20px; border: 10px solid ; padding: 10px; border-style: groove; " align="center" >                
                    <tr>
                        <td>Nombre <input type="hidden" name="txtId" value="${artID.idarticulo}"></td>
                        <%--Lenguaje de expresiones :${}--%>
                        <td><input type="text" name="txtNom" value="${artID.nombre}"></td>
                    </tr>
                    <tr>
                        <td>Descripción</td>
                        <td><textarea name="txtDes">${artID.descripcion}</textarea></td>
                    </tr>
                    <tr>
                        <td>Categoría</td>
                        <td>
                            <select name="txtCat">
                                <!--option value="-1" selected>Seleccione</option-->
                                <% for(Categoria x: cd){%>
                                <option value="<%=x.getIdcategoria()%>"><%=x.getCategoria()%></option>
                                <%}%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Precio</td>
                        <td><input type="text" name="txtPre" value="${artID.precio}" ></td>
                    </tr>
                    <tr>
                        <td>Foto</td>
                        <td><input type="file" name="txtFot" ></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="grabar"></td>
                    </tr>
            </table>

        </form>
    </body>
</html>
