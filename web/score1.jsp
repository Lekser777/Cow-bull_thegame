<%--
  Created by IntelliJ IDEA.
  User: Глеб
  Date: 08.02.2018
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>КОРОВА-БЫК</title>
    <link href="Untitled5.css" rel="stylesheet">
    <link href="index5.css" rel="stylesheet">
</head>
<body>
<div id="wb_Heading1" style="position:absolute;left:320px;top:0px;width:330px;height:42px;z-index:1;">
    <h1 id="Heading1">ТАБЛИЦА РЕЗУЛЬТАТОВ</h1></div>
<label id="Label1" style="position:absolute;left:254px;top:77px;width:594px;height:43px;line-height:43px;z-index:2;"><%=request.getAttribute("scoreboard")%></label>
</body>
</html>
