<%--
  Created by IntelliJ IDEA.
  User: toonew
  Date: 2017/1/13
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${articles}" var="item">
    ${item.id}--${item.title}--${item.content}<br/>
</c:forEach>

</body>
</html>
