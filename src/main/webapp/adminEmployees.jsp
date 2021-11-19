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
    <title>Title</title>
</head>
<body>
<%@include file="jspHelpers/navbarMain.jsp"%>
<br><br><br><br>
<%@include file="jspHelpers/navbarAdmin.jsp"%>

<div class="main">
    <br><br><h1>Side med ansatte</h1>
    <form action = "<%=request.getContextPath()%>/admin/Users" method = "get">
        <div class="search">
            <label>
                <input type="text" name = "search" id = "search" placeholder="Søk etter produkt..">
                <button type = submit>SØK</button>
            </label>
        </div>
    </form>
    <div>
        <a href = "<%=request.getContextPath()%>/admin/newUser">
            <button name = submit type = submit value = submit >Legg til ny bruker</button>
        </a>
    </div>

</div>

<table>
    <%
        List<UserModel> users = (ArrayList<UserModel>) request.getAttribute("users");

        for(UserModel user : users){
            if(user.isActive()){
    %>

    <tr>
        <td>BrukerID: <%=user.getUserID()%></td>
        <td>Brukernavn: <%=user.getUserName()%></td>
        <td>
            <a href = "<%=request.getContextPath()%>/admin/redigerBruker?userID=<%=user.getUserID()%>">
                <button name = submit type = submit value = submit >
                    Rediger bruker
                </button>
            </a>
        </td>
        <td>
            <a href = "<%=request.getContextPath()%>/admin/slettBruker?userID=<%=user.getUserID()%>">
                <button name = submit type = submit value = submit >
                    Slett bruker
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
