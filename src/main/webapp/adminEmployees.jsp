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
<%@include file="jspHelpers/navbarMain.jsp"%>
<br><br><br><br>
<%@include file="jspHelpers/navbarAdmin.jsp"%>

<div class="main">
    <br><br><h1>Oversikt over brukere</h1>
    <form action = "<%=request.getContextPath()%>/admin/Users" method = "get">
        <div class="search">
            <label>
                <input type="text" name = "search" id = "search" placeholder="Søk etter ansatt..">
                <button type = submit>SØK</button>
            </label>
        </div>
    </form>
    <div>
        <a href = "<%=request.getContextPath()%>/admin/newUser">
            <button class = "button1" name = submit type = submit value = submit >Legg til ny bruker</button>
        </a>
    </div>
<br>
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
            if(user.isActive()){
    %>
    <tr>
        <td><%=user.getUserID()%></td>
        <td><%=user.getUserName()%></td>
        <td><%=user.getLastName()%></td>
        <td><%=user.getFirstName()%></td>
        <td>
            <a href = "<%=request.getContextPath()%>/admin/redigerBruker?userID=<%=user.getUserID()%>">
                <button name = submit type = submit value = submit >
                    Rediger
                </button>
            </a>
        </td>
        <td>
            <a href = "<%=request.getContextPath()%>/admin/slettBruker?userID=<%=user.getUserID()%>">
                <button name = submit type = submit value = submit >
                    Slett
                </button>
            </a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>