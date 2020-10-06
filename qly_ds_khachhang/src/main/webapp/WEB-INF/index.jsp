<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 05/10/2020
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>test</h1>

<a href="/customers">Back to list</a>.

<%
    List<Customer> customers = (List<Customer>) request.getAttribute("customers");
%>

</body>
</html>
