/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2023-12-11 13:40:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.chat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Chat_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1699588138000L));
    _jspx_dependants.put("jar:file:/D:/GgulZip/GgulZip/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
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
  }

  public void _jspDestroy() {
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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Chat Application</title>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("    <style>\r\n");
      out.write("        #chat-container {\r\n");
      out.write("            position: fixed;\r\n");
      out.write("            display: none;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("            align-items: flex-end;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #chat-messages {\r\n");
      out.write("            font-size: 12px;\r\n");
      out.write("            overflow-y: auto;\r\n");
      out.write("            max-height: 300px;\r\n");
      out.write("            width: 220px;\r\n");
      out.write("            z-index: 1;\r\n");
      out.write("            position: fixed;\r\n");
      out.write("            top: 20px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #chat-input {\r\n");
      out.write("            position: fixed;\r\n");
      out.write("            bottom: 380px;\r\n");
      out.write("            left: 10px;\r\n");
      out.write("            width: 200px;\r\n");
      out.write("            z-index: 2;\r\n");
      out.write("            height: 30px;\r\n");
      out.write("            display: none;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #chat-input .input-group {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #messageInput {\r\n");
      out.write("            width: calc(100% - 86px);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #sendMessageBtn {\r\n");
      out.write("            width: 86px;\r\n");
      out.write("            margin-top: 3px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #toggleChatBtn {\r\n");
      out.write("            position: fixed;\r\n");
      out.write("            bottom: 300px;\r\n");
      out.write("            left: 10px;\r\n");
      out.write("            z-index: 3;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div id=\"chat-container\">\r\n");
      out.write("        <div id=\"chat-messages\"></div>\r\n");
      out.write("        <div id=\"chat-input\">\r\n");
      out.write("            <div class=\"input-group mb-3\">\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"메세지를 입력하세요\" id=\"messageInput\">\r\n");
      out.write("                <button class=\"btn btn-warning\" type=\"button\" id=\"sendMessageBtn\">전송</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <button class=\"btn btn-warning\" type=\"button\" id=\"toggleChatBtn\">채팅시작</button>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        $(document).ready(function () {\r\n");
      out.write("            var autoScroll = true; // 스크롤 활성화\r\n");
      out.write("            var userName; // 사용자 닉네임 저장 변수\r\n");
      out.write("            var chatInterval; // 채팅 조회 중지용 변수\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("				    // 숨기기\r\n");
      out.write("				    $(\"#chat-container, #sendMessageBtn, #chat-input\").hide();\r\n");
      out.write("				\r\n");
      out.write("				    //  토글 버튼 클릭 이벤트\r\n");
      out.write("					$(\"#toggleChatBtn\").click(function () {\r\n");
      out.write("				    if ($(\"#toggleChatBtn\").text() === \"채팅시작\") {\r\n");
      out.write("				        // 시작 버튼을 눌렀을 때\r\n");
      out.write("				        if (!userName) {\r\n");
      out.write("				            \r\n");
      out.write("				            userName = prompt(\"닉네임을 입력하세요\");\r\n");
      out.write("				        }\r\n");
      out.write("				\r\n");
      out.write("				        // 이름입력후 채팅시작\r\n");
      out.write("				        $(\"#chat-container\").show();\r\n");
      out.write("				        $(\"#toggleChatBtn\").text(\"채팅종료\");\r\n");
      out.write("				        $(\"#sendMessageBtn, #chat-input\").show();\r\n");
      out.write("				\r\n");
      out.write("\r\n");
      out.write("				    } else {\r\n");
      out.write("				        // 최소화 버튼을 눌렀을 때\r\n");
      out.write("				        $(\"#sendMessageBtn, #chat-input\").hide();\r\n");
      out.write("				        $(\"#toggleChatBtn\").text(\"채팅시작\").show();\r\n");
      out.write("					\r\n");
      out.write("				        alert(\"채팅을 다시 하시려면 페이지를 새로고침 하세요\");\r\n");
      out.write("				        // 채팅창 비우기\r\n");
      out.write("				        stopChatPolling();\r\n");
      out.write("				        clearChatMessages();\r\n");
      out.write("				    }\r\n");
      out.write("				});\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            // 메세지 조회 함수\r\n");
      out.write("            function getChatMessages() {\r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    type: \"POST\",\r\n");
      out.write("                    url: \"selectChat.ch\",\r\n");
      out.write("                    dataType: \"json\",\r\n");
      out.write("                    success: function (response) {\r\n");
      out.write("                        var messagesDiv = $(\"#chat-messages\");\r\n");
      out.write("\r\n");
      out.write("                        // 역순으로 출력\r\n");
      out.write("                        for (var i = response.length - 1; i >= 0; i--) {\r\n");
      out.write("                            var message = response[i];\r\n");
      out.write("                            messagesDiv.append(\"<p><strong>\" + message.chatName + \":</strong> \" + message.chatContent + \" - \" + message.chatDate + \"</p>\");\r\n");
      out.write("                        }\r\n");
      out.write("\r\n");
      out.write("                        if (autoScroll) {\r\n");
      out.write("                            // 자동 스크롤 설정\r\n");
      out.write("                            messagesDiv.scrollTop(messagesDiv.prop(\"scrollHeight\"));\r\n");
      out.write("                            autoScroll = false;\r\n");
      out.write("                        }\r\n");
      out.write("                    },\r\n");
      out.write("                    error: function (error) {\r\n");
      out.write("                        console.log(error);\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            //조회 중지 함수\r\n");
      out.write("            function stopChatPolling() {\r\n");
      out.write("                clearInterval(chatInterval);\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            // 채팅창 비우기\r\n");
      out.write("            function clearChatMessages() {\r\n");
      out.write("                $(\"#chat-messages\").empty();\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            // 전송 버튼 클릭 이벤트\r\n");
      out.write("            $(\"#sendMessageBtn\").click(function () {\r\n");
      out.write("                var messageInput = $(\"#messageInput\");\r\n");
      out.write("                var messageContent = messageInput.val().trim();\r\n");
      out.write("\r\n");
      out.write("                if (messageContent !== \"\") {\r\n");
      out.write("                    $.ajax({\r\n");
      out.write("                        type: \"POST\",\r\n");
      out.write("                        url: \"saveChat.ch\",\r\n");
      out.write("                        data: { chatName: userName, chatContent: messageContent },\r\n");
      out.write("                        success: function (response) {\r\n");
      out.write("                            // 전송 후 조회\r\n");
      out.write("                            getChatMessages();\r\n");
      out.write("                            autoScroll = true; // 메세지 추가되면 스크롤 아래로\r\n");
      out.write("                        },\r\n");
      out.write("                        error: function (error) {\r\n");
      out.write("                            console.log(error);\r\n");
      out.write("                        }\r\n");
      out.write("                    });\r\n");
      out.write("\r\n");
      out.write("                    // 인풋박스 초기화\r\n");
      out.write("                    messageInput.val(\"\");\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            // 자동스크롤 비활성화\r\n");
      out.write("            $(\"#chat-messages\").on(\"scroll\", function () {\r\n");
      out.write("                autoScroll = false;\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
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
}