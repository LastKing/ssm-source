<%--
  Created by IntelliJ IDEA.
  User: Rain
  Date: 2017/1/12
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = "";
    if (request.getServerPort() == 80) {
        basePath = request.getScheme() + "://" + request.getServerName() + path + "/";
    } else {
        basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }
    request.setAttribute("basePath", basePath);

    String errMsg = (String) request.getAttribute("errMsg");
    if (errMsg == null) {
        errMsg = "";
    }
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=basePath%>resources/css/style.css">
</head>
<body>

模版渲染


</body>
</html>
