<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 06/10/2020
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
  <form method="post">
    Lecttuce <input type="checkbox" name="condiment" value="Lecttuce" placeholder="Lecttuce"/>
    Tomato <input type="checkbox" name="condiment" value="Tomato" placeholder="Tomato" />
    Mustard <input type="checkbox" name="condiment" value="Mustard" placeholder="Mustard"/>
    Sprouts <input type="checkbox" name="condiment" value="Sprouts" placeholder="Sprouts"/>
  <input type="submit" value="save">
  </form>

  <c:forEach var="s" items="condiment" varStatus="count">
 <p>${s.[count.count]}</p>

  </c:forEach>


  </body>
</html>
