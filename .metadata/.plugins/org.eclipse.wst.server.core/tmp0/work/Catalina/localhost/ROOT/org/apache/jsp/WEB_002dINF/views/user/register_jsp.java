/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.97
 * Generated at: 2024-01-19 00:43:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/hyeeun/workspace/anotherbites/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/anotherbites/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/C:/hyeeun/workspace/anotherbites/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/anotherbites/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1704265121656L));
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>회원가입</title>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("<link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h1>회원가입</h1>\r\n");
      out.write("	<form class=\"registerForm\" method=\"post\" action=\"/user/register\">\r\n");
      out.write("		<label for=\"id\">아이디</label><input type=\"text\" id=\"userId\" name=\"userId\">\r\n");
      out.write("		<button class=\"idChk\" type=\"button\" id=\"idChk\" onclick=\"fn_idChk();\" value=\"N\">중복확인</button><br><br>\r\n");
      out.write("		<label for=\"userPass\">비밀번호</label><input type=\"password\" id=\"userPass\" name=\"userPass\"><br><br>		\r\n");
      out.write("		<label for=\"pwdCheck\">비밀번호 확인</label><input type=\"password\" id=\"pwdCheck\" name=\"pwdCheck\"><br><br>	\r\n");
      out.write("		<label for=\"name\">이름</label><input type=\"text\" id=\"userName\" name=\"userName\"><br><br>\r\n");
      out.write("		<label for=\"nickname\">닉네임</label><input type=\"text\" id=\"userNickname\" name=\"userNickname\">\r\n");
      out.write("		<button class=\"nicknameChk\" type=\"button\" id=\"nicknameChk\" onclick=\"fn_nicknameChk();\" value=\"N\">중복확인</button><br><br>\r\n");
      out.write("	 	<label for=\"email\">이메일</label>\r\n");
      out.write("	 	<div class=\"input-group\">\r\n");
      out.write("		<input type=\"text\" class=\"form-control\" id=\"email1\">\r\n");
      out.write("		<input type=\"text\" class=\"form-control\" id=\"email2\" readonly>\r\n");
      out.write("		<input type=\"hidden\" class=\"form-control\" name=\"userEmail\" id=\"userEmail\">\r\n");
      out.write("			<select class=\"form-control\" id=\"selectEmail\" >\r\n");
      out.write("				<option>@naver.com</option>\r\n");
      out.write("				<option>@daum.net</option>\r\n");
      out.write("				<option>@gmail.com</option>\r\n");
      out.write("				<option>@hanmail.com</option>\r\n");
      out.write("				<option>@yahoo.co.kr</option>\r\n");
      out.write("				<option>직접 입력</option>\r\n");
      out.write("			</select>\r\n");
      out.write("		</div>   \r\n");
      out.write("		<br>\r\n");
      out.write("		<label for=\"phone\">휴대폰번호</label><input type=\"tel\" id=\"userTel\" name=\"userTel\"><br><br>\r\n");
      out.write("		<input type=\"text\" id=\"zipCode\" placeholder=\"우편번호\">\r\n");
      out.write("		<input type=\"button\" onclick=\"daumPostcode()\" value=\"우편번호 찾기\"><br>\r\n");
      out.write("		<input type=\"text\" id=\"address1\" placeholder=\"주소\"><br>\r\n");
      out.write("		<input type=\"text\" id=\"address2\" placeholder=\"상세주소\">\r\n");
      out.write("		<input type=\"text\" id=\"address3\" placeholder=\"참고항목\">		\r\n");
      out.write("		<input type=\"hidden\" class=\"form-control\" name=\"userAddr\" id=\"userAddr\">\r\n");
      out.write("		<br>\r\n");
      out.write("		<input id=\"register\" type=\"submit\" value=\"회원가입\">\r\n");
      out.write("	</form>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("	// 주소 저장\r\n");
      out.write("	  $(\"#address1, #address2\").on(\"input\", function() {\r\n");
      out.write("	        var address1 = $(\"#address1\").val();\r\n");
      out.write("	        var address2 = $(\"#address2\").val();\r\n");
      out.write("	        $(\"#userAddr\").val(address1 + address2);\r\n");
      out.write("	    }); \r\n");
      out.write("	 \r\n");
      out.write("	// 이메일 직접 입력 활성화\r\n");
      out.write("	 $(\"#selectEmail\").on(\"change\", function(){\r\n");
      out.write("		    if ($(this).val() == \"직접 입력\") {\r\n");
      out.write("		        $(\"#email2\").attr(\"readonly\", false);\r\n");
      out.write("		        $(\"#email2\").val(\"\");\r\n");
      out.write("		    } else {\r\n");
      out.write("		        $(\"#email2\").attr(\"readonly\", true);\r\n");
      out.write("		        $(\"#email2\").val($(this).val());\r\n");
      out.write("		    }   \r\n");
      out.write("		    emailPlus();\r\n");
      out.write("		});\r\n");
      out.write("	\r\n");
      out.write("	 $(\"#email2\").on(\"input\", function(){\r\n");
      out.write("		 emailPlus();\r\n");
      out.write("	 });\r\n");
      out.write("	\r\n");
      out.write("	// 이메일 저장\r\n");
      out.write("	function emailPlus() {\r\n");
      out.write("		if ($(\"#email1\").val() != \"\" && $(\"#email2\").val() != \"\" ) {\r\n");
      out.write("			$(\"#userEmail\").val($(\"#email1\").val() + $(\"#email2\").val());		\r\n");
      out.write("		}\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("$(\"#register\").on(\"click\", function(){\r\n");
      out.write("\r\n");
      out.write("		\r\n");
      out.write("		if($(\"#userId\").val()==\"\"){\r\n");
      out.write("			alert(\"아이디를 입력해주세요.\");\r\n");
      out.write("			$(\"#userId\").focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		} \r\n");
      out.write("\r\n");
      out.write("		let idval = $('#userId').val()\r\n");
      out.write("	    let idvalcheck = /^[a-z0-9]+$/\r\n");
      out.write("	    if (!idvalcheck.test(idval) || idval.length<6){\r\n");
      out.write("	    	alert('아이디는 영소문자, 숫자로 구성된 6글자 이상으로 조합하시오.')\r\n");
      out.write("	        $('#userId').focus()\r\n");
      out.write("	        return false;\r\n");
      out.write("	    }		\r\n");
      out.write("		\r\n");
      out.write("		if($(\"#idChk\").val() == \"N\"){\r\n");
      out.write("			alert(\"아이디 중복확인 버튼을 눌러주세요.\");\r\n");
      out.write("			return false;\r\n");
      out.write("		}	\r\n");
      out.write("		\r\n");
      out.write("		if($(\"#userPass\").val()==\"\"){\r\n");
      out.write("			alert(\"비밀번호를 입력해주세요.\");\r\n");
      out.write("			$(\"#userPass\").focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		if($(\"#pwdCheck\").val()==\"\"){\r\n");
      out.write("			alert(\"비밀번호를 한번 더 입력해주세요.\");\r\n");
      out.write("			$(\"#pwdCheck\").focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		if($(\"#pwdCheck\").val()!=$(\"#userPass\").val()){\r\n");
      out.write("			alert(\"비밀번호가 다릅니다.\");\r\n");
      out.write("			$(\"#pwdCheck\").focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		if($(\"#userName\").val()==\"\"){\r\n");
      out.write("			alert(\"성명을 입력해주세요.\");\r\n");
      out.write("			$(\"#userName\").focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		if($(\"#userNickname\").val()==\"\"){\r\n");
      out.write("			alert(\"닉네임을 입력해주세요.\");\r\n");
      out.write("			$(\"#userNickname\").focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		}		\r\n");
      out.write("		if($(\"#userEmail\").val()==\"\"){\r\n");
      out.write("			alert(\"이메일을 입력해주세요.\");\r\n");
      out.write("			$(\"#email1\").focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		} else {\r\n");
      out.write("			 emailPlus();\r\n");
      out.write("		}\r\n");
      out.write("		if($(\"#userTel\").val()==\"\"){\r\n");
      out.write("			alert(\"휴대폰번호를 입력해주세요.\");\r\n");
      out.write("			$(\"#userTel\").focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		if($(\"#zipcode\").val()==\"\"){\r\n");
      out.write("			alert(\"우편번호를 입력해주세요.\");\r\n");
      out.write("			$(\"#zipcode\").focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		$(\".registerForm\").submit();	\r\n");
      out.write("		\r\n");
      out.write("		alert(\"회원가입이 완료되었습니다.\");\r\n");
      out.write("		\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	// 아이디 중복체크\r\n");
      out.write("	function fn_idChk(){\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url : \"/user/idChk\",\r\n");
      out.write("			type : \"post\",\r\n");
      out.write("			dataType : \"json\",\r\n");
      out.write("			data : {\"userId\" : $(\"#userId\").val()},\r\n");
      out.write("			success : function(data){\r\n");
      out.write("				if(data == 1){\r\n");
      out.write("					alert(\"사용 중인 아이디입니다.\");\r\n");
      out.write("					return false;\r\n");
      out.write("				}else if(data == 0){\r\n");
      out.write("					$(\"#idChk\").attr(\"value\", \"Y\");\r\n");
      out.write("					alert(\"사용가능한 아이디입니다.\");\r\n");
      out.write("				}\r\n");
      out.write("			}\r\n");
      out.write("		})\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	// 닉네임 중복체크\r\n");
      out.write("	 function fn_nicknameChk(){\r\n");
      out.write("		\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url : \"/user/nicknameChk\",\r\n");
      out.write("			type : \"post\",\r\n");
      out.write("			dataType : \"json\",\r\n");
      out.write("			data : {\"userNickname\" : $(\"#userNickname\").val()},\r\n");
      out.write("			success : function(data){\r\n");
      out.write("				if(data == 1){\r\n");
      out.write("					alert(\"사용 중인 닉네임입니다.\");\r\n");
      out.write("				}else if(data == 0){\r\n");
      out.write("					$(\"#nicknameChk\").attr(\"value\", \"Y\");\r\n");
      out.write("					alert(\"사용가능한 닉네임입니다.\");\r\n");
      out.write("				}\r\n");
      out.write("			}\r\n");
      out.write("		})\r\n");
      out.write("	} \r\n");
      out.write("\r\n");
      out.write("	   function daumPostcode() {\r\n");
      out.write("	        new daum.Postcode({\r\n");
      out.write("	            oncomplete: function(data) {\r\n");
      out.write("	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.\r\n");
      out.write("\r\n");
      out.write("	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.\r\n");
      out.write("	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.\r\n");
      out.write("	                var addr = ''; // 주소 변수\r\n");
      out.write("	                var extraAddr = ''; // 참고항목 변수\r\n");
      out.write("\r\n");
      out.write("	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.\r\n");
      out.write("	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우\r\n");
      out.write("	                    addr = data.roadAddress;\r\n");
      out.write("	                } else { // 사용자가 지번 주소를 선택했을 경우(J)\r\n");
      out.write("	                    addr = data.jibunAddress;\r\n");
      out.write("	                }\r\n");
      out.write("\r\n");
      out.write("	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.\r\n");
      out.write("	                if(data.userSelectedType === 'R'){\r\n");
      out.write("	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)\r\n");
      out.write("	                    // 법정동의 경우 마지막 문자가 \"동/로/가\"로 끝난다.\r\n");
      out.write("	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){\r\n");
      out.write("	                        extraAddr += data.bname;\r\n");
      out.write("	                    }\r\n");
      out.write("	                    // 건물명이 있고, 공동주택일 경우 추가한다.\r\n");
      out.write("	                    if(data.buildingName !== '' && data.apartment === 'Y'){\r\n");
      out.write("	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);\r\n");
      out.write("	                    }\r\n");
      out.write("	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.\r\n");
      out.write("	                    if(extraAddr !== ''){\r\n");
      out.write("	                        extraAddr = ' (' + extraAddr + ')';\r\n");
      out.write("	                    }\r\n");
      out.write("	                    // 조합된 참고항목을 해당 필드에 넣는다.\r\n");
      out.write("	                    document.getElementById(\"address3\").value = extraAddr;\r\n");
      out.write("	                \r\n");
      out.write("	                } else {\r\n");
      out.write("	                    document.getElementById(\"address3\").value = '';\r\n");
      out.write("	                }\r\n");
      out.write("\r\n");
      out.write("	                // 우편번호와 주소 정보를 해당 필드에 넣는다.\r\n");
      out.write("	                document.getElementById('zipCode').value = data.zonecode;\r\n");
      out.write("	                document.getElementById(\"address1\").value = addr;\r\n");
      out.write("	                // 커서를 상세주소 필드로 이동한다.\r\n");
      out.write("	                document.getElementById(\"address2\").focus();\r\n");
      out.write("	            }\r\n");
      out.write("	        }).open();\r\n");
      out.write("	    }\r\n");
      out.write("	</script>\r\n");
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
