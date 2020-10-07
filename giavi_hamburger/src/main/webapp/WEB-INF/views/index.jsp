<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07-Oct-20
  Time: 08:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
 <form method="post" action="/save">
  Lettuce <input type="checkbox" name="sauce" value="Lecttuce">
  Tomato <input type="checkbox" name="sauce" value="Tomato">
  Mustard <input type="checkbox" name="sauce" value="Mustard">
  Sprouts <input type="checkbox" name="sauce" value="Sprouts">

   <input type="submit" value="save">
 </form>


      <p>Hamburgur's sauce:</p>
      <p>${result}</p>

  </body>
</html>
