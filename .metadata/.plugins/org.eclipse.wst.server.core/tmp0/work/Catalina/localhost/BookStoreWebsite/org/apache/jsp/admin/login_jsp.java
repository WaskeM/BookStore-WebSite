/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.27
 * Generated at: 2019-12-10 21:01:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/vaske/BookStoreProject/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BookStoreWebsite/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153377882000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1574169153669L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Admin Login</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js\" ></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#headermenu {\r\n");
      out.write("\tdisplay: table;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#headermenu div {\r\n");
      out.write("\tdisplay: table-cell;\r\n");
      out.write("\tpadding-right: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:link {\r\n");
      out.write("\tcolor: cornflowrBLue;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:visited {\r\n");
      out.write("\tcolor: indigo;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:hover {\r\n");
      out.write("\tcolor: blue;\r\n");
      out.write("\ttext-decoration: underline;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:active {\r\n");
      out.write("\tcolor: red;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#headermenu a:link {\r\n");
      out.write("\tfont-size: larger;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".pageheading {\r\n");
      out.write("\tcolor: darkblue;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table {\r\n");
      out.write("\tborder: 1px solid black;\r\n");
      out.write("\tborder-collapse: collapse\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th, td {\r\n");
      out.write("\tpadding: 8px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th {\r\n");
      out.write("\tbackground: darkblue;\r\n");
      out.write("\tcolor: cornsilk;\r\n");
      out.write("\tfont-size: larger;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table.form {\r\n");
      out.write("\tborder: 0;\r\n");
      out.write("\tpadding: 4px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button {\r\n");
      out.write("\tpadding: 6px;\r\n");
      out.write("\tborder-radius: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button[type=submit] {\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button:hover {\r\n");
      out.write("\tbackground-color: white;\r\n");
      out.write("\tcolor: green;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input {\r\n");
      out.write("\tborder: 1px solid;\r\n");
      out.write("\tborder-radius: 4px;\r\n");
      out.write("\tborder-color: green;\r\n");
      out.write("\theight: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".message {\r\n");
      out.write("\tfont-style: italic;\r\n");
      out.write("\tcolor: blue;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".error {\r\n");
      out.write("\tcolor: red;\r\n");
      out.write("\tmargin: 5px;\r\n");
      out.write("\tfont-style: italic;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<h1>Book Store Administration</h1>\r\n");
      out.write("\t\t<h2>Admin Login</h2>\r\n");
      out.write("\t\t\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<form action=\"login\" id=\"loginForm\" method=\"post\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>Email:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"email\" id=\"email\" size=\"20\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>Password:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"password\" name=\"password\" id=\"password\" size=\"20\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"2\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\">Login</button>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script> type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t$(\"#loginForm\").validate({\r\n");
      out.write("\t\t\trules:{\r\n");
      out.write("\t\t\t\temail:{\r\n");
      out.write("\t\t\t\t\trequired: true,\r\n");
      out.write("\t\t\t\t\temail:true\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tpassword: \"required\",\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmessages: {\r\n");
      out.write("\t\t\t\temail: {\r\n");
      out.write("\t\t\t\t\temail:\"Please enter an valid email address!\",\r\n");
      out.write("\t\t\t\t\trequired: \"Please enter email!\",\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tpassword: \"Please enter password!\",\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /admin/login.jsp(106,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message != null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t<div align=\"center\">\r\n");
          out.write("\t\t\t<h4 class=\"message\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</h4>\r\n");
          out.write("\t\t</div>\r\n");
          out.write("\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }
}
