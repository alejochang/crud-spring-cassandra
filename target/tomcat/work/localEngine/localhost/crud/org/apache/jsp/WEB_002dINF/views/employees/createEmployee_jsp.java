package org.apache.jsp.WEB_002dINF.views.employees;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class createEmployee_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<script language=\"JavaScript\" type=\"text/javascript\">\n");
      out.write("\t<!--\n");
      out.write("\tfunction getGenderSelected(selGender)\n");
      out.write("\t{\n");
      out.write("\t\tvar hdnGender = document.getElementById('gender');\n");
      out.write("\t\t\n");
      out.write("\t\tvar selIndex = selGender.selectedIndex;\n");
      out.write("\t\thdnGender.value = selGender.options[selIndex].value;\n");
      out.write("\t}\n");
      out.write("\t//-->\n");
      out.write("\t</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div id=\"header\" class=\"header\">\n");
      out.write("\t\t<div id=\"headerTitle\" class=\"headerTitle\">Employee Contact Manager</div>\n");
      out.write("\t\t<div class=\"subHeader\">\n");
      out.write("\t\t    <div align=\"right\">Create - Employee Contact</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<form method=\"POST\">\n");
      out.write("\t\t<input id=\"gender\" name=\"gender\" type=\"hidden\" value=\"OTHER\" />\n");
      out.write("\t\t<fieldset>\n");
      out.write("\t        <div class=\"form-row\">\n");
      out.write("\t            <label for=\"userName\">Username:</label>\n");
      out.write("\t            <span class=\"input\"><input id=\"userName\" name=\"userName\" type=\"text\" value=\"\"/></span>\n");
      out.write("\t        </div>\n");
      out.write("\t        <div class=\"form-row\">\n");
      out.write("\t            <label for=\"firstName\">First Name:</label>\n");
      out.write("\t            <span class=\"input\"><input id=\"firstName\" name=\"firstName\" type=\"text\" value=\"\"/></span>\n");
      out.write("\t        </div>\n");
      out.write("\t        <div class=\"form-row\">\n");
      out.write("\t            <label for=\"lastName\">Last Name:</label>\n");
      out.write("\t            <span class=\"input\"><input id=\"lastName\" name=\"lastName\" type=\"text\" value=\"\"/></span>\n");
      out.write("\t        </div>\n");
      out.write("\t        <div class=\"form-row\">\n");
      out.write("\t            <label for=\"birthDate\">Birth Date (YYYY-DD-MM):</label>\n");
      out.write("\t            <span class=\"input\"><input id=\"birthDate\" name=\"birthDate\" type=\"text\" value=\"\"/></span>\n");
      out.write("\t        </div>\n");
      out.write("\t        <div class=\"form-row\">\n");
      out.write("\t            <label for=\"selGender\">Gender:</label>\n");
      out.write("\t            <span class=\"input\">\n");
      out.write("\t            \t<select id=\"selGender\" onchange=\"getGenderSelected(this);\">\n");
      out.write("\t\t\t\t\t\t<option value=\"OTHER\">-</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"FEMALE\">Female</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"MALE\">Male</option>\n");
      out.write("\t            \t</select>\n");
      out.write("\t            </span>\n");
      out.write("\t        </div>\n");
      out.write("\t        <div class=\"form-row\">\n");
      out.write("\t            <label for=\"hireDate\">Hire Date (YYYY-DD-MM):</label>\n");
      out.write("\t            <span class=\"input\"><input id=\"hireDate\" name=\"hireDate\" type=\"text\" value=\"\"/></span>\n");
      out.write("\t        </div>\n");
      out.write("\t        <div class=\"form-row\">\n");
      out.write("\t            <label for=\"position\">Position:</label>\n");
      out.write("\t            <span class=\"input\"><input id=\"position\" name=\"position\" type=\"text\" value=\"\"/></span>\n");
      out.write("\t        </div>\n");
      out.write("\t        <div class=\"form-row\">\n");
      out.write("\t            <label for=\"active\">Active:</label>\n");
      out.write("\t            <span class=\"input\"><input id=\"active\" name=\"active\" type=\"checkbox\" checked=\"checked\"/></span>\n");
      out.write("\t        </div>\n");
      out.write("\t        <div >\n");
      out.write("\t\t\t\t<input type=\"submit\" id=\"save\" name=\"_eventId_save\" value=\"Save\" />\n");
      out.write("\t\t\t    <input type=\"submit\" id=\"cancel\" name=\"_eventId_cancel\" value=\"Cancel\" />\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</fieldset>\n");
      out.write("\t</form>\n");
      out.write("</body>\n");
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
