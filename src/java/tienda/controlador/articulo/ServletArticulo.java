/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.controlador.articulo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tienda.bean.Articulo;
import tienda.dao.ArticuloDAO;
import tienda.dao.CategoriaDAO;


@WebServlet(name = "ServletArticulo", urlPatterns = {"/nuevoArticulo","/verArticulos","/listarArticulos","/grabarArticulo","/editarArticulo","/eliminarArticulo"})
public class ServletArticulo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getServletPath();
        if(path.equals("/verArticulos")){
            //Traer artículos del modelo y asignar a atributo 'verArticulos':
            ArticuloDAO ad = new ArticuloDAO();
            request.setAttribute("verArt", ad.list());
            //Ir a verArticulos.jsp
            request.getRequestDispatcher("/WEB-INF/verArticulos.jsp").forward(request, response);
        }else if(path.equals("/listarArticulos")){
            ArticuloDAO ad = new ArticuloDAO();
            request.setAttribute("articulos", ad.list());
            //Ir a articulos.jsp
            request.getRequestDispatcher("/WEB-INF/articulos.jsp").forward(request, response);
        }else if(path.equals("/nuevoArticulo")){
            request.setAttribute("artID", new Articulo());
            CategoriaDAO cd = new CategoriaDAO();
            request.setAttribute("cat", cd.list());
            //Ir a formArticulos.jsp
            request.getRequestDispatcher("/WEB-INF/formArticulos.jsp").forward(request, response);
        }else if(path.equals("/grabarArticulo")){
            ArticuloDAO ad = new ArticuloDAO();
            Articulo articulo = new Articulo();
            int idArt = Integer.parseInt(request.getParameter("txtId"));
            //Traer datos del formulario:
            articulo.setNombre(request.getParameter("txtNom"));
            articulo.setDescripcion(request.getParameter("txtDes"));
            articulo.setIdcategoria(Integer.parseInt(request.getParameter("txtCat")));
            articulo.setPrecio(Double.parseDouble(request.getParameter("txtPre")));
            if(idArt>0){
                articulo.setIdarticulo(idArt);
                ad.update(articulo);
            }else{
                ad.save(articulo);
            }
            //Redireccionar al servlet listarArticulo
            response.sendRedirect("listarArticulos");
        }else if(path.equals("/editarArticulo")){
            ArticuloDAO ad = new ArticuloDAO();
            //ID por la url: ?id<&=x.getIdArticulo%>
            int id = Integer.parseInt(request.getParameter("id"));
            //Buscar artículo por el id
            request.setAttribute("artID", ad.get(id));
            CategoriaDAO cd = new CategoriaDAO();
            request.setAttribute("cat", cd.list());
            //Ir a formArticulos.jsp
            request.getRequestDispatcher("/WEB-INF/formArticulos.jsp").forward(request, response);
        }else if(path.equals("/eliminarArticulo")){
            int id = Integer.parseInt(request.getParameter("id"));
            ArticuloDAO ad = new ArticuloDAO();
            ad.delete(id);
            response.sendRedirect("listarArticulos");
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
