<%--
  Created by IntelliJ IDEA.
  User: Глеб
  Date: 08.02.2018
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>КОРОВА-БЫК</title>
    <link href="Untitled4.css" rel="stylesheet">
    <link href="index4.css" rel="stylesheet">
</head>
<body>
<div id="wb_Heading1" style="position:absolute;left:208px;top:4px;width:453px;height:42px;z-index:1;">
    <h1 id="Heading1">ПОЗДРАВЛЯЕМ ! ВЫ ВЫИГРАЛИ!</h1></div>
<label  id="Label1" style="position:absolute;left:216px;top:298px;width:258px;height:29px;line-height:29px;z-index:2;">Ваш результат : <%=session.getAttribute("trynumber")%></label>
<label  id="Label2" style="position:absolute;left:216px;top:335px;width:428px;height:29px;line-height:29px;z-index:3;">Ваше среднее количество попыток : <%=session.getAttribute("score")%></label>
<a href="game1.jsp"><label  id="Label3" style="position:absolute;left:325px;top:399px;width:211px;height:29px;line-height:29px;z-index:4;">Начать новую игру</label></a>>
<div id="wb_Image1" style="position:absolute;left:199px;top:46px;width:400px;height:250px;z-index:6;">
    <img src="superkorova.jpg" id="Image1" alt=""></div>
<div id="wb_Form1" style="position:absolute;left:213px;top:426px;width:442px;height:76px;z-index:7;">
    <form action="score" method="post">
        <input type="submit" id="Button1"  value="Посмотреть таблицу чемпионов" style="position:absolute;left:42px;top:19px;width:358px;height:38px;z-index:0;">
    </form>
</div>
</body>
</html>
