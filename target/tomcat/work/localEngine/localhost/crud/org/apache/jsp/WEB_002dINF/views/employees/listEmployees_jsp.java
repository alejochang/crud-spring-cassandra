package org.apache.jsp.WEB_002dINF.views.employees;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class listEmployees_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("\t\t\n");
      out.write("\t\t<title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${app_name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</title>\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/crud.css\" />\n");
      out.write("\t</head>\n");
      out.write("\t\n");
      out.write("  \t<body >\n");
      out.write("  \t<div id=\"header\" class=\"header\">\n");
      out.write("\n");
      out.write("\t<div id=\"headerTitle\" class=\"headerTitle\">Employee Contact Manager</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"subHeader\">\n");
      out.write("\t    <div id=\"subHeaderTitle\" class=\"subHeaderTitle\" align=\"right\">Home</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t</div>\n");
      out.write("   \t\t<div >\n");
      out.write("\t\t    <div id=\"main\">\n");
      out.write("\t    \t\t<form method=\"POST\">\n");
      out.write("\t\t\t\t\t<div >\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" id=\"create\" name=\"_eventId_create\" value=\"Create\" />\n");
      out.write("\t\t\t\t        <input type=\"submit\" id=\"search\" name=\"_eventId_search\" value=\"Search\" />\n");
      out.write("\t\t\t\t        <input type=\"submit\" id=\"cancel\" name=\"_eventId_cancel\" value=\"Cancel\" />\n");
      out.write("\t\t\t\t     </div>\n");
      out.write("\t\t\t\t</form> \n");
      out.write("\t\t    </div>\t\t    \n");
      out.write("\t\t</div>\n");
      out.write("\t</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
