package org.apache.jsp.WEB_002dINF.views.employees;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class searchEmployee_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\n");
      out.write("\t<title>Create</title>\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/crud.css\" />\n");
      out.write("\t</head>\n");
      out.write("<body>\n");
      out.write("\t<div id=\"header\" class=\"header\">\n");
      out.write("\t\t<div id=\"headerTitle\" class=\"headerTitle\">Employee Contact Manager</div>\n");
      out.write("\t\t<div class=\"subHeader\">\n");
      out.write("\t\t    <div id=\"subHeaderTitle\" class=\"subHeaderTitle\" align=\"right\">Search - Employee Contact</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<form method=\"POST\">\n");
      out.write("\t\t<fieldset>\n");
      out.write("\t        <div class=\"form-row\">\n");
      out.write("\t            <label for=\"userName\">Username:</label>\n");
      out.write("\t            <span class=\"input\"><input id=\"userName\" name=\"userName\" type=\"text\" value=\"\"/></span>\n");
      out.write("\t        </div>\n");
      out.write("\t        \n");
      out.write("\t        <div >\n");
      out.write("\t\t\t\t<input type=\"submit\" id=\"search\" name=\"_eventId_search\" value=\"Search\" />\n");
      out.write("\t\t\t    <input type=\"submit\" id=\"cancel\" name=\"_eventId_cancel\" value=\"Cancel\" />\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</fieldset>\n");
      out.write("\t</form>\n");
      out.write("</body>");
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
