/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.controlador.usuario;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tienda.bean.Usuario;
import tienda.dao.UsuarioDAO;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "ServletUser", urlPatterns = {"/validarUsuario","/cerrarSesion"})
public class ServletUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Recoger el valor de urlPatterns solicitado:
        String path = request.getServletPath();
        if(path.equals("/validarUsuario")){
            //Capturar datos de login.jsp
            String user = request.getParameter("txtUser");
            String password = request.getParameter("txtPass");
            //Verificar datos en el model
            UsuarioDAO ud = new UsuarioDAO();
            Usuario  usuario =ud.validarUsuario(user, password);
            if(usuario!=null){
               //Asignar valor a un atributo:
                request.getSession().setAttribute("us", usuario);
               //Ir a la ventana principal:
                request.getRequestDispatcher("/WEB-INF/principal.jsp").forward(request, response);
            }else{
                //Ir a login:
                request.setAttribute("message", "Incorrect user or password!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }else if(path.equals("/cerrarSesion")){
            request.getSession().removeAttribute("us");
            //Cerrar sesion:
            request.getSession().invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
            
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
