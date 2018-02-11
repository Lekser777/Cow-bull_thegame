<%--
  Created by IntelliJ IDEA.
  User: Глеб
  Date: 08.02.2018
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>КОРОВА-БЫК</title>
    <link href="Untitled3.css" rel="stylesheet">
    <link href="index3_4.css" rel="stylesheet">
</head>
<body>
<div id="wb_Form1" style="position:absolute;left:226px;top:58px;width:518px;height:339px;z-index:16;">

        <label id="Label1" style="position:absolute;left:173px;top:241px;width:130px;height:81px;line-height:81px;z-index:0;">К<%=session.getAttribute("cows")%>Б<%=session.getAttribute("bulls")%></label>
         <input type="button" id="Button8" name="" value="7" onclick="document.getElementById('Editbox1').value=document.getElementById('Editbox1').value+'7'" style="position:absolute;left:73px;top:132px;width:90px;height:35px;z-index:2;">
        <input type="button" id="Button9" name="" value="8" onclick="document.getElementById('Editbox1').value=document.getElementById('Editbox1').value+'8'" style="position:absolute;left:173px;top:132px;width:90px;height:35px;z-index:3;">
        <input type="button" id="Button10" name="" value="9" onclick="document.getElementById('Editbox1').value=document.getElementById('Editbox1').value+'9'" style="position:absolute;left:274px;top:132px;width:90px;height:35px;z-index:4;">
        <input type="button" id="Button11" name="" value="0" onclick="document.getElementById('Editbox1').value=document.getElementById('Editbox1').value+'0'" style="position:absolute;left:73px;top:177px;width:190px;height:35px;z-index:5;">
        <label id="Label2" style="position:absolute;left:7px;top:297px;width:496px;height:50px;line-height:50px;z-index:6;"><%=session.getAttribute("trystring")%></label>
        <input type="button" id="Button17" name="" value="6" onclick="document.getElementById('Editbox1').value=document.getElementById('Editbox1').value+'6'" style="position:absolute;left:274px;top:87px;width:90px;height:35px;z-index:7;">
        <input type="button" id="Button16" name="" value="5" onclick="document.getElementById('Editbox1').value=document.getElementById('Editbox1').value+'5'" style="position:absolute;left:173px;top:87px;width:90px;height:35px;z-index:8;">
        <input type="button" id="Button15" name="" value="4" onclick="document.getElementById('Editbox1').value=document.getElementById('Editbox1').value+'4'" style="position:absolute;left:73px;top:87px;width:90px;height:35px;z-index:9;">
        <input type="button" id="Button14" name="" value="3" onclick="document.getElementById('Editbox1').value=document.getElementById('Editbox1').value+'3'" style="position:absolute;left:274px;top:42px;width:90px;height:35px;z-index:10;">
        <input type="button" id="Button12" name="" value="1" onclick="document.getElementById('Editbox1').value=document.getElementById('Editbox1').value+'1'" style="position:absolute;left:73px;top:42px;width:90px;height:35px;z-index:11;">
        <input type="button" id="Button13" name="" value="2" onclick="document.getElementById('Editbox1').value=document.getElementById('Editbox1').value+'2'" style="position:absolute;left:173px;top:42px;width:90px;height:35px;z-index:12;">
        <input type="submit" id="Button1" name="" value="clear" onclick="document.getElementById('Editbox1').value=document.getElementById('Editbox1').value.substr(document.getElementById('Editbox1').value.length)" style="position:absolute;left:274px;top:177px;width:90px;height:35px;z-index:15;">
    <form action="game" method="post" id="Form1">
        <input type="text" id="Editbox1" style="position:absolute;left:73px;top:8px;width:281px;height:16px;line-height:16px;z-index:14;" name ="number" readonly>
        <input type="submit" id="Button2" name="" value="Проверить" style="position:absolute;left:73px;top:222px;width:291px;height:36px;z-index:13;">
    </form>
</div>
<label id="Label4" style="position:absolute;left:233px;top:13px;width:496px;height:37px;line-height:37px;z-index:17;">Добро пожаловать , <%=session.getAttribute("username")%></label>
</body>
</html>
