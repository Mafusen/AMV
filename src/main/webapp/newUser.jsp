<%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 11/11/2021
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Produkt Side</title>

    <head>
        <link href="<%=request.getContextPath()%>/styles/navbar.css" rel="stylesheet" type="text/css">
        <title></title>

<body>

<nav class="navbar">
    <a class="logo" href= "<%=request.getContextPath()%>/frontpageServlet">
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
<nav class="adminTabs">

    <ul class="nav-links">

        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Users">Ansatte</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Tools">Verktoy</a></li>
        <li class="nav-item"><a href="adminReports.jsp">Rapport</a></li>
    </ul>

</nav>
<main class="container">
    <form action="<%=request.getContextPath()%>/admin/registerUser" method="post">
<br><br>
        <div>
            <label for="firstName">Fornavn: </label>
            <input type="text" name="firstName" id="firstName" required>
        </div>

        <div>
            <label for="lastName">Etternavn: </label>
            <input type="text" name="lastName" id="lastName" required>
        </div>

        <div>
            <label for="phone">Tlf: </label>
            <input type="text" name="phone" id="phone" required>
        </div>

        <div>
            <label for="userName">Brukernavn: </label>
            <input type="text" name="userName" id="userName" required>
        </div>

        <div>
            <label for="passWord">Passord: </label>
            <input type="text" name="passWord" id="passWord" required>
        </div>

        <div>
            <label for="unionMember"> Unionsmedlemm </label>
            <input type="checkbox" name="unionMember" id="unionMember" value="unionMember_value" checked = "checked">
        </div>

        <div>
            <label for="admin"> Administrator </label>
            <input type="checkbox" name="admin" id="admin" value="admin_value" checked = "checked">
        </div>

        <div>
            <label for="lift"> Personløftersertifikat </label>
            <input type="checkbox" name="lift" id="lift" value ="lift_value" checked = "checked">
        </div>

        <div>
            <label for="endDate"> Utgåelses Dato for kurset: </label>
            <input type="date" name="endDate" id="endDate">
        </div>

        <button type="submit" >Registrer ny bruker</button>
    </form>

</main>



</body>

</html>
