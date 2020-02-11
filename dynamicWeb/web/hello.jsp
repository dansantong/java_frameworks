<%@page contentType="text/html;charset=UTF-8"
        pageEncoding="UTF-8" import="java.util.*"%>

你好 JSP

<br>

<%=new Date().toLocaleString()%>

<%="Hello Tong"%>
<br>
<%out.print("Hello Tong");%>
<br>
<%--下面是java语句--%>
<%
    List<String> words=new ArrayList<String>();
    words.add("aaa");
    words.add("bbb");
    words.add("ccc");
%>

<%--下面是静态html语句--%>
<table width="200px" align="center" border="1" cellspacing="0">
    <%for(String word:words){%>
        <tr>
            <td><%=word%></td>
        </tr>
    <%}%>

</table>
<br>
<%--指令include--%>
<%@include file="foot.jsp"%>
<br>
<%--动作include--%>
<jsp:include page="foot.jsp"/>