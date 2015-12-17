package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title></title>\n");
      out.write("\n");
      out.write("  <script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("\t\t$(document).ready(function() {\n");
      out.write("\n");
      out.write("\t\t\t// Check The Status Every 2 Seconds\n");
      out.write("\t\t\tvar timer = setInterval(function() {\n");
      out.write("\n");
      out.write("\t\t\t\t$.ajax({\n");
      out.write("\t\t\t\t\t  url: 'reportstatus.json',\n");
      out.write("\t\t\t\t\t  success: function(data) {\n");
      out.write("\n");
      out.write("\t\t\t\t\t\tif(data === 'COMPLETE') {\n");
      out.write("\t\t\t\t\t\t\t$('#reportLink').html(\"<a target='_target' href='report.html'>Download Report</a>\");\n");
      out.write("\t\t\t\t\t\t\tclearInterval(timer);\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t  }\n");
      out.write("\t\t\t\t});\n");
      out.write("\n");
      out.write("\t\t\t}, 2000);\n");
      out.write("\t\t});\n");
      out.write("\n");
      out.write("\t</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<h1>\n");
      out.write("\tReport Generator\n");
      out.write("</h1>\n");
      out.write("\n");
      out.write("<div id=\"reportLink\">Please Wait While Your Report Is Being Generated</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
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
