<%@ page import="bacit.web.Models.UserModel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 15/10/2021
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href = "<%=request.getContextPath()%>/styles/navbar.css" rel="stylesheet" type = "text/css">
    <link href="<%=request.getContextPath()%>/styles/adminEmployees.css" rel="stylesheet" type="text/css">
    <title>Title</title>
</head>
<body>
<nav class="navbar">
    <a class="logo" href = "<%=request.getContextPath()%>/frontpageServlet">
        <img src="https://images.squarespace-cdn.com/content/5bcf4baf90f904e66e8eb8bf/1571139220977-8Y75FILX6E39M4ZH8REW/Logo-eng-web-blue.png?content-type=image%2Fpng">
    </a>
    <ul class="nav-links">

        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Tools">Admin</a></li>
        <li class="nav-item"><a href="myPage.jsp">Min Side</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/bookingHistoryServlet">Bookinger</a></li>
        <li class="nav-item"><a style="padding-right: 30px" href="<%=request.getContextPath()%>/logOut">Logg ut</a></li>
    </ul>
</nav>
<br><br><br><br>
<nav2 class="navbar2">

    <ul class="nav-links">

        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Users">Ansatte</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Tools">Verktoy</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/report">Rapport</a></li>
    </ul>

</nav2>

<div class="main">
    <br><h1>Oversikt over brukere</h1>
    <div>
        <a href = "<%=request.getContextPath()%>/admin/newUser">
            <button class="button1" name = submit type = submit value = submit >Legg til ny bruker</button>
        </a>
    </div>
</div>

<table id="users">
    <tr>
        <th>Bruker-ID</th>
        <th>Brukernavn</th>
        <th>Etternavn</th>
        <th>Fornavn</th>
    </tr>
    <%
        List<UserModel> users = (ArrayList<UserModel>) request.getAttribute("users");
        for(UserModel user : users){
    %>
    <tr>

        <td><%=user.getUserID()%></td>
        <td><%=user.getUserName()%></td>
        <td><%=user.getLastName()%></td>
        <td><%=user.getFirstName()%></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>