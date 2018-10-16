package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import tienda.bean.Articulo;

public final class verArticulos_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Artículos</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

           ArrayList <Articulo> verArt =(ArrayList<Articulo>) request.getAttribute("verArt");
        
      out.write("\n");
      out.write("        <h1>Artículos</h1>\n");
      out.write("        <table style=\"border-radius: 20px; border: 2px solid ; padding: 10px; \" align=\"center\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Nombre: </th>\n");
      out.write("                <td>Descripcion: </td>\n");
      out.write("                <td>Precio: </td>\n");
      out.write("                <td>Foto: </td>\n");
      out.write("            </tr>\n");
      out.write("            ");
for(Articulo x: verArt){
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <th>");
      out.print(x.getNombre());
      out.write("</th>\n");
      out.write("                <td style=\"width: 180px;\">");
      out.print(x.getDescripcion());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(x.getPrecio());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(x.getFoto());
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            \n");
      out.write("        </table>\n");
      out.write("            \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
