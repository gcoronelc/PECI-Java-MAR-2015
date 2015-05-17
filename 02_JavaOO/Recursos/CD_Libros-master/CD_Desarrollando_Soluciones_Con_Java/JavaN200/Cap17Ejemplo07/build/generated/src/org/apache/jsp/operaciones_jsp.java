package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class operaciones_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"paginaError.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      logic.MyMath myMath = null;
      synchronized (_jspx_page_context) {
        myMath = (logic.MyMath) _jspx_page_context.getAttribute("myMath", PageContext.PAGE_SCOPE);
        if (myMath == null){
          myMath = new logic.MyMath();
          _jspx_page_context.setAttribute("myMath", myMath, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("myMath"), request);
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("    <head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\t<title>Operaciones</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    \r\n");
      out.write("    <body>\r\n");
      out.write("\t<h1>Operaciones</h1>\r\n");
      out.write("\t<table width=\"268\">\r\n");
      out.write("\t    <tr>\r\n");
      out.write("\t\t<td width=\"96\">Número 1</td>\r\n");
      out.write("\t\t<td width=\"160\">");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((logic.MyMath)_jspx_page_context.findAttribute("myMath")).getNum1())));
      out.write("</td>\r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t    <tr>\r\n");
      out.write("\t\t<td>Número 2</td>\r\n");
      out.write("\t\t<td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((logic.MyMath)_jspx_page_context.findAttribute("myMath")).getNum2())));
      out.write("</td>\r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t    <tr>\r\n");
      out.write("\t\t<td>Suma</td>\r\n");
      out.write("\t\t<td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((logic.MyMath)_jspx_page_context.findAttribute("myMath")).getSuma())));
      out.write("</td>\r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t    <tr>\r\n");
      out.write("\t\t<td>Producto</td>\r\n");
      out.write("\t\t<td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((logic.MyMath)_jspx_page_context.findAttribute("myMath")).getProducto())));
      out.write("</td>\r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<p><a href=\"operaciones.html\">Retornar</a></p>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
