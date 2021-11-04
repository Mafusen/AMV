<%@page import="bacit.web.amv_web.AllUsersServlet"%>
<%@ page import="bacit.web.amv_models.UserModel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 15/10/2021
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href = "styles/adminEmployees.css" rel="stylesheet" type = "text/css">
    <title>Title</title>
</head>
<body>
<nav class="navbar">
    <a class="logo" href = productPage.jsp>
        <img src="https://images.squarespace-cdn.com/content/5bcf4baf90f904e66e8eb8bf/1571139220977-8Y75FILX6E39M4ZH8REW/Logo-eng-web-blue.png?content-type=image%2Fpng">
    </a>
    <ul class="nav-links">

        <li class="nav-item"><a href="adminTools.jsp">Admin</a></li>
        <li class="nav-item"><a href="myPage.jsp">Min Side</a></li>
        <li class="nav-item"><a href="bookings.jsp">Bookinger</a></li>
        <li class="nav-item"><a href="login.jsp">Logg ut</a></li>
    </ul>
</nav>
<br><br><br><br>
<nav class="adminTabs">

    <ul class="nav-links">

        <li class="nav-item"><a href="adminEmployees.jsp">Ansatte</a></li>
        <li class="nav-item"><a href="adminTools.jsp">Verktoy</a></li>
        <li class="nav-item"><a href="adminReports.jsp">Rapport</a></li>
    </ul>

</nav>
<form>
    <table>

<%
    List<UserModel> models = (ArrayList)request.getAttribute("model");
    for (UserModel user : models) {
%>
        <tr>
            <th>BrukerID</th>
            <th>Fornavn</th>
            <th>Etternavn</th>
            <th>Tlf</th>
            <th>Brukernavn</th>
            <th>Passord</th>
        </tr>
        <tr>
            <td><%=user.getUserID()%>
            </td>
            <td><%=user.getFirstName()%>
            </td>
            <td><%=user.getLastName()%>
            </td>
            <td><%=user.getPhone()%>
            </td>
            <td><%=user.getUserName()%>
            </td>
            <td><%=user.getPassword()%>
            </td>
        </tr>
        <%
            }
%>
</table>
</form>

<div>
    <br><br><h1>Liste over ansatte:</h1>
</div>
<br><br><br><br><br><br>
<form action = "allUsersServlet" method = "POST">
    <table>
    <tr>
        <th>Fornavn</th>
        <th>Etternavn</th>
        <th>Tlf</th>
        <th>Brukernavn</th>
        </tr>
    <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    </tr>
    </table>
</form>
</body>
</html>
