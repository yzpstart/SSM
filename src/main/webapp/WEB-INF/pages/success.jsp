<%--
  Created by IntelliJ IDEA.
  User: yu201
  Date: 2020/4/25
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>查寻到账户信息</h1>
<%--遍历的集合items，遍历var--%>
<c:forEach items="${list}" var="account">
    ${account.name}<br/>
</c:forEach>
</body>
</html>
